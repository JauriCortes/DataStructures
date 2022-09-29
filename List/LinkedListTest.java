package List;

public class LinkedListTest {
    
    public static void main(String[] args) {
        
        final LinkedListGeneric<Character> MiLista = new LinkedListGeneric<Character>();

        MiLista.addBack('c');
        MiLista.addBack('h');
        MiLista.addBack('a');
        MiLista.addBack('r');

        MiLista.printList();
    }

}
