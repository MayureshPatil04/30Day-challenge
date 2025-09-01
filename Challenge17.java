
public class Challenge17 {
    // Method to count divisors of a given number N
    public static int countDivisors(int N) {
        int count = 0;

        for (int i = 1; i * i <= N; i++) {
            if (N % i == 0) {
                if (i * i == N) {
                    count++; // perfect square, count only once
                } else {
                    count += 2; // count both i and N/i
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        // Test cases
        int[] testCases = {18, 29, 100, 1, 997};

        // Loop through each test case and print the number of divisors
        for (int N : testCases) {
            int divisors = countDivisors(N);
            System.out.println("Input: N = " + N + " Output: " + divisors);
        }
    }
}
