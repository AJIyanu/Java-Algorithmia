import java.util.ArrayList;

public class DataAnalysis {
    public static float calculateAveragePrice(float[] stockPrices) {
        float sums = 0;
        for (float price : stockPrices) {
            sums += price;
        }
        return sums / stockPrices.length;
    }
    
    public static float calculateAveragePrice(ArrayList<Float> stockPrices) {
        float sums = 0;
        for (float price : stockPrices) {
            sums += price;
        }
        return sums / stockPrices.size();
    }

    public static float findMaximumPrice(float[] stockPrices) {
        float max = stockPrices[0];
        for (float price : stockPrices) {
            if (price > max) {
                max = price;
            }
        }
        return max;
    }
    
    public static float findMaximumPrice(ArrayList<Float> stockPrices) {
        float max = stockPrices.get(0);
        for (float price : stockPrices) {
            if (price > max) {
                max = price;
            }
        }
        return max;
    }

    public static float countOccurrences(float[] stockPrices, float targetPrice) {
        int count = 0;
        for (float price : stockPrices) {
            if (price == targetPrice) {
                count++;
            }
        }
        return count;
    }
    
    public static float countOccurrences(ArrayList<Float> stockPrices, float targetPrice) {
        int count = 0;
        for (float price : stockPrices) {
            if (price == targetPrice) {
                count++;
            }
        }
        return count;
    }

    public static ArrayList<Float> computeCumulativeSum(float[] stockPrices) {
        ArrayList<Float> cumulativeSum = new ArrayList<>();
        float sum = 0;
        for (float price : stockPrices) {
            sum += price;
            cumulativeSum.add(sum);
        }
        return cumulativeSum;
    }
    
    public static ArrayList<Float> computeCumulativeSum(ArrayList<Float> stockPrices) {
        ArrayList<Float> cumulativeSum = new ArrayList<>();
        float sum = 0;
        for (float price : stockPrices) {
            sum += price;
            cumulativeSum.add(sum);
        }
        return cumulativeSum;
    }

}
