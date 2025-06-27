
import java.util.Arrays;
import java.util.Comparator;

public class ECommerceSearchDemo {

    public static void main(String[] args) {
        Product[] products = {
            new Product(105, "Phone", "Electronics"),
            new Product(101, "Laptop", "Electronics"),
            new Product(203, "Shoes", "Fashion"),
            new Product(150, "Watch", "Accessories"),
            new Product(120, "Bag", "Fashion")
        };

        int targetId = 150;

        // Linear Search
        Product resultLinear = SearchUtils.linearSearch(products, targetId);
        System.out.println("Linear Search Result: " + (resultLinear != null ? resultLinear : "Product Not Found"));

        // Sort products for binary search
        Arrays.sort(products, Comparator.comparingInt(Product::getProductId));

        // Binary Search
        Product resultBinary = SearchUtils.binarySearch(products, targetId);
        System.out.println("Binary Search Result: " + (resultBinary != null ? resultBinary : "Product Not Found"));
    }
}
