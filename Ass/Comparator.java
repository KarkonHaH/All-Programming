/*
 * Class : Comparator
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


public interface Comparator {
    public abstract boolean isEqualTo (Object item1, Object item2);
    //public abstract boolean isLessThan (Object item1, Object item2);
    public abstract boolean isLessThanOrEqualTo (Object item1, Object item2);
    public abstract boolean isGreaterThan (Object item1, Object item2);
    public abstract boolean isGreaterThanOrEqualTo (Object item1, Object item2);
}

