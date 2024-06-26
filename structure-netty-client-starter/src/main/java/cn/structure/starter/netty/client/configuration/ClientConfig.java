package cn.structure.starter.netty.client.configuration;

/**
 * <p>
 *  客户端配置
 * </p>
 *
 * @author chuck
 * @version 1.0.1
 * @since 2021/9/10 0:42
 */
public class ClientConfig {

    /**
     * 是否初始化
     */
    private static boolean isInit = false;

    public static void init(){
        isInit = true;
    }

    public static boolean getInitStatus() {
        return isInit;
    }

}
