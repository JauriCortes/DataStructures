package Stack;



import java.util.Scanner;

/**
 * StackArray
 */
public class StackArray {

    public static void main(String[] args) {
        int number;
        StackArray stack = new StackArray(5);

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println();
            System.out.println("Enter an integer or a -1 to stop: ");
            number = scanner.nextInt();
            while (number >= 0 && !stack.full()) {
                stack.push(number);
                System.out.println("Enter an integer or a -1 to stop: ");
                number = scanner.nextInt();
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
        private int stack_array[];
    
        public StackArray() {
            this(N);
        }
        public StackArray(int n) {
            top = 0;
            stack_array = new int[n];
        }
        public boolean full() {
            return top >= stack_array.length;
        }
        public boolean empty() {
            return top == 0;
        }

        public void push(int i) {
            if(full())
                throw new RuntimeException("Stack is full");
            
            stack_array[top] = i;
            top++;
        }
        public int pop() {
            if(empty()) 
                System.out.println("Stack is empty");
    
            top--;
            return stack_array[top];
    
        }

}
