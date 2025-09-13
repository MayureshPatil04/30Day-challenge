import java.util.Arrays;
public class Challenge30 {
    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];

        Arrays.fill(dp, amount + 1);

        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i - coin >= 0) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        if (dp[amount] > amount) {
            return -1;
        }

        return dp[amount];
    }

    public static void main(String[] args) {
        // Test Case 1
        int[] coins1 = {1, 2, 5};
        int amount1 = 11;
        System.out.println("Output: " + coinChange(coins1, amount1)); 

        // Test Case 2
        int[] coins2 = {2};
        int amount2 = 3;
        System.out.println("Output: " + coinChange(coins2, amount2)); 
        // Test Case 3
        int[] coins3 = {1};
        int amount3 = 0;
        System.out.println("Output: " + coinChange(coins3, amount3));

        // Extra Edge Case
        int[] coins4 = {5, 10};
        int amount4 = 3;
        System.out.println("Output: " + coinChange(coins4, amount4)); 

        // Another Case
        int[] coins5 = {2, 5, 10, 1};
        int amount5 = 27;
        System.out.println("Output: " + coinChange(coins5, amount5)); 

        // Large Amount Case
        int[] coins6 = {1, 2, 5};
        int amount6 = 10000;
        System.out.println("Output: " + coinChange(coins6, amount6)); 
    }
}


