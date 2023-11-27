package net.shuaiwu.pattern.command;

/**
 * 控制器
 *
 * @author shuaiwu
 * @date 2023-11-27 15:29
 */
public class RemoteControl {

    private Command[] onCommands;
    private Command[] offCommands;

    private Command undoCommand;

    public RemoteControl(){
        onCommands = new Command[7];
        offCommands = new Command[7];

        Command c = new NoCommand();
        for (int i = 0; i < 7; i++) {
            onCommands[i] = c;
            offCommands[i] = c;
        }

        undoCommand = c;
    }

    public void setCommand(int solt, Command onCommand, Command offCommand){
        onCommands[solt] = onCommand;
        offCommands[solt] = offCommand;
    }

    public void onButtonClick(int solt){
        onCommands[solt].execute();
        undoCommand = onCommands[solt];
    }

    public void offButtonClick(int solt){
        offCommands[solt].execute();
        undoCommand = onCommands[solt];
    }

    public void undoButtomClick(){
        undoCommand.undo();
    }

    public String toString(){
        StringBuffer s = new StringBuffer();
        for (int i = 0; i < onCommands.length; i++) {
            s.append("\n------RemoteControl-----\n");
            s.append("[solt "+i+"] ")
                .append(onCommands[i].getClass().getName()).append(" ")
                .append(offCommands[i].getClass().getName()).append(" \n");
        }
        return s.toString();
    }
}
