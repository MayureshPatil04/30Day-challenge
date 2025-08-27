public class Challenge12 {

    public static String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";

        int n = s.length();
        int start = 0, maxLen = 1;

        for (int center = 0; center < 2 * n - 1; center++) {
            int left = center / 2;
            int right = left + center % 2;

            for (; left >= 0 && right < n; left--, right++) {
                if (s.charAt(left) != s.charAt(right)) break;
                int currLen = right - left + 1;
                if (currLen > maxLen) {
                    maxLen = currLen;
                    start = left;
                }
            }
        }
        return s.substring(start, start + maxLen);
    }

    // Test cases
    public static void main(String[] args) {
          // Test case 1
        System.out.println(longestPalindrome("babad")); 
          // Test case 2
        System.out.println(longestPalindrome("cbbd"));
          // Test case 3  
        System.out.println(longestPalindrome("a"));    
          // Test case 4
        System.out.println(longestPalindrome("aaaa"));  
          // Test case 5
        System.out.println(longestPalindrome("abc"));   
    }
}