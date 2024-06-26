package cn.structure.example.netty.client;

import cn.structure.netty.core.ClientChannel;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.Log4JLoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * <p>
 *
 * </p>
 *
 * @author chuck
 * @version 1.0.1
 * @since 2021/7/19 11:47
 */
@Component
@Qualifier("socketHandler")
@ChannelHandler.Sharable
public class SocketHandler extends SimpleChannelInboundHandler {

    private static  final InternalLogger log = Log4JLoggerFactory.getInstance(ClientChannel.class);

    public SocketHandler() {
        super();
    }

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, Object o) throws Exception {
        log.info("SocketHandler" + o.toString());
    }


}
