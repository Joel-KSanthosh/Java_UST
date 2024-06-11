package module4.c1;

public class BinaryTree {

    private static class BinaryTreeNode {
        int data;
        BinaryTreeNode leftChild;
        BinaryTreeNode rightChild;

        public BinaryTreeNode(int data) {
            this.data = data;
        }
    }

    private BinaryTreeNode root;

    // Method to insert a new node with given data in the binary tree
    public void insert(int data) {
        if (root == null) {
            root = new BinaryTreeNode(data);
        } else {
            insert(root, data);
        }
    }

    private void insert(BinaryTreeNode current, int data) {
        if (data < current.data) {
            if (current.leftChild == null) {
                current.leftChild = new BinaryTreeNode(data);
            } else {
                insert(current.leftChild, data);
            }
        } else if (data > current.data) {
            if (current.rightChild == null) {
                current.rightChild = new BinaryTreeNode(data);
            } else {
                insert(current.rightChild, data);
            }
        }
    }

    // Pre-order traversal method
    public void preOrderTraversal() {
        preOrderTraversal(root);
    }

    private void preOrderTraversal(BinaryTreeNode node) {
        if (node!= null) {
            System.out.print(node.data + " ");
            preOrderTraversal(node.leftChild);
            preOrderTraversal(node.rightChild);
        }
    }

    // In-order traversal method
    public void inOrderTraversal() {
        inOrderTraversal(root);
    }

    private void inOrderTraversal(BinaryTreeNode node) {
        if (node!= null) {
            inOrderTraversal(node.leftChild);
            System.out.print(node.data + " ");
            inOrderTraversal(node.rightChild);
        }
    }

    // Post-order traversal method
    public void postOrderTraversal() {
        postOrderTraversal(root);
    }

    private void postOrderTraversal(BinaryTreeNode node) {
        if (node!= null) {
            postOrderTraversal(node.leftChild);
            postOrderTraversal(node.rightChild);
            System.out.print(node.data + " ");
        }
    }

    // Search for a node by its value
    public boolean search(int value) {
        return search(root, value);
    }

    private boolean search(BinaryTreeNode node, int value) {
        if (node == null) {
            return false;
        }
        if (value == node.data) {
            return true;
        }
        return value < node.data? search(node.leftChild, value) : search(node.rightChild, value);
    }

    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        bt.insert(50);
        bt.insert(30);
        bt.insert(20);
        bt.insert(40);
        bt.insert(70);
        bt.insert(60);
        bt.insert(80);

        System.out.println("Pre-order Traversal:");
        bt.preOrderTraversal();
        System.out.println();

        System.out.println("In-order Traversal:");
        bt.inOrderTraversal();
        System.out.println();

        System.out.println("Post-order Traversal:");
        bt.postOrderTraversal();
        System.out.println();

        System.out.println("Searching for 60: " + (bt.search(60)? "Found" : "Not Found"));
        System.out.println("Searching for 100: " + (bt.search(100)? "Found" : "Not Found"));
    }
}
