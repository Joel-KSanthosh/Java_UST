package module4.c1;
public class BinaryTreeBalanceCheck {

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

    // Method to check if the binary tree is balanced
    public boolean isBalanced() {
        return isBalanced(root)!= -1;
    }

    private int isBalanced(BinaryTreeNode node) {
        if (node == null) {
            return 0; // An empty tree is considered balanced
        }
        int leftHeight = isBalanced(node.leftChild);
        if (leftHeight == -1) {
            return -1; // Left subtree is not balanced
        }
        int rightHeight = isBalanced(node.rightChild);
        if (rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1) {
            return -1; // Right subtree is not balanced or the balance factor is not -1, 0, or 1
        }
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static void main(String[] args) {
        BinaryTreeBalanceCheck tree = new BinaryTreeBalanceCheck();

        // Inserting elements to test the balance check
        tree.insert(10);
        tree.insert(5);
        tree.insert(15);
        tree.insert(3);
        tree.insert(7);
        tree.insert(12);
        tree.insert(17);

        System.out.println("Is the binary tree balanced? " + (tree.isBalanced()? "Yes" : "No"));

        // Example of an unbalanced tree
        tree.insert(25);
        System.out.println("Is the binary tree balanced after adding another element? " + (tree.isBalanced()? "Yes" : "No"));
    }
}
