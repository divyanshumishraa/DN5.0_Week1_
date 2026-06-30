package week3;


public class FinancialForecasting {
    public static void main(String[] args) {
        double currentValue = 1000;   // Initial investment
        double growthRate = 0.10;     // 10% growth per year
        int years = 5;                // Forecast for 5 years

        // Call recursive method
        double futureValue = Forecast.predictFutureValue(currentValue, growthRate, years);

        // Print result
        System.out.println("Future Value after " + years + " years: " + futureValue);
    }
}
