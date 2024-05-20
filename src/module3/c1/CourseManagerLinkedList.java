package module3.c1;
import java.util.Scanner;

class CourseAll {
    int courseId;
    String courseName;
    CourseAll next;

    public CourseAll(int courseId, String courseName) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.next = null;
    }
}

public class CourseManagerLinkedList {
    private static CourseAll head;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("1. Add a new course");
            System.out.println("2. Display all courses");
            System.out.println("3. Search for a course by name");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addCourse(scanner);
                    break;
                case 2:
                    displayCourses();
                    break;
                case 3:
                    searchCourse(scanner);
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice! Please enter again.");
                    break;
            }
        } while (choice != 4);

        scanner.close();
    }

    private static <Courses> void addCourse(Scanner scanner) {
        System.out.print("Enter the course ID: ");
        int courseId = scanner.nextInt();
        System.out.print("Enter the course name: ");
        String courseName = scanner.next();

        CourseAll newCourse = new CourseAll(courseId, courseName);

        if (head == null || courseId < head.courseId) {
            newCourse.next = head;
            head = newCourse;
        } else {
            CourseAll current = head;
            while (current.next != null && current.next.courseId < courseId) {
                current = current.next;
            }
            newCourse.next = current.next;
            current.next = newCourse;
        }

        System.out.println("Course added successfully!");
    }

    private static void displayCourses() {
        if (head == null) {
            System.out.println("No courses added yet.");
        } else {
            System.out.println("List of courses:");
            CourseAll current = head;
            while (current != null) {
                System.out.println("Course ID: " + current.courseId + ", Name: " + current.courseName);
                current = current.next;
            }
        }
    }

    private static void searchCourse(Scanner scanner) {
        if (head == null) {
            System.out.println("No courses added yet.");
        } else {
            System.out.print("Enter the course name to search: ");
            String searchName = scanner.next();
            boolean found = false;
            CourseAll current = head;
            while (current != null) {
                if (current.courseName.equalsIgnoreCase(searchName)) {
                    System.out.println("Course found! Course ID: " + current.courseId);
                    found = true;
                    break;
                }
                current = current.next;
            }
            if (!found) {
                System.out.println("Course not found.");
            }
        }
    }
}
