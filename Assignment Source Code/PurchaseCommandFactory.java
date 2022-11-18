import java.util.Scanner;
import java.util.Vector;
import java.util.Stack;

public class PurchaseCommandFactory implements CommandFactory
{
    Vector toys;
    Scanner sc;
    CareTaker ct;
    
    // constructor
    public PurchaseCommandFactory(Vector toys, Scanner sc, CareTaker ct){
        this.toys = toys;
        this.sc = sc;
        this.ct = ct;
    }
    
    public Command createCommand() {
        return new PurchaseCommand(toys, sc, ct);     
    }
} 

// factory class to return new purchase command ( use in main class )
