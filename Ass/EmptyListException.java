/*
 * Class : EmptyListException
 * Description : Download from moodle 
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

public class EmptyListException extends RuntimeException {
    public EmptyListException() {
        super("List is empty.");
    }
}
