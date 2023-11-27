package net.shuaiwu.pattern.command;

/**
 * 宏命令
 *
 * @author shuaiwu
 * @date 2023-11-27 16:05
 */
public class MacroCommand implements Command {

    private Command[] commands;

    public MacroCommand(Command[] c) {
        this.commands = c;
    }

    @Override
    public void execute() {
        for (Command command : commands) {
            command.execute();
        }
    }

    @Override
    public void undo() {
        for (Command command : commands) {
            command.undo();
        }
    }
}
