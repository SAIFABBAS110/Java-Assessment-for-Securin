import java.util.Arrays;


public class Securin_Assessment_PartB {

        public static void main(String[] args) {
            // Input Dice
            int[] dieA = {1, 2, 3, 4, 5, 6};
            int[] dieB = Arrays.copyOf(dieA, dieA.length);

            // Transform Dice
            int[] newDieA = undoom_dice(dieA, dieB);
            int[] newDieB = Arrays.copyOf(dieB, dieB.length);

            // Print the results
            System.out.println("Original Die A: " + Arrays.toString(dieA));
            System.out.println("Original Die B: " + Arrays.toString(dieB));
            System.out.println("New Die A: " + Arrays.toString(newDieA));
            System.out.println("New Die B: " + Arrays.toString(newDieB));
        }

        // Transform Function
        public static int[] undoom_dice(int[] dieA, int[] dieB) {
            int[] newDieA = Arrays.copyOf(dieA, dieA.length);

            // Calculate the probabilities of obtaining each sum with the original dice
            double[] originalProbabilities = calculateProbabilities(dieA, dieB);

            // Transform Die A to maintain the same probabilities
            for (int i = 0; i < newDieA.length; i++) {
                if (newDieA[i] > 4) {
                    // Adjust the value to maintain the original probability
                    newDieA[i] = findValueToMaintainProbability(originalProbabilities, i + 1);
                }
            }

            return newDieA;
        }

        // Helper method to calculate probabilities
        private static double[] calculateProbabilities(int[] dieA, int[] dieB) {
            double[] probabilities = new double[11]; // Probabilities for sums 2 to 12
            Arrays.fill(probabilities, 0.0);

            for (int faceA : dieA) {
                for (int faceB : dieB) {
                    int sum = faceA + faceB;
                    probabilities[sum - 2] += 1.0;
                }
            }

            // Normalize probabilities
            double totalCombinations = dieA.length * dieB.length;
            for (int i = 0; i < probabilities.length; i++) {
                probabilities[i] /= totalCombinations;
            }

            return probabilities;
        }

        // Helper method to find a value for Die A to maintain the same probability
        private static int findValueToMaintainProbability(double[] originalProbabilities, int sum) {
            // Find a value for Die A to maintain the same probability for the given sum
            for (int value = 1; value <= 4; value++) {
                double newProbability = calculateNewProbability(originalProbabilities, sum, value);
                if (newProbability > 0) {
                    return value;
                }
            }

            // This should not happen for valid input
            return -1;
        }

        // Helper method to calculate the new probability for the given sum and value on Die A
        private static double calculateNewProbability(double[] originalProbabilities, int sum, int value) {
            double newProbability = 0.0;
            for (int i = 1; i <= 6; i++) {
                int newSum = sum - value + i;
                if (newSum >= 2 && newSum <= 12) {
                    newProbability += originalProbabilities[newSum - 2];
                }
            }
            return newProbability;
        }
    }



