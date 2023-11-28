package net.shuaiwu.pattern.state;

/**
 * 状态接口
 *
 * @author shuaiwu
 * @date 2023-11-28 17:03
 */
public interface State {

    void insertQuarter();

    void ejectQuarter();

    void turnCrank();

    void dispense();
}
