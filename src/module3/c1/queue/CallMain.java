package module3.c1.queue;
import java.util.LinkedList;
import java.util.Queue;
// Call class to represent a call
class Call {
    private String callerName;
    public Call(String callerName) {
        this.callerName = callerName;
    }
    public String getCallerName() {
        return callerName;
    }
}
// CallCenter class to manage incoming calls
class CallCenter {
    private Queue<Call> callQueue;
    public CallCenter() {
        callQueue = new LinkedList<>();
    }
    // Method to add a call to the queue
    public void receiveCall(Call call) {
        callQueue.add(call);
        System.out.println("Call from " + call.getCallerName() + " is added to the queue.");
    }
    // Method to answer the next call in the queue
    public void answerCall() {
        if (!callQueue.isEmpty()) {
            Call nextCall = callQueue.poll();
            System.out.println("Answering call from " + nextCall.getCallerName());
        } else {
            System.out.println("No calls to answer.");
        }
    }
}
public class CallMain {
    public static void main(String[] args) {
        CallCenter callCenter = new CallCenter();
        // Simulate incoming calls
        callCenter.receiveCall(new Call("Alice"));
        callCenter.receiveCall(new Call("Bob"));
        callCenter.receiveCall(new Call("Charlie"));
        // Answer the calls
        callCenter.answerCall();
        callCenter.answerCall();
        callCenter.answerCall();
        callCenter.answerCall(); // No calls to answer
    }
}

