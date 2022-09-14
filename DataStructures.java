/**
 * DataStructures
 */
public class DataStructures {

    public static void main(String[] args) {
        StackArray stack = new StackArray();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }

    static class StackArray{
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

}
