public class UndoCommandFactory implements CommandFactory {
    private CareTaker ct;
    
    // constructor
    public UndoCommandFactory(CareTaker ct) {
        this.ct = ct;
    }
    
    public Command createCommand() {
        return new UndoCommand(this.ct);
    }
}

// Class for return undo command
