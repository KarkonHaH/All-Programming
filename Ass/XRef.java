/*
 * Class : XRef
 * Description : Create to read file and check each of the line
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
public class XRef {
    static StringComparator c = new StringComparator();
    static LinkedList redbeans1 = new LinkedList(c);
    static LinkedList redbeans2 = new LinkedList(c);
    private static String[] Words = {
            "abstract","assert","boolean","break","byte","case","catch","char","class","const", 
            "continue","default","do","double","else","enum","extends","final","finally",
            "float","for","goto","if","implements","import","instanceof","int","interface",
            "long","native","new","package","private","protected","public","return",
            "short","static","strictfp","super","switch","synchronized","this","throw",
            "throws","transient","try","void","volatile","while",""," ","0","1","2","3",
            "5", "6", "7", "8", "9", "10"
        };
    private static final String
    DELIMITER = "\"(?:\\\\\"|[^\"])*?\"|[\\s.,;:+*/|!=><@?#%&(){}\\-\\^\\[\\]\\&&]+";

    public static void main(String [ ] args) throws FileNotFoundException {
        String filename = args[0];  // String filename to args[0]
        int countline = 1;
        Scanner fin = new Scanner(new File(filename)); 
        String[] Get = null;
        String line; // create for read line of file
        System.out.println("SOURCE FILE: " + filename);

        while(fin.hasNextLine()){ // loop util file have not line 
            line = fin.nextLine();  // line take every line of file
            System.out.println(String.format("%04d", countline) + ":" + line);
            Get = tokenizer(line);  

            check(Get); // check match or not
            redbeans1.mix(Get,countline); //  from LinkedList Class
            countline++;
        }
        for(int i=0; i<Get.length; i++) {
            System.out.println(Get[i]);
        }
        System.out.println("CROSS REFERENCE:");
        redbeans1.PrintColumn(); // print reult
    }

    public static String[] tokenizer(String javaStmt) {
        String[] tokens = javaStmt.split(DELIMITER);
        return tokens;
    }

    public static void check(String[] tokens){ // check match or not
        boolean NotMatch = true;     // boolean  NotMatch true
        for(int i=0; i<tokens.length; i++){  // read all elements
            for(int j=0; j<Words.length; j++){  // read all elements
                if(tokens[i].equals(Words[j])){  // if element equal
                    NotMatch = false;            // be false
                }
            }
            if(redbeans1.search(tokens[i]) && NotMatch) // if search element and NotMatch
                redbeans1.insertInOrder(tokens[i]);  // redbeans1, insert in the middle
            // or addToTail addToHead
            NotMatch = true;
        }
    }
}
