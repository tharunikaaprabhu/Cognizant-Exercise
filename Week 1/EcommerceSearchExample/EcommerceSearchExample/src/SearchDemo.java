// SearchDemo.java
import java.util.Arrays;
import java.util.Comparator;

public class SearchDemo {

    // Linear Search
    public static Product linearSearch(Product[] products, String name) {
        for (Product p : products) {
            if (p.productName.equalsIgnoreCase(name)) {
                return p;
            }
        }
        return null;
    }

    // Binary Search
    public static Product binarySearch(Product[] products, String name) {
        Arrays.sort(products, Comparator.comparing(p -> p.productName.toLowerCase()));
        int low = 0, high = products.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int compare = products[mid].productName.compareToIgnoreCase(name);
            if (compare == 0) return products[mid];
            else if (compare < 0) low = mid + 1;
            else high = mid - 1;
        }
        return null;
    }

    public static void main(String[] args) {
        Product[] products = {
            new Product(101, "Laptop", "Electronics"),
            new Product(102, "Shirt", "Clothing"),
            new Product(103, "Phone", "Electronics"),
            new Product(104, "Table", "Furniture"),
            new Product(105, "Shoes", "Footwear")
        };

        System.out.println("🔎 Linear Search for 'Phone':");
        Product result1 = linearSearch(products, "Phone");
        System.out.println(result1 != null ? "Found: " + result1 : "Not Found");

        System.out.println("\n🔎 Binary Search for 'Table':");
        Product result2 = binarySearch(products, "Table");
        System.out.println(result2 != null ? "Found: " + result2 : "Not Found");
    }
}
