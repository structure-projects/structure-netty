package cn.structure.example.netty.server;

import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.nio.channels.Channel;

/**
 * <p>
 * netty测试控制器
 * </p>
 *
 * @author chuck
 * @version 1.0.1
 * @since 2021/9/6 16:51
 */
@RestController
@RequestMapping(value = "/test")
public class NettyTestController {

//    @Autowired
//    private ChannelHandlerContext channelHandlerContext;

    @GetMapping("/send")
    public String sendMsg(@RequestParam("msg") String msg){
       // channelHandlerContext.writeAndFlush(msg);
        ChannelManager.sendMsg(msg);
        return "OK";
    }

}
