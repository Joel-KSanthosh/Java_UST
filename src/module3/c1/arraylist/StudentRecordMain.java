package module3.c1.arraylist;
import java.util.ArrayList;
import java.util.List;
class StudentRecordManager {
    private List<StudentRecord> studentRecords;
    public StudentRecordManager() {
        studentRecords = new ArrayList<>();
    }
    // Method to add a student record
    public void addStudentRecord(StudentRecord record) {
        studentRecords.add(record);
    }
    // Method to remove a student record by ID
    public void removeStudentRecordByID(int studentID) {
        for (int i = 0; i < studentRecords.size(); i++) {
            if (studentRecords.get(i).getStudentID() == studentID) {
                studentRecords.remove(i);
                return; // Exit loop after removing the record
            }
        }
    }
    // Method to search for a student record by ID
    public StudentRecord searchStudentRecordByID(int studentID) {
        for (StudentRecord record : studentRecords) {
            if (record.getStudentID() == studentID) {
                return record; // Return the record if found
            }
        }
        return null; // Return null if record not found
    }
    // Method to search for student records by name
    public List<StudentRecord> searchStudentRecordsByName(String name) {
        List<StudentRecord> matchingRecords = new ArrayList<>();
        for (StudentRecord record : studentRecords) {
            if (record.getName().equalsIgnoreCase(name)) {
                matchingRecords.add(record);
            }
        }
        return matchingRecords;
    }
}
class StudentRecord {
    private int studentID;
    private String name;
    // Other student attributes
    public StudentRecord(int studentID, String name) {
        this.studentID = studentID;
        this.name = name;
        // Initialize other attributes as needed
    }
    public int getStudentID() {
        return studentID;
    }
    public String getName() {
        return name;
    }
    // Other getter and setter methods for additional attributes
}
public class StudentRecordMain {
    public static void main(String[] args) {
        // Create a student record manager
        StudentRecordManager recordManager = new StudentRecordManager();
        // Add student records
        recordManager.addStudentRecord(new StudentRecord(1001, "Alice"));
        recordManager.addStudentRecord(new StudentRecord(1002, "Bob"));
        recordManager.addStudentRecord(new StudentRecord(1003, "Alice"));
        // Search for a student record by ID
        StudentRecord foundRecord = recordManager.searchStudentRecordByID(1002);
        if (foundRecord != null) {
            System.out.println("Found record: " + foundRecord.getName());
        } else {
            System.out.println("Record not found.");
        }
        // Search for student records by name
        List<StudentRecord> matchingRecords = recordManager.searchStudentRecordsByName("Alice");
        System.out.println("Matching records for name 'Alice':");
        for (StudentRecord record : matchingRecords) {
            System.out.println(record.getName() + " (ID: " + record.getStudentID() + ")");
        }
        // Remove a student record by ID
        recordManager.removeStudentRecordByID(1003);
    }
}

