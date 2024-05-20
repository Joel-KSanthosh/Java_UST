package module3.c1;

class Course {
    int courseId;
    String courseName;

    public Course(int id, String name) {
        this.courseId = id;
        this.courseName = name;
    }
}

class Node {
    Course course;
    Node left, right;

    public Node(Course course) {
        this.course = course;
        left = right = null;
    }
}

public class BinarySearchTree {
    Node root;

    public BinarySearchTree() {
        root = null;
    }

    void insert(int courseId, String courseName) {
        Course course = new Course(courseId, courseName);
        root = insertRecursive(root, course);
    }

    Node insertRecursive(Node root, Course course) {
        if (root == null) {
            root = new Node(course);
            return root;
        }

        if (course.courseId < root.course.courseId)
            root.left = insertRecursive(root.left, course);
        else if (course.courseId > root.course.courseId)
            root.right = insertRecursive(root.right, course);

        return root;
    }

    void inorder() {
        inorderRecursive(root);
    }

    void inorderRecursive(Node root) {
        if (root != null) {
            inorderRecursive(root.left);
            System.out.println(root.course.courseId + ": " + root.course.courseName);
            inorderRecursive(root.right);
        }
    }

    Course search(String courseName) {
        return searchRecursive(root, courseName);
    }

    Course searchRecursive(Node root, String courseName) {
        if (root == null || root.course.courseName.equals(courseName))
            return (root != null) ? root.course : null;

        if (courseName.compareTo(root.course.courseName) < 0)
            return searchRecursive(root.left, courseName);

        return searchRecursive(root.right, courseName);
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();

        bst.insert(101, "Math");
        bst.insert(102, "Physics");
        bst.insert(103, "Biology");
        bst.insert(104, "Chemistry");
        bst.insert(105, "Computer Science");

        System.out.println("Courses in ascending order:");
        bst.inorder();

        String searchCourse = "Physics";
        Course foundCourse = bst.search(searchCourse);
        if (foundCourse != null)
            System.out.println("\nFound course '" + searchCourse + "' with ID: " + foundCourse.courseId);
        else
            System.out.println("\nCourse '" + searchCourse + "' not found.");
    }
}
