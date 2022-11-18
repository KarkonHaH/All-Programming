import java.util.*;
import java.util.Scanner;

public class TestCase4 {
    public static void main(String [ ] args) {
        Scanner keyboard = new Scanner(System.in);
        double num;
        double result;
        double sum=0;

        for(int i=0; i>=5; i++) {
            System.out.print("Number? ");
            num = keyboard.nextDouble();
            result = i*sum;
            sum = sum+num;
            System.out.println("Result = " + result);
        }      
    }
}
