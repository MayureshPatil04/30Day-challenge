
public class Challenge13 {

    public static int countAtMostKDistinct(String s, int k) {
        if (k == 0) return 0;
        int left = 0, count = 0, distinctCount = 0;
        int[] freq = new int[26];

        for (int right = 0; right < s.length(); right++) {
            int index = s.charAt(right) - 'a';
            freq[index]++;
            if (freq[index] == 1) distinctCount++;

            while (distinctCount > k) {
                int leftIndex = s.charAt(left) - 'a';
                freq[leftIndex]--;
                if (freq[leftIndex] == 0) distinctCount--;
                left++;
            }

            count += right - left + 1;
        }

        return count;
    }

    public static int countExactlyKDistinct(String s, int k) {
        if (k > s.length()) return 0;
        return countAtMostKDistinct(s, k) - countAtMostKDistinct(s, k - 1);
    }

    public static void main(String[] args) {
        String[] tests = {"pqpqs", "aabacbebebe", "a", "abc", "abc"};
        int[] ks = {2, 3, 1, 3, 2};
        int[] expected = {7, 10, 1, 1, 2};

        for (int i = 0; i < tests.length; i++) {
            int result = countExactlyKDistinct(tests[i], ks[i]);
            System.out.println("Input: s = \"" + tests[i] + "\", k = " + ks[i]);
            System.out.println("Output: " + result);
            System.out.println("Expected: " + expected[i]);
            System.out.println(result == expected[i] ? "Test Passed\n" : "Test Failed\n");
        }
    }
}