import java.util.*;

class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }
}

public class ProductSalesAnalyzer {
    public static void main(String[] args) {
        List<Product> sales = new ArrayList<>();
        sales.add(new Product("Product1", 30));
        sales.add(new Product("Product2", 80));
        sales.add(new Product("Product3", 120));
        sales.add(new Product("Product4", 40));
        sales.add(new Product("Product5", 150));
        sales.add(new Product("Product6", 90));

        double[] priceRanges = {0, 50, 100, 200, 500, 1000};
        int numRanges = priceRanges.length - 1;
        int[] productCount = new int[numRanges];
        double[] revenue = new double[numRanges];
        for (Product product : sales) {
            double price = product.getPrice();
            for (int i = 0; i < numRanges; i++) {
                if (price >= priceRanges[i] && price < priceRanges[i + 1]) {
                    productCount[i]++;
                    revenue[i] += price;
                    break;
                }
            }
        }
        System.out.println("Price Range\t\tNumber of Products\tTotal Revenue");
        for (int i = 0; i < numRanges; i++) {
            System.out.printf("$%.2f - $%.2f\t\t%d\t\t\t$%.2f\n",
                    priceRanges[i], priceRanges[i + 1], productCount[i], revenue[i]);
        }
    }
}