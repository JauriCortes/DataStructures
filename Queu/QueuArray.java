package Queu;


public class QueuArray {
    private final int N = 4;
    private int front, rear, count, qarray[];

    public QueuArray() {
        front = rear = count = 0;
        qarray = new int[N];
    }

    public int dequeu() {
        int item;
        if(empty()) {
            throw new RuntimeException("Queue is empty: " + "item not dequed");
        }
        item = qarray[front];
        front = (front + 1) % N;
        count--;

        return item;
    }

    public void enqueu(int item) {
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
}
