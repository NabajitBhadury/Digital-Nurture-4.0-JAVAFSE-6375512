public class FinancialForecast {

    /**
     * Recursive method to compute future value
     *
     * @param currentValue starting amount
     * @param growthRate growth per period (e.g., 0.05 for 5%)
     * @param periodsLeft number of periods to grow
     * @return predicted future value
     */
    public static double forecastFutureValue(double currentValue, double growthRate, int periodsLeft) {
        // Base case: no periods left, return current value
        if (periodsLeft == 0) {
            return currentValue;
        }

        // Recursive case: apply growth for one period, decrease periods
        return forecastFutureValue(currentValue * (1 + growthRate), growthRate, periodsLeft - 1);
    }

    public static void main(String[] args) {
        double currentValue = 1000.0;  // Starting value
        double growthRate = 0.05;      // 5% growth per period
        int periods = 10;              // Forecast 10 periods

        double futureValue = forecastFutureValue(currentValue, growthRate, periods);
        System.out.printf("Predicted future value after %d periods: %.2f%n", periods, futureValue);
    }
}
