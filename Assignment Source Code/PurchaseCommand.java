import java.util.Scanner;
import java.util.Vector;
import java.util.Enumeration;
import java.util.Stack;

public class PurchaseCommand implements Command {
    Scanner sc;
    int quantity; 
    double cost;
    int prid;
    Vector toys;
    ToyProduct pr; 
    CareTaker ct;

    // constructor
    public PurchaseCommand(Vector toys, Scanner sc, CareTaker ct) {
        this.toys = toys;
        this.sc = sc;
        this.pr = null;
        this.ct = ct;
    }

    public void execute(){
        // ask id 
        System.out.println("Enter code: ");
        prid = sc.nextInt();

        Enumeration toy = toys.elements(); 

        while(toy.hasMoreElements()){
            this.pr = (ToyProduct)toy.nextElement();
            int Proid = pr.getProductID(); // int value to get the id of product

            // check if equal, stop to ask
            if(prid == Proid) { 
                break;
            }    
        }   

        // ask user to input quantity and cost of purchase 
        System.out.println("Quantity to be purchased: ");
        quantity = sc.nextInt();
        System.out.println("Purchasing cost: ");
        cost = sc.nextDouble();
      
        // Use set method of ToyProduct Class to change value
        pr.setQty(quantity);
        pr.setCost(cost);

        // Print result after change
        System.out.println("Purchased "+ quantity + " boxes of " + pr.getName() + ". " + 
            " Current quantity is " + pr.getQty() + ". " + " Current cost is $ " + 
            pr.getCost() + ". " + " Price is $ " + pr.getPrice() + ".");

        // push the change value and String toString() method comment to undoList
        ct.pushToy(pr,toString());
    }

    // Use for push comment
    public String toString() {
        return "Purchase "+quantity+ " "+prid+" "+pr.getName()+" "+pr.getCost();
    }
}
