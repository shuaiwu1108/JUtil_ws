package net.shuaiwu;

import net.shuaiwu.net.NetworkRequest;
import net.shuaiwu.netty.client.TimeClient;

/**
 * 主函数，提供了main方法入口
 *
 * @author shuaiwu
 * @date 2023-11-16 9:25
 */
public class Action {

    public static void main(String[] args) throws Exception {
        new TimeClient().run(new String[]{"127.0.0.1", "9001"});
        NetworkRequest.start("http://127.0.0.1:9000/test", "GET", 5000, 10000);
    }
}
