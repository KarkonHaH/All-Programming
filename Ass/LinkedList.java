/*
 * Class : LinkedList
 * Description : Download from moodle but add some method for use to XRef
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

public class LinkedList {
    private ListNode head;
    private ListNode tail;
    private Comparator comparator;

    public LinkedList(Comparator comparator) {
        head = tail = null;
        this.comparator = comparator;
    }

    public boolean isEmpty() {
        return (head==null);
    }

    public void addToHead(Object item) {
        if (isEmpty()) {
            head = tail = new ListNode(item);
        } else {
            head = new ListNode(item, head);
        }
    }

    public void addToTail(Object item) {
        if (isEmpty()) {
            head = tail = new ListNode(item);
        } else {
            tail.next = new ListNode(item);
            tail =  tail.next;
        }
    }

    public Object removeFromHead() throws EmptyListException {
        Object item = null;
        if (isEmpty()) {
            throw new EmptyListException();
        } 
        item = head.data;
        if (head == tail)      // there's only one single node
            head = tail = null;
        else
            head = head.next;
        return item;

    }

    public Object removeFromTail() throws EmptyListException {
        if (isEmpty()) {
            throw new EmptyListException();
        } 
        Object item = tail.data;
        if (head == tail) {   // there is only one node
            head = tail = null;
            return item;
        }
        ListNode current = head;
        while (current.next != tail)
            current = current.next;
        tail = current;
        tail.next = null;
        return item;
    }

    public String toString() {
        String s = "[ ";
        ListNode current = head;
        while (current != null) {
            s += current.data + " ";
            current = current.next;
        }
        return s + "]";
    }

    public void insertInOrder (Object item) {
        if (isEmpty()) {
            head = tail = new ListNode (item);
        } else {
            if (comparator.isGreaterThanOrEqualTo(head.data, item)) {
                addToHead(item);
            } else if (comparator.isLessThanOrEqualTo(tail.data, item)) {
                addToTail(item);
            } else {
                // insert in the middle
                ListNode current = head;
                while (current.next != null) {
                    if (comparator.isGreaterThanOrEqualTo(current.next.data, item)) {
                        ListNode newNode = new ListNode(item);
                        newNode.next = current.next;
                        current.next = newNode;
                        return;
                    }
                    current = current.next;
                }
            }
        }
    }

    public void removeItem (Object item) throws ItemNotFoundException {
        if (isEmpty()) {
            throw new ItemNotFoundException();
        } 
        if (comparator.isEqualTo(head.data, item)) 
            removeFromHead();
        else if (comparator.isEqualTo(tail.data, item)) 
            removeFromTail();
        else {
            // remove a node in the middle
            ListNode current = head;
            while (current.next != null) {
                if (comparator.isEqualTo(current.next.data, item)) {
                    current.next = current.next.next;
                    return;
                }
                current = current.next;
            }
            throw new ItemNotFoundException();
        }
    }	

    public boolean search(String tokens){
        if(isEmpty())       // if empty boolean equal to true
            return true;

        ListNode curr = head;  // Set curr = head

        while(curr!=null){ // Use to check all data of the list ( looping to final loc ) 
            if (!(((String)curr.data).compareTo (tokens) == 0)){   // if the curr data is not equal to tokens, go next loc
                curr = curr.next;
            }else{
                return false;          // if equal, boolean is false
            }
        }
        return true;
    } 

    public void mix(String[] tokens,int count){
        ListNode curr;  

        for(int i=0;i<tokens.length;i++){ // Search all elements
            curr = head; // curr equal head
            while(curr!=null){   // looping util curr is null
                if (!(((String)curr.data).compareTo (tokens[i]) == 0)) {
                    curr = curr.next;  // if curr data not equal to tokens[i]
                                       // go next loc
                }else{
                    LinkedList newNode = new LinkedList(comparator);
                    // Set new linkedlist newNode
                    if (curr.down==null)    // if down is null
                        curr.down = newNode;   // take newNode 
                    curr.down.addToTail(count); // curr.down add element to tail
                    curr = curr.next;   // go next loc
                }
            }
        }
    }

    public void PrintColumn(){ // Print Message
        String s = "";
        LinkedList getdown;
        ListNode findcol = head;
        ListNode findcol2;

        while (findcol != null){  // looping print
            s += findcol.data; 
            s += ":" + " [ ";

            if(findcol.down!=null){   // if down is not null
                getdown = findcol.down;    // getdown take down
                findcol2 = getdown.head;   // findcol2 to be head of getdown
                while(findcol2 != null){    // looping print util null
                    s += findcol2.data + " ";
                    findcol2 = findcol2.next;  
                    System.out.print(s);
                    s = "";
                }
            }else{
                System.out.print(s);  // if is null print nothing
            }
            System.out.println("]");  

            findcol = findcol.next; // go next loc every loop time
        }
    }
}
