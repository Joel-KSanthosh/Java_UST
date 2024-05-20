package module3.c1.arraylist;
import java.util.ArrayList;
import java.util.List;
class ClassroomSeatingChart {
    private List<String> seatingChart;
    public ClassroomSeatingChart() {
        seatingChart = new ArrayList<>();
    }
    // Method to add a student to the seating chart
    public void addStudent(String student) {
        seatingChart.add(student);
    }
    // Method to remove a student from the seating chart
    public void removeStudent(String student) {
        seatingChart.remove(student);
    }
    // Method to update the seating chart with a new list of students
    public void updateSeatingChart(List<String> students) {
        seatingChart.clear();
        seatingChart.addAll(students);
    }
    // Method to get the current seating chart
    public List<String> getSeatingChart() {
        return seatingChart;
    }
}
public class ClassroomSeatingMain {
    public static void main(String[] args) {
        // Create a classroom seating chart
        ClassroomSeatingChart seatingChart = new ClassroomSeatingChart();
        // Add students to the seating chart
        seatingChart.addStudent("Alice");
        seatingChart.addStudent("Bob");
        seatingChart.addStudent("Charlie");
        // Display the current seating chart
        System.out.println("Current seating chart:");
        System.out.println(seatingChart.getSeatingChart());
        // Remove a student from the seating chart
        seatingChart.removeStudent("Bob");
        // Display the updated seating chart
        System.out.println("Updated seating chart:");
        System.out.println(seatingChart.getSeatingChart());
        // Update the seating chart with a new list of students
        List<String> newStudents = new ArrayList<>();
        newStudents.add("David");
        newStudents.add("Eve");
        newStudents.add("Frank");
        seatingChart.updateSeatingChart(newStudents);
        // Display the updated seating chart
        System.out.println("Updated seating chart after resizing:");
        System.out.println(seatingChart.getSeatingChart());
    }
}
