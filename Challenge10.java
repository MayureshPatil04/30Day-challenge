import java.util.*;

public class Challenge10 {

    public static void main(String[] args) {
        // Test case 1
        System.out.println(permute("abc"));
        // Test case 2
        System.out.println(permute("aab"));
        // Test case 3
        System.out.println(permute("aaa"));
        // Test case 4
        System.out.println(permute("a"));
        // Test case 5
        System.out.println(permute("abcd"));
    }

    public static List<String> permute(String s) {
        
        List<String> result = new ArrayList<>();
        
        
        char[] chars = s.toCharArray();
        
        
        Arrays.sort(chars);

        
        backtrack(chars, new boolean[chars.length], new StringBuilder(), result);

        return result;
    }

    
    private static void backtrack(char[] chars, boolean[] used, StringBuilder current, List<String> result) {
    
        if (current.length() == chars.length) {
            result.add(current.toString());
            return;
        }

    
        for (int i = 0; i < chars.length; i++) {
    
            if (used[i]) {
                continue;
            }
    
            if (i > 0 && chars[i] == chars[i - 1] && !used[i - 1]) {
                continue;
            }

    
            used[i] = true;
            current.append(chars[i]);

            backtrack(chars, used, current, result);


            current.deleteCharAt(current.length() - 1);
            used[i] = false;
        }
    }
}