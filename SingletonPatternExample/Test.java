public class Test {
    public static void main(String[] args) {
        Logger l1 = Logger.getInstance();
        Logger l2 = Logger.getInstance();
        l1.log("First log");
        System.out.println("Both same instance? " + (l1 == l2)); // true aayega
    }
}