package UNcode;
import java.util.Scanner;


public class Distribucion {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        //carga una lista con el orden de Ingenieria, Humanas, Medicina, Artes
        scan.next();
        int EstI = scan.nextInt();
        scan.next();
        int EstH = scan.nextInt();
        scan.next();
        int EstA = scan.nextInt();
        scan.next();
        int EstM = scan.nextInt();
        LinkedListGeneric<facultad> lista_prioridad = HacerListaPrioridad(EstI, EstH, EstM, EstA);
        
        //carga una lista en el orden en que van a salir los lotes
        LinkedListGeneric<facultad> lista_distribucion = HacerListaDistribucion(lista_prioridad);

        LinkedListGeneric<equipo> lista_equipos = new LinkedListGeneric<equipo>();
        

        equipo comp = new equipo("computador", 0);
        equipo lapt = new equipo("laptop", 0);
        equipo tabl = new equipo("tablet", 0);

        lista_equipos.addBack(comp);
        lista_equipos.addBack(lapt);
        lista_equipos.addBack(tabl);
        

        //revisa la siguiente orden
        while(true) {
            String siguiente_orden = scan.next();        
            
            if (siguiente_orden.equals("Lote")) {

                scan.next();
                lista_equipos.search(0).getData().cantidad += scan.nextInt();
                scan.next();
                lista_equipos.search(1).getData().cantidad += scan.nextInt();
                scan.next();
                lista_equipos.search(2).getData().cantidad += scan.nextInt();

                for (int j = 0; j < lista_distribucion.count();  j++) {
                    while(lista_distribucion.search(j).getData().estudiantes > 0) {
                        if (lista_equipos.search((j%3)).getData().cantidad > 0) {
                            asignar(lista_distribucion.search(j).getData(), lista_equipos.search(j%3).getData());
                        }
                    }
                }
                
            }
        }
    }

    static LinkedListGeneric<facultad> HacerListaDistribucion(LinkedListGeneric<facultad> lista_prioridad) {

        LinkedListGeneric<facultad> lista_distribucion = new LinkedListGeneric<facultad>();
        
        while(!lista_prioridad.empty()) {
            facultad max_facultad = lista_prioridad.search(0).getData();
            int max_index = 0;
            
            for (int i = 1; i<lista_prioridad.count(); i++) {
                if(lista_prioridad.search(i).getData().estudiantes > max_facultad.estudiantes){
                    max_facultad = lista_prioridad.search(i).getData();
                    max_index = i;
                }
            }
            lista_distribucion.addBack(lista_prioridad.delete(max_index).getData());
        }
        return(lista_distribucion);
    }
    
    static LinkedListGeneric<facultad> HacerListaPrioridad(int EstI, int EstH, int EstM, int EstA) {

        facultad ingenieria = new facultad("ingenieria", EstI);
        facultad humanas = new facultad("humanas", EstH);
        facultad medicina = new facultad("medicina", EstM);
        facultad artes = new facultad("artes", EstA);

        LinkedListGeneric<facultad> lista_prioridad = new LinkedListGeneric<facultad>();

        lista_prioridad.addBack(ingenieria); 
        lista_prioridad.addBack(humanas); 
        lista_prioridad.addBack(medicina);
        lista_prioridad.addBack(artes);

        return (lista_prioridad);
    }

    static void asignar(facultad facultad, equipo equipo) {
        facultad.estudiantes -= 1;
        facultad.equipos_asignados(equipo.nombre);
        equipo.cantidad -= 1;
    }

    static class facultad {
        String nombre;
        int estudiantes;

        int Ncomp;
        int Nlapt;
        int Ntabl;

        facultad(String nombre, int estudiantes) {
            this.nombre = nombre;
            this.estudiantes = estudiantes;

            this.Ncomp = 0;
            this.Nlapt = 0;
            this.Ntabl = 0;
        }
    }

    static class equipo {
        String nombre;
        int cantidad;

        equipo(String nombre, int cantidad) {
            this.nombre = nombre;
            this.cantidad = cantidad;
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

        public NodeGeneric<J> search(int n) {
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
                NodeGeneric<J> prev = search(n-1);
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
