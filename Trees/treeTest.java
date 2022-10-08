package Trees;

public class treeTest {

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();

        tree.insertBST(5);
        tree.insertBST(3);
        tree.insertBST(8);
        tree.insertBST(2);
        tree.insertBST(6);
        tree.insertBST(8);
        tree.insertBST(4);
        tree.insertBST(7);
        tree.insertBST(1);

        tree.traverseBST();
        
    }
}
