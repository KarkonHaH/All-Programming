import java.util.Scanner;

// This class is use for user input data to create Robot Toy
public class RobotFactory implements ToyProductFactory {
    public ToyProduct createToyProduct(Scanner sc) {
        System.out.println("Enter id, name and height(cm): ");
        sc.nextLine();
        String buffer = sc.nextLine();
        // array to get the three data in one line
        String[] loc = buffer.split(",");
        int productID = Integer.parseInt(loc[0]);
        String name = loc[1];
        double height = Double.parseDouble(loc[2]); 

        System.out.println("New toy product record created.");
        return new Robot(productID, name, height);
    }
}
