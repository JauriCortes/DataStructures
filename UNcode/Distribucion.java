package UNcode;
import java.util.Scanner;


public class Distribucion {
    public static void main(String[] args) {
        //hay que cargar una lista con el orden de distribucion
        Scanner scan = new Scanner(System.in);

        scan.next();
        int estudiantes_ingenieria = scan.nextInt();
        scan.next();
        int estudiantes_humanas = scan.nextInt();
        scan.next();
        int estudiantes_artes = scan.nextInt();
        scan.next();
        int estudiantes_medicina = scan.nextInt();

        facultad ingenieria = new facultad("ingenieria", estudiantes_ingenieria);
        facultad humanas = new facultad("humanas", estudiantes_humanas);
        facultad artes = new facultad("artes", estudiantes_artes);
        facultad medicina = new facultad("medicina", estudiantes_medicina);

        LinkedListGeneric<facultad> lista_prioridad = new LinkedListGeneric<facultad>();
        LinkedListGeneric<facultad> lista_distribucion = new LinkedListGeneric<facultad>();
        lista_prioridad.addBack(ingenieria); 
        lista_prioridad.addBack(humanas); 
        lista_prioridad.addBack(medicina);
        lista_prioridad.addBack(artes); 
        
        
        
        while(!lista_prioridad.empty()) {
            facultad max_facultad = lista_prioridad.spy(0).getData();
            int max_index = 0;

            for (int i = 1; i<lista_prioridad.count(); i++) {
                if(lista_prioridad.spy(i).getData().estudiantes > max_facultad.estudiantes){
                    max_facultad = lista_prioridad.spy(i).getData();
                    max_index = i;
                }
            }
            lista_distribucion.addBack(lista_prioridad.delete(max_index).getData());
        }

        
        while(!lista_distribucion.empty()) {
            System.out.println(lista_distribucion.delete(0).getData().nombre);
        }
    }

    static class facultad {
        String nombre;
        int estudiantes;

        facultad(String nombre, int estudiantes) {
            this.nombre = nombre;
            this.estudiantes = estudiantes;
        }

        public int getEstudiantes() {
            return estudiantes;
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
            while(ref != null) {
                System.out.println(ref.getData());
                ref = ref.getNext();
            }
        }

        public boolean empty() {
            return (head == null);
        }

        public int count() {
            int count = 0;
            ref = head;
            while (ref != null) {
                count++;
                ref = ref.getNext();
            }
            return(count);
        }

        public NodeGeneric<J> spy(int n) {
            int count = 0;
            ref = head;
            while(count < n) {
                ref = ref.getNext();
                count++;
            }
            return ref;
        }

        public NodeGeneric<J> delete(int n){
            ref = head;
            if (n>0) {
                NodeGeneric<J> prev = spy(n-1);
                ref = prev.getNext();
    
                prev.setNext(ref.getNext());
                ref.setNext(null);
    
            }
            else {
                head = head.getNext();
                ref.setNext(null);
            }
            return(ref);
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
        public T spy(int n){
            return(qarray[front+n]);
        }
    }
    
}
