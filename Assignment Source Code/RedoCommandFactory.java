public class RedoCommandFactory implements CommandFactory {
    private CareTaker ct;
    
    // constructor
    public RedoCommandFactory(CareTaker ct) {
        this.ct = ct;
    }
    
    public Command createCommand() {
        return new RedoCommand(this.ct);
    }
}

// Class for reutrn new RedoCommand
