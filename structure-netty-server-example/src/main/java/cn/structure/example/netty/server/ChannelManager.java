package cn.structure.example.netty.server;

import io.netty.channel.Channel;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;

/**
 * <p>
 *
 * </p>
 *
 * @author chuck
 * @version 1.0.1
 * @since 2021/9/6 16:59
 */
public class ChannelManager {

    static ChannelGroup group = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

    public static void addChannel (Channel channel) {
        group.add(channel);
    }

    public static void sendMsg(Object obj) {
        group.writeAndFlush(obj);
    }

}
