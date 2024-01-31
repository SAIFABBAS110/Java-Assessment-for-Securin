import java.util.Arrays;

public class Securin_Assessment_PartA {

        public static void main(String[] args) {
            // Die A and Die B representation
            int[] dieA = {1, 2, 3, 4, 5, 6};
            int[] dieB = {1, 2, 3, 4, 5, 6};

            // Part 1: Total Combinations
            int totalCombinations = calculateTotalCombinations(dieA, dieB);
            System.out.println("1. Total Combinations: " + totalCombinations);

            // Part 2: Combinations Distribution
            int[][] combinationsDistribution = calculateCombinationsDistribution(dieA, dieB);
            System.out.println("\n2. Combinations Distribution:");
            printMatrix(combinationsDistribution);

            // Part 3: Probability of Possible Sums
            System.out.println("\n3. Probability of Possible Sums:");
            calculateAndDisplayProbabilities(combinationsDistribution);
        }

        // Part 1: Calculate Total Combinations
        public static int calculateTotalCombinations(int[] dieA, int[] dieB) {
            return dieA.length * dieB.length;
        }

        // Part 2: Calculate Combinations Distribution
        public static int[][] calculateCombinationsDistribution(int[] dieA, int[] dieB) {
            int[][] distribution = new int[dieA.length][dieB.length];

            for (int i = 0; i < dieA.length; i++) {
                for (int j = 0; j < dieB.length; j++) {
                    distribution[i][j] = dieA[i] + dieB[j];
                }
            }

            return distribution;
        }

        // Helper method to print a matrix
        public static void printMatrix(int[][] matrix) {
            for (int[] row : matrix) {
                System.out.println(Arrays.toString(row));
            }
        }

        // Part 3: Calculate and Display Probabilities
        public static void calculateAndDisplayProbabilities(int[][] combinationsDistribution) {
            for (int i = 2; i <= 12; i++) {
                int count = countOccurrences(combinationsDistribution, i);
                double probability = 1.0 / count; // P(Sum = i) = 1/X
                System.out.println("P(Sum = " + i + ") = 1/" + count + " as there is only one combination possible.");
            }
        }

        // Helper method to count occurrences of a target value in a matrix
        public static int countOccurrences(int[][] matrix, int target) {
            int count = 0;
            for (int[] row : matrix) {
                for (int value : row) {
                    if (value == target) {
                        count++;
                    }
                }
            }
            return count;
        }
    }
