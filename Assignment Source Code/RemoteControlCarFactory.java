import java.util.Scanner;

// This class is use for user input data to create RemoteControlCar Toy
public class RemoteControlCarFactory implements ToyProductFactory {
    public ToyProduct createToyProduct(Scanner sc) {
        System.out.println("Enter id, name and maxSpeed(km/hr): ");
        sc.nextLine();
        String buffer = sc.nextLine();
        // array to get the three data in one line
        String[] loc = buffer.split(",");
        int productID = Integer.parseInt(loc[0]);
        String name = loc[1];
        double maxSpeed = Double.parseDouble(loc[2]);
        System.out.println("New toy product record created.");
        return new RemoteControlCar(productID, name, maxSpeed);
    }
}
