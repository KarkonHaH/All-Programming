import java.util.*;

public class CreateToyCommand implements Command {
    String Index;
    Vector toys;
    Scanner sc;
    ToyProduct pr;
    CareTaker ct;
    
    // HashMap to check ro or rc of toy
    HashMap<String, ToyProductFactory> toymap = new HashMap<>();

    // constructor
    public CreateToyCommand(Vector toys, Scanner sc, CareTaker ct) {
        this.toys = toys;
        this.sc = sc;
        this.pr = null;
        this.ct = ct;
        
        // new different factory after user input
        toymap.put("ro", new RobotFactory());
        toymap.put("rc", new RemoteControlCarFactory());
    }

    public void execute() {
        // print ask comment util the input is ro or rc
        do{
            System.out.println("Enter toy type (ro=Robot/rc=Remote Control Car): ");
            Index = sc.next();
            
            // if no, print error and tell user should input ro or rc
            if(!Index.equals("ro")&&!Index.equals("rc")){
                System.out.println("Please enter correct type, ro = Robot / rc = Remote Control Car.");
                System.out.println(" ");  
            }
        }while(!Index.equals("ro")&&!Index.equals("rc"));  

        // push it to Vector
        pr = toymap.get(Index).createToyProduct(sc);
        toys.add(pr);
        
        // push it to undoList
        ct.pushToy(pr, toString());
    }
    
    // Use for push in undoList
    public String toString() {
        return "Create "+Index+" "+pr.getName();
    }
}
