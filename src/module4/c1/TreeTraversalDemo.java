package module4.c1;
import java.util.Scanner;

public class TreeTraversalDemo {

    private static class BinaryTreeNode {
        int data;
        BinaryTreeNode leftChild;
        BinaryTreeNode rightChild;

        public BinaryTreeNode(int data) {
            this.data = data;
        }
    }

    private static class BinaryTree {
        private BinaryTreeNode root;

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

        public void preOrderTraversal(BinaryTreeNode node, String prefix) {
            if (node!= null) {
                System.out.println(prefix + "Visit " + node.data);
                preOrderTraversal(node.leftChild, prefix + "L");
                preOrderTraversal(node.rightChild, prefix + "R");
            }
        }

        public void inOrderTraversal(BinaryTreeNode node, String prefix) {
            if (node!= null) {
                inOrderTraversal(node.leftChild, prefix + "L");
                System.out.println(prefix + "Visit " + node.data);
                inOrderTraversal(node.rightChild, prefix + "R");
            }
        }

        public void postOrderTraversal(BinaryTreeNode node, String prefix) {
            if (node!= null) {
                postOrderTraversal(node.leftChild, prefix + "L");
                postOrderTraversal(node.rightChild, prefix + "R");
                System.out.println(prefix + "Visit " + node.data);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BinaryTree tree = new BinaryTree();
        int choice, data;

        System.out.println("Enter the number of elements to insert:");
        int numElements = scanner.nextInt();
        for (int i = 0; i < numElements; i++) {
            System.out.println("Enter element " + (i+1) + ":");
            data = scanner.nextInt();
            tree.insert(data);
        }

        System.out.println("\nChoose a traversal method:\n1. Pre-order\n2. In-order\n3. Post-order\nEnter your choice:");
        choice = scanner.nextInt();

        switch (choice) {
            case 1:
                System.out.println("Pre-order Traversal:");
                tree.preOrderTraversal(tree.root, "");
                break;
            case 2:
                System.out.println("In-order Traversal:");
                tree.inOrderTraversal(tree.root, "");
                break;
            case 3:
                System.out.println("Post-order Traversal:");
                tree.postOrderTraversal(tree.root, "");
                break;
            default:
                System.out.println("Invalid choice.");
                break;
        }

        scanner.close();
    }
}

