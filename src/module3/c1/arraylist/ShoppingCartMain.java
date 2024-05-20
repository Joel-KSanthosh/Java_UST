package module3.c1.arraylist;
import java.util.ArrayList;
import java.util.List;
class ShoppingCartItem {
    private String productName;
    private double price;
    private int quantity;
    public ShoppingCartItem(String productName, double price, int quantity) {
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }
    public String getProductName() {
        return productName;
    }
    public double getPrice() {
        return price;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
class ShoppingCart {
    private List<ShoppingCartItem> items;
    public ShoppingCart() {
        items = new ArrayList<>();
    }
    // Method to add an item to the shopping cart
    public void addItem(String productName, double price, int quantity) {
        // Check if the item is already in the cart
        for (ShoppingCartItem item : items) {
            if (item.getProductName().equals(productName)) {
                item.setQuantity(item.getQuantity() + quantity); // Update quantity
                return;
            }
        }
        // If the item is not in the cart, add a new item
        items.add(new ShoppingCartItem(productName, price, quantity));
    }
    // Method to remove an item from the shopping cart
    public void removeItem(String productName) {
        items.removeIf(item -> item.getProductName().equals(productName));
    }
    // Method to adjust the quantity of an item in the shopping cart
    public void adjustItemQuantity(String productName, int newQuantity) {
        for (ShoppingCartItem item : items) {
            if (item.getProductName().equals(productName)) {
                item.setQuantity(newQuantity);
                return;
            }
        }
    }
    // Method to get the total cost of items in the shopping cart
    public double getTotalCost() {
        double totalCost = 0.0;
        for (ShoppingCartItem item : items) {
            totalCost += item.getPrice() * item.getQuantity();
        }
        return totalCost;
    }
    // Method to display the items in the shopping cart
    public void displayCart() {
        System.out.println("Shopping Cart:");
        for (ShoppingCartItem item : items) {
            System.out.println(item.getProductName() + " - $" + item.getPrice() + " x " + item.getQuantity());
        }
        System.out.println("Total Cost: $" + getTotalCost());
    }
}
public class ShoppingCartMain {
    public static void main(String[] args) {
        // Create a shopping cart
        ShoppingCart cart = new ShoppingCart();
        // Add items to the cart
        cart.addItem("Product A", 10.0, 2);
        cart.addItem("Product B", 20.0, 1);
        cart.addItem("Product A", 10.0, 3); // Add more of Product A
        // Display the cart
        cart.displayCart();
        // Adjust the quantity of an item
        cart.adjustItemQuantity("Product B", 2);
        // Display the updated cart
        cart.displayCart();
        // Remove an item from the cart
        cart.removeItem("Product A");
        // Display the updated cart
        cart.displayCart();
    }
}
