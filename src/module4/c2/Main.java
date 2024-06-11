package module4.c2;
import java.util.*;

// Define a class for representing a graph
class Graph {
    private int V;
    private LinkedList<Integer> adj[];

    Graph(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i=0; i<v; ++i)
            adj[i] = new LinkedList();
    }

    void addEdge(int v, int w) {
        adj[v].add(w);
    }

    void BFS(int s) {
        boolean visited[] = new boolean[V];
        LinkedList<Integer> queue = new LinkedList<Integer>();
        visited[s] = true;
        queue.add(s);
        while (queue.size() != 0) {
            s = queue.poll();
            System.out.print(s+" ");
            Iterator<Integer> i = adj[s].listIterator();
            while (i.hasNext()) {
                int n = i.next();
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }

    void DFSUtil(int v, boolean visited[]) {
        visited[v] = true;
        System.out.print(v+" ");
        Iterator<Integer> i = adj[v].listIterator();
        while (i.hasNext()) {
            int n = i.next();
            if (!visited[n])
                DFSUtil(n, visited);
        }
    }

    void DFS(int v) {
        boolean visited[] = new boolean[V];
        DFSUtil(v, visited);
    }
}

// Define a class for representing a hash table
class HashTable<K, V> {
    private ArrayList<LinkedList<Entry<K, V>>> buckets;
    private int capacity;

    HashTable(int capacity) {
        this.capacity = capacity;
        buckets = new ArrayList<>(capacity);
        for (int i = 0; i < capacity; i++) {
            buckets.add(new LinkedList<Entry<K, V>>());
        }
    }

    void put(K key, V value) {
        int index = Math.abs(key.hashCode() % capacity);
        LinkedList<Entry<K, V>> bucket = buckets.get(index);
        for (Entry<K, V> entry : bucket) {
            if (entry.getKey().equals(key)) {
                entry.setValue(value);
                return;
            }
        }
        bucket.add(new Entry<>(key, value));
    }

    V get(K key) {
        int index = Math.abs(key.hashCode() % capacity);
        LinkedList<Entry<K, V>> bucket = buckets.get(index);
        for (Entry<K, V> entry : bucket) {
            if (entry.getKey().equals(key)) {
                return entry.getValue();
            }
        }
        return null;
    }

    boolean containsKey(K key) {
        int index = Math.abs(key.hashCode() % capacity);
        LinkedList<Entry<K, V>> bucket = buckets.get(index);
        for (Entry<K, V> entry : bucket) {
            if (entry.getKey().equals(key)) {
                return true;
            }
        }
        return false;
    }

    private static class Entry<K, V> {
        private K key;
        private V value;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        K getKey() {
            return key;
        }

        V getValue() {
            return value;
        }

        void setValue(V value) {
            this.value = value;
        }
    }
}

// Example usage of the graph and hash table classes
public class Main {
    public static void main(String[] args) {
        // Creating a graph with 5 vertices
        Graph graph = new Graph(5);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        System.out.println("BFS traversal:");
        graph.BFS(0);
        System.out.println("\nDFS traversal:");
        graph.DFS(0);

        // Creating a hash table to store student information
        HashTable<String, Integer> studentGrades = new HashTable<>(10);
        studentGrades.put("Alice", 90);
        studentGrades.put("Bob", 85);
        studentGrades.put("Charlie", 95);
        System.out.println("\nGrade of Bob: " + studentGrades.get("Bob"));
    }
}
