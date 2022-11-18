import java.util.*;

public class RunAssignment {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws ClassNotFoundException, 
    InstantiationException, IllegalAccessException {
        Vector toys = new Vector(); 
        Stack commands = new Stack(); 
        Stack undoList = new Stack();
        Stack redoList = new Stack();
        CareTaker ct = new CareTaker();

        HashMap<String, CommandFactory> f = new HashMap<>();
        f.put("c", new CreateToyCommandFactory(toys, sc, commands, ct));
        f.put("d", new PrintCommandFactory(toys, sc));
        f.put("p", new PurchaseCommandFactory(toys, sc, ct));
        f.put("s", new SellToyProductCommandFactory(toys, sc, ct));
        f.put("u", new UndoCommandFactory(ct));
        f.put("r", new RedoCommandFactory(ct));
        f.put("l", new DisplayCommandFactory(ct));
        f.put("x", new ExitCommandFactory());

        String command;

        while (true) {
            System.out.println(
                "Toy Inventory Management System (TIMS)");
            System.out.println("Please enter command: [c | d | p | s | u | r | l | x]");
            System.out.println("c = create toy, d = display toy, p = purchase toy, s = sell toy,");
            System.out.println("u = undo, r = redo, l = list undo/redo, x = exit system");

            command = sc.next();

            try{
                Command com = f.get(command).createCommand(); 
                com.execute();  
            } catch(NullPointerException e) {
                System.out.println("Command not found, please enter again.");        
                System.out.println(" ");   
            }        
        }     
    }
}

