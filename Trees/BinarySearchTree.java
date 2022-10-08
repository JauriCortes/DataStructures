package Trees;

import Trees.TreeNode;

public class BinarySearchTree {
    public TreeNode<Integer> root;

    //constructor
    public BinarySearchTree() {
        root = null;
    }

    //insert driver method
    public void insertBST(int num) {
        root = insert(num, root);
    }
    private TreeNode<Integer> insert(int num, TreeNode<Integer> p) {

        //if recusions finds a leaf child node, creates new node
        if (p == null) {
            p = new TreeNode<Integer>(num);
        }
        else {
            // if the number we want to insert is minor than the current node number, go left
            if(num < p.data) {
                p.left = insert(num, p.left);
            }
            // if the number we want to insert is major than the current node number, go right
            else if (num > p.data) {
                p.right = insert(num, p.right);
            }
            // if number is not, minor or major then is the same
            else {
                System.out.println("Item already in tree and not inserted");
            }
        }
        return p;
    }

    public void removeBST(int num) {
        root = remove(num, root);
    }
    private TreeNode<Integer> remove(int num, TreeNode<Integer> p) {
        if(p != null) {
            // si es mayor, va a buscar a la izquierda
            if (num < p.data) {
                p.left = remove(num, p.left);
            }
            // si es menor, va a buscar a la derecha
            else if (num > p.data) {
                p.right = remove(num, p.right);
            }
            // si no es ninguno, ya lo encontró
            else{
                // si no tiene hijos, se vuelve null y ya
                if (p.left == null && p.right == null) {
                    p = null;
                }
                // si el tiene un hijo null, el nodo a borrar toma el valor de su hijo no null
                else if (p.left == null) {
                    p = p.right;
                }
                else if (p.right == null) {
                    p = p.left;
                }
                //si los dos son null
                else {
                    TreeNode<Integer> t = findMin(p.right);
                    p.data = t.data;
                    p.right = remove(p.data, p.right);
                }
            } 
        }
        else {
            System.out.println("Item not in tree and not removed");
        }
        return p;
    }

    private TreeNode<Integer> findMin(TreeNode<Integer> p) {

        if (p.left != null) {
            p = findMin(p.left);
        }
        return p;
    }

    public void traverseBST() {
        System.out.print("The tree is: ");
        if (root != null) {
            traverse(root);
        }
        else {
            System.out.println(" empty");
        }
    }
    private void traverse(TreeNode<Integer> ptr) {
        if(ptr.left != null) {
            traverse(ptr.left);
        }
        System.out.print(""+ ptr.data);
        if(ptr.right != null) {
            traverse(ptr.right);
        }
    }
}
