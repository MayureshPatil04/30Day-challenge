public class Challenge14 {
    public static int lengthOfLongestSubstring(String s) {
        int[] lastIndex = new int[128];
        for (int i = 0; i < 128; i++) {
            lastIndex[i] = -1;
        }

        int maxLength = 0;
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            
            char current = s.charAt(right);
            if (lastIndex[current] >= left) {
                left = lastIndex[current] + 1;
            }
            lastIndex[current] = right;
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        // Test case 1
        System.out.println(lengthOfLongestSubstring("abcabcbb")); 
        // Test case 2
        System.out.println(lengthOfLongestSubstring("bbbbb"));    
        // Test case 3
        System.out.println(lengthOfLongestSubstring("pwwkew"));   
        // Test case 4
        System.out.println(lengthOfLongestSubstring("abcdefgh"));
        // Test case 5
        System.out.println(lengthOfLongestSubstring("a"));        
    }
}