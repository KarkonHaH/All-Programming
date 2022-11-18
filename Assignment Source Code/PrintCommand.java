import java.util.*;

public class PrintCommand implements Command {    
    Vector toys;
    Scanner sc;
    ToyProduct pr;
    String Index;

    // constructor
    public PrintCommand(Vector toys, Scanner sc){
        this.toys = toys;
        this.sc = sc;
        this.pr = null;
    }

    public void execute() {
        // Ask User input * or ID
        System.out.println("Enter ID (* to display all) ");
        Index = sc.next();

        if(Index.equals("*")) {
            // If input * after ask, print all elements in Vector
            System.out.println("Toy product information ");
            Enumeration toy = toys.elements();
            while(toy.hasMoreElements()){
                ToyProduct product = (ToyProduct)toy.nextElement();
                System.out.println(product);
            }
        } else {
            Enumeration toy = toys.elements();
            while(toy.hasMoreElements()){
                ToyProduct product = (ToyProduct)toy.nextElement();
                int Intproduct = product.getProductID(); // int value to get the id of product
                int Intindex = Integer.parseInt(Index); 
                // int value to make input value (String) become Int for compare
                
                // Use if to compare the input value and the id of product in Vector
                // If exist, print it out
                if(Intindex == Intproduct) { 
                    System.out.println(product);
                    break; 
                }
            }
        }            
    }

}
