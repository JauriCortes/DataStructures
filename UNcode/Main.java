package UNcode;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String old_string = scan.nextLine();
        String string = "";
        
        for(int i = 0; i<old_string.length(); i++) {
            char letter = old_string.charAt(i);
            if(letter != '[' && letter != ']' && letter != ',') {
                string = string + letter;
            }
        }

        final QueuArrayGeneric<Character> cola = new QueuArrayGeneric<Character>(string.length());
        final StackArrayGeneric<Character> pila = new StackArrayGeneric<Character>(string.length());
        final LinkedListGeneric<Character> MiLista = new LinkedListGeneric<Character>();
        
        for(int i = 0; i < string.length(); i++) {
            cola.enqueu(string.charAt(i));
            pila.push(string.charAt(i));
        }
        
        String pre = "";
        String post = "";
        while(!cola.empty()) {
            pre = pre + cola.dequeu();
            post = pila.pop() + post;
            
            if(pre.equals(post)) {
                
                System.out.print('[');
                System.out.print(post.charAt(0));
                for (int j = 1; j< post.length(); j++) {
                    System.out.print(',');
                    System.out.print(post.charAt(j));
                }
                System.out.print(']');
                System.out.println();

            }
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

    private static class NodeGeneric <T>{
        private T data;
        private NodeGeneric<T> next;
    
        public NodeGeneric() {
            this(null);
        }
        public NodeGeneric(T data) {
            this.data = data;
            next = null;
        }
    
        public T getData() {
            return data;
        }
    
        public void setData(T data) {
            this.data = data;
        }
    
        public NodeGeneric<T> getNext() {
            return next;
        }
    
        public void setNext(NodeGeneric<T> next) {
            this.next = next;
        }
    }

    private static class LinkedListGeneric<J> {

        private NodeGeneric<J> head;
        private NodeGeneric<J> newNode;
        private NodeGeneric<J> ref;
        //constructor
        public LinkedListGeneric() {
            head = null;
        }
        //add method
        public void addFront(J data) {
            if (head != null) {
                newNode = new NodeGeneric<J>(data);
                newNode.setNext(head);
                
                head = newNode;
            }
            else {
                head = new NodeGeneric<J>(data);
            }
        }
        
        public void addBack(J data) {
            
            newNode = new NodeGeneric<J>(data);
    
            if (head != null) {
                ref = head;
                while(ref.getNext() != null) {
                    ref = ref.getNext();
                }
                ref.setNext(newNode);
            }
            else {
                head = newNode;    
            }
    
        }
    
        //print method
        public void printList() {
            ref = head;
            System.out.print('[');
            while(ref != null) {
                System.out.print(ref.getData());
                if (ref.getNext() != null) {
                    System.out.print(',');
                }
                ref = ref.getNext();
            }
            System.out.print(']');
            System.out.println();
        }
    }
    
}
