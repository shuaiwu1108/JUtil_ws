package net.shuaiwu.pattern.command;

/**
 * 不执行的命令
 *
 * @author shuaiwu
 * @date 2023-11-27 15:30
 */
public class NoCommand implements Command{

    @Override
    public void execute() {
        System.out.println("NoCommand execute");
    }

    @Override
    public void undo() {
        System.out.println("NoCommand undo");
    }
}
