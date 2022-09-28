package UNcode;

import java.util.Scanner;

import javax.swing.plaf.synth.SynthStyle;

public class borde {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String string = scan.nextLine();

        final QueuArrayGeneric<Character> cola = new QueuArrayGeneric<Character>(string.length());
        final StackArrayGeneric<Character> pila = new StackArrayGeneric<Character>(string.length());

        for(int i = 0; i < string.length(); i++) {
            cola.enqueu(string.charAt(i));
            pila.push(string.charAt(i));
        }
        for(int i = 0; i < string.length(); i++) {
            System.out.println(cola.dequeu());
            System.out.println(pila.pop());   
        }
    }

    static class QueuArrayGeneric<T> {
        private static int N = 4;
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

    static class StackArrayGeneric<T>{

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
    
}
