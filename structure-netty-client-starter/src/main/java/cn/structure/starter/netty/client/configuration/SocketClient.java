package cn.structure.starter.netty.client.configuration;

import cn.structure.netty.core.ClientChannel;
import cn.structure.starter.netty.client.properties.NettyClientProperties;
import cn.structure.starter.netty.client.properties.SocketClientProperties;
import io.netty.channel.ChannelHandler;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * nettyClient
 * </p>
 *
 * @author chuck
 * @version 1.0.1
 * @since 2021/9/6 14:10
 */
@AutoConfigureAfter(SocketClientProperties.class)
public class SocketClient implements ApplicationListener<ContextRefreshedEvent> {

    @Resource
    private SocketClientProperties socketClientProperties;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        this.applicationContext = contextRefreshedEvent.getApplicationContext();
        if(! ClientConfig.getInitStatus()) {
            independent();
            ClientConfig.init();
        }
    }

    private void independent() {
        List<NettyClientProperties> clients = socketClientProperties.getClients();
        if (null == clients) {
            return;
        }
        clients.forEach(nettyClientProperties -> {
            try {
                ChannelHandler channelHandler = (ChannelHandler) this.getBean(nettyClientProperties.getChannelHandler());
                ChannelHandler deCode = (ChannelHandler) this.getBean(nettyClientProperties.getDecode());
                ChannelHandler enCode = (ChannelHandler) this.getBean(nettyClientProperties.getEncode());
                String url = nettyClientProperties.getUrl();
                String[] urlList = url.split(",");
                for (int i = 0; i < urlList.length; i++) {
                    String[] subUrl = urlList[i].split(":");
                    String host = subUrl[0];
                    int port = Integer.parseInt(subUrl[1]);
                    ClientChannel.connectClient(host,port, channelHandler, deCode, enCode);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }

    private ApplicationContext applicationContext;


    //获取applicationContext
    public ApplicationContext getApplicationContext() {
        return this.applicationContext;
    }

    //通过name获取 Bean.
    public Object getBean(String name){
        return getApplicationContext().getBean(name);
    }
}
