
public class Forecast {

   
    public static double futureValueRecursive(double presentValue, double growthRate, int years) {
        if (years == 0) {
            return presentValue; 
        }
        return futureValueRecursive(presentValue, growthRate, years - 1) * (1 + growthRate);
    }

    public static double futureValueMemo(double presentValue, double growthRate, int years, double[] memo) {
        if (years == 0) {
            return presentValue;
        }
        if (memo[years] != 0) {
            return memo[years];
        }
        memo[years] = futureValueMemo(presentValue, growthRate, years - 1, memo) * (1 + growthRate);
        return memo[years];
    }

    public static void main(String[] args) {
        double presentValue = 10000;   
        double growthRate = 0.10;      
        int years = 5;

        System.out.println("🔁 Recursive Forecast (No Memoization):");
        double result1 = futureValueRecursive(presentValue, growthRate, years);
        System.out.printf("Future Value after %d years = %.2f\n", years, result1);

        System.out.println("\n⚡ Optimized Forecast (With Memoization):");
        double[] memo = new double[years + 1];
        double result2 = futureValueMemo(presentValue, growthRate, years, memo);
        System.out.printf("Future Value after %d years = %.2f\n", years, result2);
    }
}
