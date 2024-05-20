package module3.c1.queue;
import java.util.LinkedList;
import java.util.Queue;
// Request class to represent a web server request
class Request {
    private String content;
    public Request(String content) {
        this.content = content;
    }
    public String getContent() {
        return content;
    }
}
// WebServer class to manage incoming requests
class WebServer {
    private Queue<Request> requestQueue;
    public WebServer() {
        requestQueue = new LinkedList<>();
    }
    // Method to enqueue incoming request
    public void enqueueRequest(Request request) {
        requestQueue.add(request);
        System.out.println("Request added to the queue: " + request.getContent());
    }
    // Method to process next request
    public void processNextRequest() {
        if (!requestQueue.isEmpty()) {
            Request nextRequest = requestQueue.poll();
            System.out.println("Processing request: " + nextRequest.getContent());
        } else {
            System.out.println("No requests to process.");
        }
    }
}
public class WebServerMain {
    public static void main(String[] args) {
        WebServer webServer = new WebServer();
        // Simulate incoming requests
        webServer.enqueueRequest(new Request("GET /page1"));
        webServer.enqueueRequest(new Request("POST /submit"));
        // Process requests
        webServer.processNextRequest();
        webServer.processNextRequest();
        webServer.processNextRequest(); // No requests to process
    }
}
