import java.util.*;

public class CareTaker {
    private Stack undoList;
    private Stack redoList;
    private Stack undoCommand;
    private Stack redoCommand;
    private boolean firstundo;
    private boolean firstredo;

    // constructor
    public CareTaker( ) {
        undoList = new Stack();
        redoList = new Stack();
        undoCommand = new Stack<String>();
        redoCommand = new Stack<String>();
    }

    public void pushToy(ToyProduct tp, String msg) {
        // Use for push the elements
        undoList.push(new Memento(tp));
        undoCommand.push(msg);
        firstundo = true;
        firstredo = true;
    }

    public void undo() {
        // User to undo
        if(firstundo&&!undoList.isEmpty()){
            Memento m = (Memento)undoList.pop();
            redoList.push(m);
            firstundo = false;          
        }

        // push to redoList, and pop out the element of undoList, then restore
        if(!undoList.isEmpty()){
            Memento m = (Memento)undoList.pop();
            redoList.push(m);
            m.restore();
        }

        // push to undoCommand
        if(!undoCommand.isEmpty()){
            String message = (String)undoCommand.pop();
            System.out.println(message);
            redoCommand.push(message);
        }
    }

    public void redo() {
        // User to redo
        if(firstredo&&!redoList.isEmpty()){
            Memento m = (Memento)redoList.pop();
            undoList.push(m);
            firstredo = false;
        }
        
        // push to redoCommand
        // push to undoList, and pop out the element of redoList, then restore
        if(!redoList.isEmpty()){
            Memento m = (Memento)redoList.pop();
            undoList.push(m);
            m.restore();

            if(!redoCommand.isEmpty()){
                String message = (String)redoCommand.pop();
                System.out.println(message);
                undoCommand.push(message);
            }
        }
    }
       
    // get method
    public Stack getunCommand(){
        return (Stack)this.undoCommand.clone();
    }
    
    // get method
    public Stack getreCommand(){
        return (Stack)this.redoCommand.clone();
    }
}
