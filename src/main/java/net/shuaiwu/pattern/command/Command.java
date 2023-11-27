package net.shuaiwu.pattern.command;

/**
 * 命令模式
 *
 * @author shuaiwu
 * @date 2023-11-27 14:35
 */
public interface Command {

    public void execute();

    public void undo();
}
