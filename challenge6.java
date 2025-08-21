
public class challenge6 {
    public static int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }

        int left = 0, right = height.length - 1;
        int leftMax = height[left], rightMax = height[right];
        int trappedWater = 0;

        while (left < right) {
            if (height[left] < height[right]) {
                left++;
                leftMax = Math.max(leftMax, height[left]);
                trappedWater += Math.max(0, leftMax - height[left]);
            } else {
                right--;
                rightMax = Math.max(rightMax, height[right]);
                trappedWater += Math.max(0, rightMax - height[right]);
            }
        }

        return trappedWater;
    }

    public static void main(String[] args) {
       
        int[][] testCases = {
            {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1},
            {4, 2, 0, 3, 2, 5},
            {1, 1, 1},
            {5},
            {2, 0, 2}
        };

        for (int i = 0; i < testCases.length; i++) {
            int result = trap(testCases[i]);
            System.out.println("Test case " + (i + 1) + ": Trapped water = " + result);
        }
    }
}