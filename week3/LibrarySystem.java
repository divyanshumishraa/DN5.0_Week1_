package week3;

public class LibrarySystem {
    public static void main(String[] args) {
        // Sample books
        Book[] books = {
            new Book(1, "Java Basics", "Alice"),
            new Book(2, "Data Structures", "Bob"),
            new Book(3, "Algorithms", "Charlie"),
            new Book(4, "Design Patterns", "David")
        };

        // Linear Search
        System.out.println("Linear Search Result: " +
            SearchAlgorithms.linearSearch(books, "Algorithms"));

        // Binary Search (requires sorted titles)
        System.out.println("Binary Search Result: " +
            SearchAlgorithms.binarySearch(books, "Design Patterns"));
    }
}
