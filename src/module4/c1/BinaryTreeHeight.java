package module4.c1;

public class BinaryTreeHeight {

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

    // Recursive method to calculate the height of the binary tree
    public int getHeight() {
        return getHeight(root);
    }

    private int getHeight(BinaryTreeNode node) {
        if (node == null) {
            return -1; // Height of an empty tree is -1
        }
        int leftHeight = getHeight(node.leftChild);
        int rightHeight = getHeight(node.rightChild);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static void main(String[] args) {
        BinaryTreeHeight tree = new BinaryTreeHeight();

        // Inserting elements to test the height calculation
        tree.insert(10);
        tree.insert(5);
        tree.insert(15);
        tree.insert(3);
        tree.insert(7);
        tree.insert(12);
        tree.insert(17);

        System.out.println("Height of the binary tree: " + tree.getHeight());
    }
}
