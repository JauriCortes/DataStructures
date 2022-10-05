package UNcode;

import java.util.Scanner;

public class tiendas {
    public static void main(String[] args) {
        
        
        Scanner scan = new Scanner(System.in);
        
        int operaciones = scan.nextInt();
        
        for (int i = 0; i < operaciones; i++){
            
            int N_ELDMS = scan.nextInt();
            QueuArrayGeneric<String> electrodomesticos = new QueuArrayGeneric<String>(N_ELDMS);

            for (int j = 0; j < N_ELDMS; j++) {
                String electro = scan.next();
                electrodomesticos.enqueu(electro);
            }

            int N_tiendas = scan.nextInt();

            for (int t = 0; t < N_tiendas; t++) {
                int ELDMS_por_tienda = scan.nextInt();

                System.out.print("[");
                for (int u = 0; u < ELDMS_por_tienda; u++){
                    if (!electrodomesticos.empty()) {

                        String electro_saliente = electrodomesticos.dequeu();
                        System.out.print(electro_saliente);
                        
                        if(!(u == ELDMS_por_tienda-1)) {
                            System.out.print(" ");
                        }
                    }
                }
                System.out.println("]");
            }
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
    
}
