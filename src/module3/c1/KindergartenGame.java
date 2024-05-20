package module3.c1;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
class Child {
    String name;
    List<Child> neighbors;

    public Child(String name) {
        this.name = name;
        this.neighbors = new ArrayList<>();
    }
    public void addNeighbor(Child neighbor) {
        neighbors.add(neighbor);
    }
    public List<Child> getNeighbors() {
        return neighbors;
    }
    public String getName() {
        return name;
    }
}
public class KindergartenGame {
    Map<String, Child> childrenMap;
    public KindergartenGame() {
        childrenMap = new HashMap<>();
    }
    public void addConnection(String child1Name, String child2Name) {
        Child child1 = getOrCreateChild(child1Name);
        Child child2 = getOrCreateChild(child2Name);
        child1.addNeighbor(child2);
        child2.addNeighbor(child1);
    }
    private Child getOrCreateChild(String name) {
        if (!childrenMap.containsKey(name)) {
            childrenMap.put(name, new Child(name));
        }
        return childrenMap.get(name);
    }
    public void displayConnections() {
        for (Child child : childrenMap.values()) {
            System.out.print(child.getName() + " can throw the ball to: ");
            for (Child neighbor : child.getNeighbors()) {
                System.out.print(neighbor.getName() + ", ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        KindergartenGame game = new KindergartenGame();
        // Define connections between children
        game.addConnection("Alice", "Bob");
        game.addConnection("Alice", "Charlie");
        game.addConnection("Bob", "Diana");
        game.addConnection("Charlie", "Eva");
        game.addConnection("Diana", "Frank");
        game.addConnection("Eva", "Gina");
        // Display connections
        System.out.println("Connections between children:");
        game.displayConnections();
    }
}
