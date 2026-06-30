package week3;

// File: Forecast.java
public class Forecast {

    // Recursive method to predict future value
    public static double predictFutureValue(double currentValue, double growthRate, int years) {
        // Base case: no more years left
        if (years == 0) return currentValue;

        // Recursive step: apply growth and reduce years
        return predictFutureValue(currentValue * (1 + growthRate), growthRate, years - 1);
    }
}
