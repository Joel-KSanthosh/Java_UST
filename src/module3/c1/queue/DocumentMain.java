package module3.c1.queue;
import java.util.LinkedList;
import java.util.Queue;
// Document class to represent a document
class Document {
    private String name;
    private boolean isPriority;
    public Document(String name, boolean isPriority) {
        this.name = name;
        this.isPriority = isPriority;
    }
    public String getName() {
        return name;
    }
    public boolean isPriority() {
        return isPriority;
    }
}
// PrintQueue class to manage printing tasks
class PrintQueue {
    private Queue<Document> regularQueue;
    private Queue<Document> priorityQueue;
    public PrintQueue() {
        regularQueue = new LinkedList<>();
        priorityQueue = new LinkedList<>();
    }
    // Method to add a document to the appropriate queue
    public void addDocument(Document doc) {
        if (doc.isPriority()) {
            priorityQueue.add(doc);
            System.out.println("Priority document '" + doc.getName() + "' added to the queue.");
        } else {
            regularQueue.add(doc);
            System.out.println("Document '" + doc.getName() + "' added to the queue.");
        }
    }
    // Method to print the next document in the queue
    public void printNextDocument() {
        if (!priorityQueue.isEmpty()) {
            Document nextPriorityDoc = priorityQueue.poll();
            System.out.println("Printing priority document: " + nextPriorityDoc.getName());
        } else if (!regularQueue.isEmpty()) {
            Document nextDoc = regularQueue.poll();
            System.out.println("Printing document: " + nextDoc.getName());
        } else {
            System.out.println("No documents to print.");
        }
    }
}
public class DocumentMain {
    public static void main(String[] args) {
        PrintQueue printQueue = new PrintQueue();
        // Simulate printing tasks
        printQueue.addDocument(new Document("Resume", false));
        printQueue.addDocument(new Document("Presentation", true));
        printQueue.addDocument(new Document("Report", false));
        // Print the documents
        printQueue.printNextDocument();
        printQueue.printNextDocument();
        printQueue.printNextDocument();
        printQueue.printNextDocument(); // No documents to print
    }
}
