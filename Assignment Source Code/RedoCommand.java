public class RedoCommand implements Command {
    private CareTaker ct;

    // constructor
    public RedoCommand(CareTaker ct) {
        this.ct = ct;
    }
    
    public void execute() {
        ct.redo();
    }
}

// this class user caretaker method to do redo
