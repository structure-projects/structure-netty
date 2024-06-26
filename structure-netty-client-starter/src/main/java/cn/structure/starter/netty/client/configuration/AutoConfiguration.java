package cn.structure.starter.netty.client.configuration;

import cn.structure.starter.netty.client.properties.SocketClientProperties;
import io.netty.channel.ChannelHandler;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * <p>
 * 自动装配类
 * </p>
 *
 * @author chuck
 * @version 1.0.1
 * @since 2021/7/19 10:11
 */
@Configuration
@EnableConfigurationProperties(value = {SocketClientProperties.class})
public class AutoConfiguration {

    @Bean
    public ChannelHandler stringEncoder(){
        return new StringEncoder();
    }

    @Bean
    public ChannelHandler stringDecoder(){
        return new StringDecoder();
    }

}
