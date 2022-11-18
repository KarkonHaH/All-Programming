import java.util.Scanner;
import java.util.Vector;

public class PrintCommandFactory implements CommandFactory {
    Vector toys;
    Scanner sc;
    
    // constructor
    public PrintCommandFactory(Vector toys, Scanner sc){
        this.toys = toys;
        this.sc = sc;
    }
    
    public Command createCommand() {      
        return new PrintCommand(toys, sc);
    } 
}

// Use for return print command
