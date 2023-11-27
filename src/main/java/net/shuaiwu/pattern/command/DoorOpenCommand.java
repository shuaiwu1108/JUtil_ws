package net.shuaiwu.pattern.command;

/**
 * 开门命令
 *
 * @author shuaiwu
 * @date 2023-11-27 14:44
 */
public class DoorOpenCommand implements Command{
    private Door door;

    public DoorOpenCommand(Door d){
        this.door = d;
    }

    @Override
    public void execute() {
        door.up();
    }

    @Override
    public void undo() {
        door.down();
    }
}
