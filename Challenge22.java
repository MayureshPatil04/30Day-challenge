import java.util.*;

public class Challenge22 {

    public static List<Integer> maxSlidingWindow(int[] arr, int k) {
        List<Integer> result = new ArrayList<>();
        Deque<Integer> deque = new LinkedList<>();

        for (int i = 0; i < arr.length; i++) {
            // Remove indices that are out of this window
            if (!deque.isEmpty() && deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }

            // Remove indices whose values are less than arr[i]
            while (!deque.isEmpty() && arr[deque.peekLast()] < arr[i]) {
                deque.pollLast();
            }

            // Add current index to deque
            deque.offerLast(i);

            // Add the maximum to result list once the first window is formed
            if (i >= k - 1) {
                result.add(arr[deque.peekFirst()]);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 3, -1, -3, 5, 3, 6, 7};
        int k1 = 3;
        System.out.println(maxSlidingWindow(arr1, k1)); // Output: [3, 3, 5, 5, 6, 7]

        int[] arr2 = {1, 5, 3, 2, 4, 6};
        int k2 = 3;
        System.out.println(maxSlidingWindow(arr2, k2)); // Output: [5, 5, 4, 6]

        int[] arr3 = {1, 2, 3, 4};
        int k3 = 2;
        System.out.println(maxSlidingWindow(arr3, k3)); // Output: [2, 3, 4]

        int[] arr4 = {7, 7, 7, 7};
        int k4 = 1;
        System.out.println(maxSlidingWindow(arr4, k4)); // Output: [7, 7, 7, 7]

        int[] arr5 = {10};
        int k5 = 1;
        System.out.println(maxSlidingWindow(arr5, k5)); // Output: [10]
    }
}
