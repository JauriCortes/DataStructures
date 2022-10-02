package UNcode;

import java.util.Scanner;

public class SecretCode {
    public static void main (String[] args){

        Scanner scan = new Scanner(System.in);

        int key = scan.nextInt();
        scan.nextLine();
        String message = scan.nextLine();

        
        //crear cola con el abecedario
        String abecedario = "abcdefghijklmnopqrstuvwxyz";
        QueuArrayGeneric<Character> cola = new QueuArrayGeneric<Character>(abecedario.length());

        for (int i = 0; i < abecedario.length(); i++) {
            int index = ((i + key)%abecedario.length());
            cola.enqueu(abecedario.charAt(index));
        }
        
        //crear linked list y subir contenido de la cola
        LinkedListGeneric<Character> lista = new LinkedListGeneric<Character>();
        while(!cola.empty()) {
            char abc = cola.dequeu();
            lista.addBack(abc);
        }

        //cargar mensaje cifrado en pila
        StackArrayGeneric<Character> pila = new StackArrayGeneric<Character>(message.length());
        for (int j = 0; j < message.length(); j++) {
            int Char = message.charAt(j);
            char encodedChar = lista.searchByIndex(Char-97);
            pila.push(encodedChar);
        }

        //print pila
        while(!pila.empty()){
            System.out.print(pila.pop());
        }
    }


    static class QueuArrayGeneric<T> {
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

    static class LinkedListGeneric<J> {

        private NodeGeneric<J> head;
        private NodeGeneric<J> newNode;
        private NodeGeneric<J> ref;
        //constructor
        public LinkedListGeneric() {
            head = null;
        }

        public boolean empty() {
            return (head == null);
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
        
        public J searchByIndex(int i){
            if (empty()) {
                throw new RuntimeException("Queu is full: "+"item not enqued");
            }
            
            ref = head;
            int count = 0;

            while (count < i) {
                ref = ref.next;
                count++;
            }
            return (ref.getData());            
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
            while(ref != null) {
                System.out.println(ref.getData());
                ref = ref.getNext();
            }
        }
    }
    static class NodeGeneric <T>{
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

    static class StackArrayGeneric<T>{

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