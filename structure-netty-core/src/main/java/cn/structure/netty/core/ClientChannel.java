package cn.structure.netty.core;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.Log4JLoggerFactory;

/**
 * <p>
 * 客户端管理类
 * </p>
 *
 * @author chuck
 * @version 1.0.1
 * @since 2021/9/6 14:15
 */

public class ClientChannel {

    private static  final InternalLogger log = Log4JLoggerFactory.getInstance(ClientChannel.class);


    public static void connectClient(String host,int port,ChannelHandler channelHandler,ChannelHandler decode,ChannelHandler encode) throws InterruptedException {
        EventLoopGroup eventLoopGroup = new NioEventLoopGroup();
        Bootstrap bootstrap = new Bootstrap();
        bootstrap.group(eventLoopGroup).channel(NioSocketChannel.class)  // 使用NioSocketChannel来作为连接用的channel类
                .handler(new ChannelInitializer<SocketChannel>() { // 绑定连接初始化器
                    @Override
                    public void initChannel(SocketChannel ch) throws Exception {
                        log.info("Connecting in progress ...");
                        ChannelPipeline pipeline = ch.pipeline();
                        pipeline.addLast(encode); //编码request
                        pipeline.addLast(decode); //解码response
                        pipeline.addLast(channelHandler); //客户端处理类
                    }
                });
        //发起异步连接请求，绑定连接端口和host信息
        //发起异步连接请求，绑定连接端口和host信息
        final ChannelFuture future = bootstrap.connect(host, port).sync();

        future.addListener(new ChannelFutureListener() {

            @Override
            public void operationComplete(ChannelFuture arg0) throws Exception {
                if (future.isSuccess()) {
                    log.info("Connecting to the server successfully ");
                } else {
                    log.info("Failed to connect to server");
                    future.cause().printStackTrace();
                    eventLoopGroup.shutdownGracefully(); //关闭线程组
                }
            }
        });
    }
}
