import java.util.*;

public class SellToyProductCommandFactory implements CommandFactory
{
    Vector toys;
    Scanner sc;
    CareTaker ct;
    
    // constructor
    public SellToyProductCommandFactory(Vector toys, Scanner sc, CareTaker ct){
        this.toys = toys;
        this.sc = sc;
        this.ct = ct;
    }
    
    public Command createCommand() {
        return new SellToyProductCommand(toys, sc, ct);     
    }
}

// factory class to return new sell command ( use in main class )
