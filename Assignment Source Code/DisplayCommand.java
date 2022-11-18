import java.util.*;

public class DisplayCommand implements Command {
    Stack undoCommand;
    Stack redoCommand;

    // constructor
    public DisplayCommand(Stack undoCommand, Stack redoCommand) {
        this.undoCommand = undoCommand;
        this.redoCommand = redoCommand;
    }

    public void execute() {
        // if the undo or redo list is empty, print empty
        // else print elements of the list
        
        System.out.println("Undo List:");
        if(undoCommand.size() > 0){
            System.out.println(undoCommand);
        } else {
            System.out.println("Empty");
        }

        System.out.println("\nRedo List:");
        if(redoCommand.size() > 0){
            System.out.println(redoCommand);
        } else {
            System.out.println("Empty");
        }
    }

}
// class for show undo and redo list
