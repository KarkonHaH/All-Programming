import java.util.*;
public class TestCase3 {
    public static void main(String [ ] args) {
        Scanner keyboard = new Scanner(System.in);
        double num1, num2;
        double result;
        System.out.print("Number1? ");
        num1 = keyboard.nextInt();
        System.out.print("Number2? ");
        num2 = keyboard.nextInt();
        
        result = num1 + num2;
        System.out.println("Result = " +result); 
    }
}