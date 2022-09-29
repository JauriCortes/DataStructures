package List;

public class LinkedListGeneric<J> {

    private NodeGeneric<J> head;
    private NodeGeneric<J> newNode;
    private NodeGeneric<J> ref;
    //constructor
    public LinkedListGeneric() {
        head = null;
    }
    //add method
    public void addFront(J data) {
        if (head != null) {
            newNode = new NodeGeneric<J>(data);
            newNode.setNext(head);
            
            head = newNode;
        }
        else {
            head = new NodeGeneric<J>(data);
        }
    }
    
    public void addBack(J data) {
        
        newNode = new NodeGeneric<J>(data);

        if (head != null) {
            ref = head;
            while(ref.getNext() != null) {
                ref = ref.getNext();
            }
            ref.setNext(newNode);
        }
        else {
            head = newNode;    
        }

    }

    //print method
    public void printList() {
        ref = head;
        while(ref != null) {
            System.out.println(ref.getData());
            ref = ref.getNext();
        }
    }
}
