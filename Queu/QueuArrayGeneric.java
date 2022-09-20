package Queu;


public class QueuArrayGeneric<T> {
    private final int N = 4;
    private int front, rear, count;
    private T[] qarray;

    public QueuArrayGeneric() {
        front = rear = count = 0;
        qarray = (T[]) new Object[N];
    }

    public T dequeu() {
        T item = null;
        if(empty()) {
            throw new RuntimeException("Queue is empty: " + "item not dequed");
        }
        item = qarray[front];
        front = (front + 1) % N;
        count--;

        return item;
    }

    public void enqueu(T item) {
        if(full()) {
            throw new RuntimeException("Queu is full: "+"item not enqued");
        }
        qarray[rear] = item;
        rear = (rear + 1) % N;
        count++;
    }

    public boolean empty() {
        return count <= 0;
    }
    public boolean full() {
        return count >= N;
    }
    public int getCount() {
        return count;
    }
}
