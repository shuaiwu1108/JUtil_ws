package net.shuaiwu.netty;

import net.shuaiwu.netty.client.TimeClient;
import net.shuaiwu.netty.server.DiscardServer;
import net.shuaiwu.netty.server.TimeServer;

/**
 * Netty工具类
 *
 * @author shuaiwu
 * @date 2023-11-16 9:55
 */
public class NettyUtil {

    public static void main(String[] args) throws Exception {
//        new DiscardServer(9000).run();
        new TimeServer(9001).run();
    }
}
