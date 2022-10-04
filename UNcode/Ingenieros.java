package UNcode;

import java.util.Scanner;

public class Ingenieros {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        LinkedListGeneric<ingeniero> ingenieros_disponibles = new LinkedListGeneric<ingeniero>();
        String disponible = "NO";

        int EH = scan.nextInt();
        int EI = scan.nextInt();
        int EC = scan.nextInt();

        for (int i = 0; i < EI; i++){
            int IE = scan.nextInt();
            int IHE = scan.nextInt();
            int IHS = scan.nextInt();

            ingeniero ingeniero = new ingeniero();

            ingeniero.experiencia = IE;
            ingeniero.hora_entrada = IHE;
            ingeniero.hora_salida = IHS;

            ingenieros_disponibles.addBack(ingeniero);
        }

        for (int i = 0; i < EC; i++) {
            disponible = "NO";

            int CE = scan.nextInt();
            int CH = scan.nextInt();

            for(int j = 0; j < ingenieros_disponibles.count; j++) {

                ingeniero ingeniero = ingenieros_disponibles.search(j).getData();

                if(ingeniero.hora_entrada <= CH && ingeniero.hora_salida >= CH && ingeniero.experiencia >= CE) { 

                    disponible = "YES";
                }
            }
            System.out.println(disponible);
        }
    }

    static class ingeniero{
        int experiencia;
        int hora_entrada;
        int hora_salida;
    }

    static class LinkedListGeneric<J> {

        private NodeGeneric<J> head;
        private NodeGeneric<J> newNode;
        private NodeGeneric<J> ref;

        int count = 0;
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
            count++;
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
            count++;
        }
    
        //print method
        public void printList() {
            ref = head;
            while(ref != null) {
                System.out.println(ref.getData());
                ref = ref.getNext();
            }
        }

        public int count() {
            return count;
        }

        public boolean empty() {
            return (head == null);
        }

        public NodeGeneric<J> search(int n) {

            int item = 0;
            if (!empty()) {
                ref = head;
                while( item < n) {
                    ref = ref.next;
                }
            }
            else {
                throw new RuntimeException("List is empty: ");
            }

            return ref;
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
    
}
