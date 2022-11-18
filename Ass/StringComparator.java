/*
 * Class : StringComparator
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

public class StringComparator implements Comparator { 
    public boolean isEqualTo (Object item1, Object item2) {
        if (((String) item1).compareTo((String) item2) == 0)
            return true;
        else
            return false;
    }

    public boolean isLessThanOrEqualTo (Object item1, Object item2) {
        if (((String) item1).compareTo((String) item2) <= 0)
            return true;
        else
            return false;
    }
    
    public boolean isGreaterThan (Object item1, Object item2) {
        if (((String) item1).compareTo((String) item2) > 0)
            return true;
        else
            return false;
    }
    
    public boolean isGreaterThanOrEqualTo (Object item1, Object item2) {
        if (((String) item1).compareTo((String) item2) >= 0)
            return true;
        else
            return false;
    }

}

