package Trees;

public class TreeNode <T>{
    public T data;
    public TreeNode<T> left;
    public TreeNode<T> right;

    public TreeNode() {
        this(null);
    }
    public TreeNode(T data) {
        this.data = data;
        left = null;
        right = null;
    }
}