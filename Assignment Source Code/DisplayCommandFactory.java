import java.util.*;

public class DisplayCommandFactory implements CommandFactory {
    CareTaker ct;
    
    // constructor
    public DisplayCommandFactory(CareTaker ct) {
        this.ct = ct;
    }
    
    public Command createCommand() {
        return new DisplayCommand(ct.getunCommand(),ct.getreCommand());
    }
}

// Class for return display list elements command
