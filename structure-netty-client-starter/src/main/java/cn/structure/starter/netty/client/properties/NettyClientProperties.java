package cn.structure.starter.netty.client.properties;

/**
 * <p>
 *
 * </p>
 *
 * @author chuck
 * @version 1.0.1
 * @since 2021/9/6 16:15
 */
public class NettyClientProperties {

    private String url = "127.0.0.1";

    private String channelHandler;

    private String encode = "stringEncoder";

    private String decode = "stringDecoder";

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getChannelHandler() {
        return channelHandler;
    }

    public void setChannelHandler(String channelHandler) {
        this.channelHandler = channelHandler;
    }

    public String getEncode() {
        return encode;
    }

    public void setEncode(String encode) {
        this.encode = encode;
    }

    public String getDecode() {
        return decode;
    }

    public void setDecode(String decode) {
        this.decode = decode;
    }
}