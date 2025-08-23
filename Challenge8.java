import java.util.*;

public class Challenge8 {
    
    public static String Challenge8(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        
        String prefix = strs[0];

        for (int i = 1; i < strs.length; i++) {
            String current = strs[i];
            String newPrefix = "";

            
            for (int j = 0; j < prefix.length() && j < current.length(); j++) {
                if (prefix.charAt(j) == current.charAt(j)) {
                    newPrefix += prefix.charAt(j); 
                } else {
                    break; 
                }
            }
            prefix = newPrefix;

            
            if (prefix.isEmpty()) {
                return "";
            }
        }

        return prefix;
    }

    public static void main(String[] args) {
        // Test case1
        String[] strs1 = {"flower", "flow", "flight"};
        // Test case 2
        String[] strs2 = {"dog", "racecar", "car"};
        // Test case 3
        String[] strs3 = {"apple", "ape", "april"};
        // Test case 4
        String[] strs4 = {""};
        // Test case 5
        String[] strs5 = {"alone"};

        System.out.println("Output: " + Challenge8(strs1)); 
        System.out.println("Output: " + Challenge8(strs2)); 
        System.out.println("Output: " + Challenge8(strs3)); 
        System.out.println("Output: " + Challenge8(strs4)); 
        System.out.println("Output: " + Challenge8(strs5)); 
    }
}