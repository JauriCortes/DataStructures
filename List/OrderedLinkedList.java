package List;

public class OrderedLinkedList {

    NodeGeneric<Integer> head;
    OrderedLinkedList() {
        this.head = new NodeGeneric<Integer>();
    }

    public boolean insert(int item) {
        boolean inserted;
        NodeGeneric<Integer> ptr, prev;

        inserted = false;
        ptr = head;
        prev = null;

        while(ptr != null && ptr.getData() < item) {
            prev = ptr;
            ptr = ptr.getNext();
        }
        if (ptr == null || ptr.getData() != item) {
            inserted = true;
            NodeGeneric<Integer> newp = new NodeGeneric<Integer>();

            newp.setData(item);
            newp.setNext(ptr);

            if (prev == null) {
                head = newp;
            }
            else {
                prev.setNext(newp);
            }
        }
        return inserted;
    }
}
