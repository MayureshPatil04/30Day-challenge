import java.util.*;

public class Challenge9 {
    public static void main(String[] args) {
        // Test Case 1
        String[] strs1 = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println("Input: " + Arrays.toString(strs1));
        groupAnagrams(strs1);

        // Test Case 2
        String[] strs2 = {""};
        System.out.println("\nInput: " + Arrays.toString(strs2));
        groupAnagrams(strs2);

        // Test Case 3
        String[] strs3 = {"a"};
        System.out.println("\nInput: " + Arrays.toString(strs3));
        groupAnagrams(strs3);

        // Test Case 4
        String[] strs4 = {"abc", "bca", "cab", "xyz", "zyx", "yxz"};
        System.out.println("\nInput: " + Arrays.toString(strs4));
        groupAnagrams(strs4);

        // Test Case 5
        String[] strs5 = {"abc", "def", "ghi"};
        System.out.println("\nInput: " + Arrays.toString(strs5));
        groupAnagrams(strs5);
    }
    public static void groupAnagrams(String[] strs) {
        HashMap<String, ArrayList<String>> map = new HashMap<>();

        for (String word : strs) {
            char[] arr = word.toCharArray();
            Arrays.sort(arr);
            String key = new String(arr);

            if (map.containsKey(key)) {
                map.get(key).add(word);
            } else {
                ArrayList<String> list = new ArrayList<>();
                list.add(word);
                map.put(key, list);
            }
        }
        System.out.println("Output: " + map.values());
    }
}


    
