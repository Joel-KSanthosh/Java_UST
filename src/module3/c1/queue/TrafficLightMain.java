package module3.c1.queue;
import java.util.LinkedList;
import java.util.Queue;
// Vehicle class to represent a vehicle
class Vehicle {
    private String licensePlate;
    public Vehicle(String licensePlate) {
        this.licensePlate = licensePlate;
    }
    public String getLicensePlate() {
        return licensePlate;
    }
}
// TrafficLight class to manage vehicle queue and control traffic flow
class TrafficLight {
    private Queue<Vehicle> vehicleQueue;
    private boolean greenLight;
    public TrafficLight() {
        vehicleQueue = new LinkedList<>();
        greenLight = false;
    }
    // Method to add a vehicle to the queue
    public void enqueueVehicle(Vehicle vehicle) {
        vehicleQueue.add(vehicle);
        System.out.println("Vehicle with license plate '" + vehicle.getLicensePlate() + "' has arrived at the traffic light.");
    }
    // Method to control the traffic light and allow vehicles to proceed
    public void controlTraffic() {
        if (!greenLight && !vehicleQueue.isEmpty()) {
            System.out.println("Green light! Vehicles can proceed.");
            greenLight = true;
            while (!vehicleQueue.isEmpty()) {
                Vehicle nextVehicle = vehicleQueue.poll();
                System.out.println("Vehicle with license plate '" + nextVehicle.getLicensePlate() + "' is proceeding.");
            }
            greenLight = false;
        } else {
            System.out.println("No vehicles waiting or green light already active.");
        }
    }
}
public class TrafficLightMain {
    public static void main(String[] args) {
        TrafficLight trafficLight = new TrafficLight();
        // Simulate vehicles arriving at the traffic light
        trafficLight.enqueueVehicle(new Vehicle("ABC123"));
        trafficLight.enqueueVehicle(new Vehicle("XYZ789"));
        // Simulate traffic light control
        trafficLight.controlTraffic(); // Green light
        trafficLight.controlTraffic(); // No vehicles waiting or green light already active
    }
}
