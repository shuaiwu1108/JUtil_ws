package net.shuaiwu.pattern.mvc;

/**
 * 心跳测试
 *
 * @author shuaiwu
 * @date 2023-12-01 8:49
 */
public class HeartTestDrive {

    public static void main(String[] args) {
        HeartModel heartModel = new HeartModel();
        ControllerInterface model = new HeartController(heartModel);
    }
}
