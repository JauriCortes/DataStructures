package Queu;


public class QueuArrayGeneric<T> {
    private static final int N = 4;
    private int front, rear, count;
    private T[] qarray;

    public QueuArrayGeneric() {
        this(N);
    }
    public QueuArrayGeneric(int n) {
        front = rear = count = 0;
        qarray = (T[]) new Object[n];
    }

    public T dequeu() {
        T item = null;
        if(empty()) {
            throw new RuntimeException("Queue is empty: " + "item not dequed");
        }
        item = qarray[front];
        front = (front + 1) % qarray.length;
        count--;

        return item;
    }

    public void enqueu(T item) {
        if(full()) {
            throw new RuntimeException("Queu is full: "+"item not enqued");
        }
        qarray[rear] = item;
        rear = (rear + 1) % qarray.length;
        count++;
    }

    public boolean empty() {
        return count <= 0;
    }
    public boolean full() {
        return count >= qarray.length;
    }
    public int getCount() {
        return count;
    }
}
