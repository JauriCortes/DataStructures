/**
 * QueNoAbrir
 */
public class QueNoAbrir {

    public static void main(String[] args) {
        System.out.println("hola!");
    }

    public class StackArray{
        public final int N = 3;
        private int top;
        private int stack_array[];
    
        public StackArray() {
            top = 0;
            stack_array = new int[N];
        }
        public boolean full() {
            return top >= stack_array.length;
        }
        public boolean empty() {
            return top == 0;
        }

        public void push(int i) {
            if(full()) {
                System.out.println("Stack is full");
            }
            else {
                stack_array[top] = i;
                top++;
            }
        }
        public int pop() {
            int i = -1;
            if(empty()) {
                System.out.println("Stack is empty");
            }
            else {
                top--;
                i =  stack_array[top];
            }
            return i;
        }
    }

}
