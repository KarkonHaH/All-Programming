import java.util.*;

public class CreateToyCommandFactory implements CommandFactory
{
    Vector toys;
    Scanner sc;
    Stack commands;
    CareTaker ct;

    // constructor
    public CreateToyCommandFactory(Vector toys, Scanner sc, Stack commands, 
    CareTaker ct) {
        this.toys = toys;
        this.sc = sc;
        this.commands = commands;
        this.ct = ct;
    }

    public Command createCommand() {
        Command c = new CreateToyCommand(toys, sc, ct);
        commands.push(c);
        return c;
    }
}
// Factory Class for return command create toy
