import java.util.Scanner;

public class TeamBmiCalculator {
    public static String getBmiStatus(double bmi) {
        if (bmi < 18.5) return "Underweight";
        if (bmi < 25.0) return "Normal";
        if (bmi < 30.0) return "Overweight";
        return "Obese";
    }

    public static void printWellnessReport(double[] heights, double[] weights) {
        if (heights.length != weights.length) {
            throw new IllegalArgumentException("Heights and weights must have the same number of entries.");
        }
        System.out.println("\nTEAM WELLNESS REPORT");
        System.out.printf("%-8s | %-12s | %-12s | %-8s | %-12s%n", "Person", "Height (m)", "Weight (kg)", "BMI", "Status");
        System.out.println("---------+--------------+--------------+----------+--------------");
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] <= 0 || weights[i] <= 0) {
                System.out.printf("Person %-2d | Invalid height/weight values%n", i + 1);
                continue;
            }
            double bmi = weights[i] / (heights[i] * heights[i]);
            System.out.printf("%-8d | %-12.2f | %-12.2f | %-8.2f | %-12s%n",
                    i + 1, heights[i], weights[i], bmi, getBmiStatus(bmi));
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int teamSize = 10;
        double[] heights = new double[teamSize];
        double[] weights = new double[teamSize];
        System.out.println("Enter height in metres and weight in kilograms for " + teamSize + " people.");
        for (int i = 0; i < teamSize; i++) {
            System.out.print("Person " + (i + 1) + " height (m): ");
            heights[i] = readPositiveDouble(scanner);
            System.out.print("Person " + (i + 1) + " weight (kg): ");
            weights[i] = readPositiveDouble(scanner);
        }
        printWellnessReport(heights, weights);
        scanner.close();
    }

    private static double readPositiveDouble(Scanner scanner) {
        while (true) {
            try {
                double value = Double.parseDouble(scanner.nextLine().trim());
                if (Double.isFinite(value) && value > 0) return value;
            } catch (NumberFormatException ignored) {
                // Ask again if the input is not a valid number.
            }
            System.out.print("Enter a valid positive number: ");
        }
    }
}
