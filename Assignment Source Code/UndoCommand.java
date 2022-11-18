public class UndoCommand implements Command {
    private CareTaker ct;

    // constructor
    public UndoCommand(CareTaker ct) {
        this.ct = ct;
    }
    
    public void execute() {
        ct.undo();
    }
}

// this class user caretaker method to do undo