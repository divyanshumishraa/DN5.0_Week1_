// Order class
class Order {
    int orderId;
    String customerName;
    double totalPrice;

    public Order(int orderId, String customerName, double totalPrice) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "OrderID: " + orderId + ", Customer: " + customerName + ", Price: " + totalPrice;
    }
}

// Bubble Sort implementation
class BubbleSortOrders {
    public static void bubbleSort(Order[] orders) {
        int n = orders.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (orders[j].totalPrice > orders[j + 1].totalPrice) {
                    Order temp = orders[j];
                    orders[j] = orders[j + 1];
                    orders[j + 1] = temp;
                }
            }
        }
    }
}

// Quick Sort implementation
class QuickSortOrders {
    public static void quickSort(Order[] orders, int low, int high) {
        if (low < high) {
            int pi = partition(orders, low, high);
            quickSort(orders, low, pi - 1);
            quickSort(orders, pi + 1, high);
        }
    }

    private static int partition(Order[] orders, int low, int high) {
        double pivot = orders[high].totalPrice;
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (orders[j].totalPrice <= pivot) {
                i++;
                Order temp = orders[i];
                orders[i] = orders[j];
                orders[j] = temp;
            }
        }
        Order temp = orders[i + 1];
        orders[i + 1] = orders[high];
        orders[high] = temp;
        return i + 1;
    }
}

// Main driver class
public class CustomerOrderSorting {
    public static void main(String[] args) {
        Order[] orders = {
            new Order(101, "Alice", 250.75),
            new Order(102, "Bob", 120.50),
            new Order(103, "Charlie", 560.00),
            new Order(104, "David", 300.25)
        };

        System.out.println("Original Orders:");
        for (Order o : orders) System.out.println(o);

        // Bubble Sort
        BubbleSortOrders.bubbleSort(orders);
        System.out.println("\nOrders Sorted by Bubble Sort:");
        for (Order o : orders) System.out.println(o);

        // Reset array for Quick Sort
        orders = new Order[]{
            new Order(101, "Alice", 250.75),
            new Order(102, "Bob", 120.50),
            new Order(103, "Charlie", 560.00),
            new Order(104, "David", 300.25)
        };

        QuickSortOrders.quickSort(orders, 0, orders.length - 1);
        System.out.println("\nOrders Sorted by Quick Sort:");
        for (Order o : orders) System.out.println(o);
    }
}
