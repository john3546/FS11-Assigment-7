import java.util.*;

class Housing {
    private double price;
    private double squareFootage;

    public Housing(double price, double squareFootage) {
        this.price = price;
        this.squareFootage = squareFootage;
    }

    public double getPrice() {
        return price;
    }

    public double getSquareFootage() {
        return squareFootage;
    }
}

public class HousingAnalyzer {
    public static void main(String[] args) {
        // Sample housing prices list
        List<Housing> housingList = new ArrayList<>();
        housingList.add(new Housing(150000, 1200));
        housingList.add(new Housing(220000, 1400));
        housingList.add(new Housing(180000, 1100));
        housingList.add(new Housing(250000, 1600));
        housingList.add(new Housing(190000, 1300));
        housingList.add(new Housing(280000, 1800));
        housingList.add(new Housing(200000, 1500));

        // Define price ranges
        double[] priceRanges = {100000, 200000, 300000, 400000, 500000, Double.MAX_VALUE};
        int numRanges = priceRanges.length - 1;

        // Initialize arrays to store counts and total square footage for each range
        int[] houseCount = new int[numRanges];
        double[] squareFootageTotal = new double[numRanges];

        // Iterate over each housing data
        for (Housing housing : housingList) {
            double price = housing.getPrice();
            double squareFootage = housing.getSquareFootage();
            // Iterate over each price range
            for (int i = 0; i < numRanges; i++) {
                if (price >= priceRanges[i] && price < priceRanges[i + 1]) {
                    // Increment count and add square footage to the corresponding range
                    houseCount[i]++;
                    squareFootageTotal[i] += squareFootage;
                    break;
                }
            }
        }

        // Print results
        System.out.println("Price Range\t\tNumber of Houses\t\tAverage Square Footage");
        for (int i = 0; i < numRanges; i++) {
            double averageSquareFootage = houseCount[i] > 0 ? squareFootageTotal[i] / houseCount[i] : 0;
            System.out.printf("$%.0f - $%.0f\t\t\t\t%d\t\t\t\t%.2f\n",
                    priceRanges[i], priceRanges[i + 1], houseCount[i], averageSquareFootage);
        }
    }
}