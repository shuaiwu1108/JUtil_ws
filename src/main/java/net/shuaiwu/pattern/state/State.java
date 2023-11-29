package net.shuaiwu.pattern.state;

import java.io.Serializable;

/**
 * 状态接口
 *
 * @author shuaiwu
 * @date 2023-11-28 17:03
 */
public interface State extends Serializable {

    void insertQuarter();

    void ejectQuarter();

    void turnCrank();

    void dispense();
}
