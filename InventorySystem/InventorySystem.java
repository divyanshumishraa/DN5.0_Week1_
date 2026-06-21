import java.util.ArrayList;

public class InventorySystem {
    private ArrayList<Product> inventory = new ArrayList<>();

    public void addProduct(Product product) {
        inventory.add(product);
        System.out.println("Product added: " + product.getProductName());
    }

    public void updateProduct(int productId, int newQuantity) {
        for (Product p : inventory) {
            if (p.getProductId() == productId) {
                p.setQuantity(newQuantity);
                System.out.println("Quantity updated for " + p.getProductName());
                return;
            }
        }
        System.out.println("Product not found with ID: " + productId);
    }

    public void deleteProduct(int productId) {
        boolean removed = inventory.removeIf(p -> p.getProductId() == productId);
        if (removed) {
            System.out.println("Product deleted with ID: " + productId);
        } else {
            System.out.println("Product not found with ID: " + productId);
        }
    }

    public void displayInventory() {
        System.out.println("\n--- Inventory ---");
        if (inventory.isEmpty()) {
            System.out.println("Inventory is empty");
        }
        for (Product p : inventory) {
            System.out.println(p);
        }
    }

    public static void main(String[] args) {
        InventorySystem system = new InventorySystem();

        Product p1 = new Product(1, "Laptop", 10, 55000.0);
        Product p2 = new Product(2, "Mouse", 50, 500.0);
        Product p3 = new Product(3, "Keyboard", 30, 1500.0);

        system.addProduct(p1);
        system.addProduct(p2);
        system.addProduct(p3);

        system.displayInventory();

        system.updateProduct(2, 45);
        system.deleteProduct(3);

        system.displayInventory();
    }
}