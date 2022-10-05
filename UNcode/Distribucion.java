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
        
        LinkedListGeneric<LinkedListGeneric<equipo>> lista_lotes = new LinkedListGeneric<LinkedListGeneric<equipo>>();
    
        
        //revisa la siguiente orden
        while(scan.hasNext()) {
            String siguiente_orden = scan.next();        
            
            if (siguiente_orden.equals("Lote")) {

                LinkedListGeneric<equipo> lista_equipos = new LinkedListGeneric<equipo>();
                
                scan.next();
                equipo comp = new equipo("computador", scan.nextInt());
                scan.next();
                equipo lapt = new equipo("laptop", scan.nextInt());
                scan.next();
                equipo tabl = new equipo("tablet", scan.nextInt());

                lista_equipos.addBack(comp);
                lista_equipos.addBack(lapt);
                lista_equipos.addBack(tabl);

                lista_lotes.addBack(lista_equipos);
                
            }
            else if(siguiente_orden.equals("Distribuir")) {
                distribucion(lista_distribucion, lista_lotes.delete(0).getData());
                lista_distribucion = HacerListaDistribucion(lista_prioridad);
            }
            else if (siguiente_orden.equals("Imprimir")) {

                LinkedListGeneric<facultad> lista_buffer = new LinkedListGeneric<facultad>();

                for (int i = 0; i < lista_prioridad.count(); i++) {
                    lista_buffer.addBack(lista_prioridad.search(i).getData());
                }

                while(!lista_buffer.empty()) {
                    facultad min_facultad = lista_buffer.search(0).getData();
                    int min_index = 0;
                    
                    for (int i = 1; i<lista_buffer.count(); i++) {
                        facultad facultad = lista_buffer.search(i).getData();
                        if(facultad.estudiantes < min_facultad.estudiantes){
                            min_facultad = facultad;
                            min_index = i;
                        }
                    }
                    System.out.println(min_facultad.nombre+" "+min_facultad.estudiantes+" - Computers "+min_facultad.Ncomp+" Laptops "+min_facultad.Nlapt+" Tablets "+min_facultad.Ntabl);
                    lista_buffer.delete(min_index);
                }

            }
        }
    }

    static LinkedListGeneric<facultad> HacerListaDistribucion(LinkedListGeneric<facultad> lista_prioridad) {

        LinkedListGeneric<facultad> lista_distribucion = new LinkedListGeneric<facultad>();
        LinkedListGeneric<facultad> lista_buffer = new LinkedListGeneric<facultad>();

        for (int i = 0; i < lista_prioridad.count(); i++) {
            lista_buffer.addBack(lista_prioridad.search(i).getData());
        }

        while(!lista_buffer.empty()) {
            facultad max_facultad = lista_buffer.search(0).getData();
            int max_index = 0;
            
            for (int i = 1; i<lista_buffer.count(); i++) {
                if(lista_buffer.search(i).getData().estudiantes > max_facultad.estudiantes){
                    max_facultad = lista_buffer.search(i).getData();
                    max_index = i;
                }
            }
            lista_distribucion.addBack(lista_buffer.delete(max_index).getData());
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
        equipo.cantidad -= 1;

        if(equipo.nombre == "computador") {
            facultad.Ncomp += 1;
        } else if (equipo.nombre == "laptop") {
            facultad.Nlapt += 1;
        } else if (equipo.nombre == "tablet") {
            facultad.Ntabl += 1;
        }
    }

    static void distribucion(LinkedListGeneric<facultad> lista_distribucion, LinkedListGeneric<equipo> lista_equipos ) {
        int count = 0;
            for (int j = 0; j < lista_distribucion.count();  j++) {

                facultad facultad = lista_distribucion.search(j).getData();
                facultad.Ncomp = 0;
                facultad.Nlapt = 0;
                facultad.Ntabl = 0;
                
                while(facultad.estudiantes > 0 && HayaEquipos(lista_equipos)) {
                    equipo equipo = lista_equipos.search(count%3).getData();

                    if (equipo.cantidad > 0) {
                        asignar(facultad, equipo);
                    }
                    count++;
                }
            }
    }

    static boolean HayaEquipos(LinkedListGeneric<equipo> lista_equipos) {

        if (!lista_equipos.empty()) {
            int n = lista_equipos.count();
            for (int y = 0; y < n; y++) {
                if (lista_equipos.search(y).getData().cantidad > 0) {
                    return (true);
                }
            }
        }
        return (false);
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
