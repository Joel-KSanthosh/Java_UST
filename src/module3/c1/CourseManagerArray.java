package module3.c1;
import java.util.Scanner;
public class CourseManagerArray {
    private static final int MAX_COURSES = 100;
    private static String[] courses = new String[MAX_COURSES];
    private static int courseCount = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("1. Add a new course");
            System.out.println("2. Display all courses");
            System.out.println("3. Exit");
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
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice! Please enter again.");
                    break;
            }
        } while (choice != 3);
        scanner.close();
    }
    private static void addCourse(Scanner scanner) {
        if (courseCount < MAX_COURSES) {
            System.out.print("Enter the name of the course: ");
            String courseName = scanner.next();
            courses[courseCount++] = courseName;
            System.out.println("Course added successfully!");
        } else {
            System.out.println("Cannot add more courses. Course limit reached.");
        }
    }
    private static void displayCourses() {
        if (courseCount == 0) {
            System.out.println("No courses added yet.");
        } else {
            System.out.println("List of courses:");
            for (int i = 0; i < courseCount; i++) {
                System.out.println((i + 1) + ". " + courses[i]);
            }
        }
    }
}
