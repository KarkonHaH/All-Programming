import java.util.*;

public class SellToyProductCommand implements Command {
    Scanner sc;
    int sellquantity, price;
    int prid;
    Vector toys;
    ToyProduct pr; 
    CareTaker ct;

    // constructor
    public SellToyProductCommand(Vector toys, Scanner sc, CareTaker ct) {
        this.toys = toys;
        this.sc = sc;
        this.pr = null;
        this.ct = ct;
    }

    public void execute(){
        // ask id
        System.out.println("Enter code: ");
        prid = sc.nextInt();
        
        // ask sell quantity and price of toy
        System.out.println("Quantity to be sold: ");
        sellquantity = sc.nextInt();
        System.out.println("Selling price: ");
        price = sc.nextInt();

        Enumeration toy = toys.elements();

        while(toy.hasMoreElements()){
            this.pr = (ToyProduct)toy.nextElement();
            int Proid = pr.getProductID(); // int value to get the id of product

            // if equal, use set method of ToyProduct Class to set sell quantity and price
            if(prid == Proid) { 
                int NewQty = pr.getQty() - sellquantity;
                pr.setQty(NewQty);
                pr.setPrice(price);

                // print result after change
                System.out.println("Sold " + sellquantity + " boxes of " + pr.getName() + ". Current quantity is " + 
                pr.getQty() + ". Selling price is $ " + pr.getPrice()); 
                   
                // push the change value and String toString() method comment to undoList
                ct.pushToy(pr, toString());
            }            
        }      
    }
    
    // Use for push comment
    public String toString() {
        return "Sell "+sellquantity+ " "+prid+" "+pr.getName()+" "+price;
    }
}

