



public class StackArrayGeneric<T>{

    private static final int N = 3;
    private int top;
    private T[] stack_array;

    public StackArrayGeneric() {
        this(N);
    }
    public StackArrayGeneric(int n) {
        top = 0;
        stack_array = (T[]) new Object[n];
    }

    public boolean full() {
        return top >= stack_array.length;
    }
    public boolean empty() {
        return top == 0;
    }

    public void push(T i) {
        if(full())
            throw new RuntimeException("Stack is full");
        
        stack_array[top] = i;
        top++;
    }
    public T pop() {
        if(empty()) 
            System.out.println("Stack is empty");

        top--;
        return stack_array[top];

    }

}
