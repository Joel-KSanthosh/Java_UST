package module3.c1.arraylist;
import java.util.Arrays;
class InventoryArrayList {
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] elements;
    private int size;
    public InventoryArrayList() {
        this.elements = new Object[DEFAULT_CAPACITY];
        this.size = 0;
    }
    // Method to add an item to the inventory
    public void addItem(Object item) {
        ensureCapacity(size + 1);
        elements[size++] = item;
    }
    // Method to remove an item from the inventory
    public void removeItem(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }
        System.arraycopy(elements, index + 1, elements, index, size - index - 1);
        elements[--size] = null; // Clear the reference to the removed item
    }
    // Method to get an item from the inventory
    public Object getItem(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }
        return elements[index];
    }
    // Method to ensure capacity for adding new elements
    private void ensureCapacity(int minCapacity) {
        if (minCapacity > elements.length) {
            int newCapacity = elements.length * 2;
            if (newCapacity < minCapacity) {
                newCapacity = minCapacity;
            }
            elements = Arrays.copyOf(elements, newCapacity);
        }
    }
    // Method to get the current size of the inventory
    public int size() {
        return size;
    }
}
public class InventoryArrayMain {
    public static void main(String[] args) {
        InventoryArrayList inventory = new InventoryArrayList();
        // Adding items to the inventory
        inventory.addItem("Item 1");
        inventory.addItem("Item 2");
        inventory.addItem("Item 3");
        // Removing an item from the inventory
        inventory.removeItem(1);
        // Getting an item from the inventory
        System.out.println("Item at index 1: " + inventory.getItem(1));
    }
}
