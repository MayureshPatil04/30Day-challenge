import java.util.*;

public class Challenge21{

    public static int findFirstElementWithKOccurrences(int[] arr, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();

        for (int num : arr) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

   
        for (int num : arr) {
            if (freqMap.get(num) == k) {
                return num;
            }
        }

        return -1; 
    }

    public static void main(String[] args) {
       
        System.out.println(findFirstElementWithKOccurrences(new int[]{3, 1, 4, 4, 5, 2, 6, 1, 4}, 2)); // Output: 1
        System.out.println(findFirstElementWithKOccurrences(new int[]{2, 3, 4, 2, 2, 5, 5}, 2));       // Output: 5
        System.out.println(findFirstElementWithKOccurrences(new int[]{1, 1, 1, 1}, 1));               // Output: -1
        System.out.println(findFirstElementWithKOccurrences(new int[]{10}, 1));                      // Output: 10
        System.out.println(findFirstElementWithKOccurrences(new int[]{6, 6, 6, 6, 7, 7, 8, 8, 8}, 3)); // Output: 8
    }
}
