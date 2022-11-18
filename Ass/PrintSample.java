/*
 * Class : PrintSample
 * Description : Just text can or can not read file
 * @Name : Chan Pak Lam
 * @StdID: 200074680
 * @Class: IT114105/1C
 * @2021-04-08
 * 
 * I understand the meaning of academic dishonesty, in particular plagiarism, copyright
 * infringement and collusion. I am aware of the consequences if found to be involved in
 * these misconducts. I hereby declare that the work submitted for the “ITP4510 Data
 * Structures & Algorithms” is authentic record of my own work.
 * 
 */

import java.util.*;
import java.io.*;

public class PrintSample {

    public PrintSample() throws FileNotFoundException {
        this("Sample.java");
    }

    public PrintSample(String filename) throws FileNotFoundException {
        Scanner fin = new Scanner(new File(filename));
        String line;
        int countline = 0;
        System.out.print("SOURCE FILE: " + filename + "\n000");
        while (fin.hasNextLine()) {
            line = fin.nextLine();
            if(countline > 0)
                for(int star = 3;countline < Math.pow(10,star);star--)
                    System.out.print(0);

            System.out.println(countline++ + " : " + line);
        }
    }
}
