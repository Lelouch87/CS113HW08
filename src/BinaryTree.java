import java.util.Scanner;

public class BinaryTree<E>{

    protected Node<E> root;

    public BinaryTree() {
        root = null;
    }

    protected BinaryTree(Node<E> root) {
        this.root = root;
    }

    public BinaryTree(E data, BinaryTree<E> leftTree, BinaryTree<E> rightTree) {
        root = new Node<>(data);
        if (leftTree != null) {
            root.left = leftTree.root;
        } else {
            root.left = null;
        }
        if (rightTree != null) {
            root.right = rightTree.root;
        } else {
            root.right = null;
        }
    }

    public BinaryTree<E> getLeftSubtree() {
        if (root != null && root.left != null) {
            return new BinaryTree<>(root.left);
        } else {
            return null;
        }
    }

    public BinaryTree<E> getRightSubtree() {
        if (root != null && root.right != null) {
            return new BinaryTree<>(root.right);
        } else {
            return null;
        }
    }

    public E getData() {
        return root.data;
    }

    public boolean isLeaf() {
        return (root.left == null && root.right == null);
    }

    private void preOrderTraversal(Node<E> node, int depth, StringBuilder sb) {
        for (int i = 1; i < depth; i++) {
            sb.append("   ");
        }
        if (node == null) {
            sb.append("null\n");
        } else {
            sb.append(node.toString()).append("\n");
            preOrderTraversal(node.left, depth+1, sb);
            preOrderTraversal(node.right, depth+1, sb);
        }
    }

    public static BinaryTree<String> readBinaryTree(Scanner scan) {
        String data = scan.next();
        if (data.equals("null")) {
            return null;
        } else {
            BinaryTree<String> leftTree = readBinaryTree(scan);
            BinaryTree<String> rightTree = readBinaryTree(scan);
            return new BinaryTree<>(data, leftTree, rightTree);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        preOrderTraversal(root, 1, sb);
        return sb.toString();
    }

    protected static class Node<E>{

        protected E data;
        protected Node<E> left;
        protected Node<E> right;

        public Node(E data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }

        public String toString() {
            return data.toString();
        }
    }
}