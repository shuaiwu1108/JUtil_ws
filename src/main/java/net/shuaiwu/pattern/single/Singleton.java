package net.shuaiwu.pattern.single;

/**
 * 单例模式
 *
 * @author shuaiwu
 * @date 2023-11-27 11:37
 */
public class Singleton {
    private volatile static Singleton singleton; // 如果使用急切实例化，能解决多线程安全问题

    private Singleton(){

    }

    /**
     * 有效率问题
     * @return
     */
    public static synchronized Singleton getInstance() {
        if (singleton == null){
            singleton = new Singleton();
        }
        return singleton;
    }

    /**
     * 双重检查加锁，解决了同步问题
     * @return
     */
    public static Singleton getInstance2() {
        if (singleton == null){
            synchronized (Singleton.class){
                if (singleton == null){
                    singleton = new Singleton(); // 只有第一次执行会进入
                }
            }
        }
        return singleton;
    }
}
