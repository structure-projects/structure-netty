package cn.structure.netty.filter;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;


/**
 * <p>
 * socketServer初始化
 * </p>
 *
 * @author chuck
 * @version 1.0.1
 * @since 2021/7/19 10:16
 */
public class SocketServerInitialzer extends ChannelInitializer<SocketChannel> {

    public SocketServerInitialzer() {
    }

    public SocketServerInitialzer(ChannelHandler channelHandler) {
        this.channelHandler = channelHandler;
    }

    private ChannelHandler channelHandler;

    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {

        ChannelPipeline pipeline = socketChannel.pipeline();
        pipeline.addLast("decoder", new StringDecoder());
        pipeline.addLast("encoder", new StringEncoder());
        pipeline.addLast("handler", channelHandler);
    }
}
