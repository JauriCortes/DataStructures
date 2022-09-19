



import java.util.Scanner;

/**
 * StackArray
 */
public class StackArrayGeneric<T>{

    public static void main(String[] args) {
        int number;
        StackArrayGeneric <Integer> stack = new StackArrayGeneric <Integer>();

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println();
            number = 0;

            while (number >= 0 && !stack.full()) {
                System.out.println("Enter an integer or a -1 to stop: ");
                number = scanner.nextInt();
                stack.push(number);
            }
        }
        
        System.out.println();
        System.out.print("the reverse integers are: ");
        while(!stack.empty())
            System.out.print(stack.pop() + " ");
        System.out.println();
        System.out.println();
    }

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
