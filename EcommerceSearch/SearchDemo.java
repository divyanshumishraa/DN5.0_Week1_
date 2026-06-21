import java.util.Arrays;
import java.util.Comparator;

public class SearchDemo {
    public static int linearSearch(Product1[] products, String name) {
        for (int i = 0; i < products.length; i++) {
            if (products[i].getProductName().equalsIgnoreCase(name)) {
                return i;
            }
        }
        return -1;
    }

    public static int binarySearch(Product1[] products, String name) {
        Arrays.sort(products, Comparator.comparing(Product1::getProductName, String.CASE_INSENSITIVE_ORDER));
        int left = 0, right = products.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int cmp = products[mid].getProductName().compareToIgnoreCase(name);
            if (cmp == 0) return mid;
            if (cmp < 0) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        Product1[] products = {
            new Product1(101, "Laptop", "Electronics"),
            new Product1(102, "Shoes", "Fashion"),
            new Product1(103, "Mobile", "Electronics"),
            new Product1(104, "Watch", "Accessories"),
            new Product1(105, "Bag", "Fashion")
        };

        System.out.println("Linear Search: Product 'Shoes' found at index " + linearSearch(products, "Shoes"));
        System.out.println("Binary Search: Product 'Shoes' found at index " + binarySearch(products, "Shoes"));
    }
}