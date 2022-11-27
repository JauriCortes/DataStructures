import java.util.*;

public class ColaPrioridad {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int casos = scan.nextInt();

        for (int i = 0; i <casos ; i++){

            OrderedLinkedList colaDePrioridad = new OrderedLinkedList();
            int acciones = scan.nextInt();
            scan.nextLine();

            for (int j=0;j<acciones;j++){

                String cadena = scan.nextLine();
                String[] accion = cadena.split(" ");

                if (accion[0].equals("entra")){
                    
                    switch(accion[1]) {
                        case "discapacitado":
                            colaDePrioridad.insert(0, "discapacitado");
                            break;
                        case "conBebe":
                            colaDePrioridad.insert(1, "conBebe");
                            break;
                        case "embarazada":
                            colaDePrioridad.insert(2, "embarazada");
                            break;
                        case "mayor":
                            colaDePrioridad.insert(3, "mayor");
                            break;
                        default:
                        colaDePrioridad.insert(4, accion[1]);
                    }
                }
                else{
                    while (!colaDePrioridad.empty()){

                        NodeGeneric<Integer> curr = colaDePrioridad.dequeue();
                        System.out.println(curr.name);

                    }
                }
            }
        }
    }
    
    static class OrderedLinkedList {

        NodeGeneric<Integer> head;

        OrderedLinkedList() {
            this.head = null;
        }
    
        public boolean insert(int item, String name) {
            boolean inserted;
            NodeGeneric<Integer> ptr, prev;
    
            inserted = false;
            ptr = head;
            prev = null;
            
            while(ptr != null && ptr.getData() <= item) {
                prev = ptr;
                ptr = ptr.getNext();
            }   
            
            inserted = true;
            NodeGeneric<Integer> newp = new NodeGeneric<Integer>();

            newp.setData(item, name);
            newp.setNext(ptr);

            if (prev == null) {
                head = newp;
            }
            else {
                prev.setNext(newp);
            }
            return inserted;
        }

        public boolean empty() {
            return (head == null);
        }

        public NodeGeneric<Integer> dequeue() {

            NodeGeneric<Integer> ptr;

            if(empty()) {
                throw new RuntimeException("List is empty: " + "item not dequed");
            }

            ptr = head;
            head = head.getNext();
            
            return (ptr);
        }
    }

    static class NodeGeneric <T>{
        private T data;
        private String name;
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

        public String getName() {
            return name;
        }

        public void setData(T data, String name) {
            this.data = data;
            this.name = name;
        }

        public NodeGeneric<T> getNext() {
            return next;
        }

        public void setNext(NodeGeneric<T> next) {
            this.next = next;
        }
    }
    
}

