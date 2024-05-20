package module3.c1;
class MyCourse {
    int courseId;
    String courseName;
    public MyCourse(int id, String name) {
        this.courseId = id;
        this.courseName = name;
    }
}
public class BubbleSort {
    static void bubbleSort(MyCourse[] courses) {
        int n = courses.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (courses[j].courseId > courses[j + 1].courseId) {
                    // swap courses[j+1] and courses[j]
                    MyCourse temp = courses[j];
                    courses[j] = courses[j + 1];
                    courses[j + 1] = temp;
                }
            }
        }
    }
    public static void main(String[] args) {
        // Creating an array of MyCourse objects
        MyCourse[] courses = {
                new MyCourse(103, "Biology"),
                new MyCourse(101, "Math"),
                new MyCourse(105, "Computer Science"),
                new MyCourse(102, "Physics"),
                new MyCourse(104, "Chemistry")
        };

        System.out.println("Courses before sorting:");
        for (MyCourse course : courses) {
            System.out.println(course.courseId + ": " + course.courseName);
        }
        // Sorting the array using bubble sort
        bubbleSort(courses);
        System.out.println("\nCourses after sorting by courseId in ascending order:");
        for (MyCourse course : courses) {
            System.out.println(course.courseId + ": " + course.courseName);
        }
    }
}

