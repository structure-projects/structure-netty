package cn.structure.starter.netty.client.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * <p>
 * socket配置
 * </p>
 *
 * @author chuck
 * @version 1.0.1
 * @since 2021/7/19 10:25
 */
@Configuration
@ConfigurationProperties(value = "structure.netty.socket.client")
public class SocketClientProperties {

    private List<NettyClientProperties> clients;

    public List<NettyClientProperties> getClients() {
        return clients;
    }

    public void setClients(List<NettyClientProperties> clients) {
        this.clients = clients;
    }
}