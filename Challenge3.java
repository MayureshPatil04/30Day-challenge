import java.util.Arrays;

public class Challenge3 {

    public static void mergeArrays(int[] arr1, int[] arr2) {
        int n = arr1.length;
        int m = arr2.length;

        
        int[] merged = new int[n + m];

        int i = 0, j = 0, k = 0;

        
        while (i < n && j < m) {
            if (arr1[i] <= arr2[j]) {
                merged[k++] = arr1[i++];
            } else {
                merged[k++] = arr2[j++];
            }
        }

       
        while (i < n) {
            merged[k++] = arr1[i++];
        }

        
        while (j < m) {
            merged[k++] = arr2[j++];
        }

       
        for (int x = 0; x < n; x++) {
            arr1[x] = merged[x];
        }

        
        for (int x = 0; x < m; x++) {
            arr2[x] = merged[n + x];
        }
    }

    public static void main(String[] args) {
        //Test case 1
        int[] arr1 = {1, 3, 5, 7};
        int[] arr2 = {2, 4, 6, 8};
        mergeArrays(arr1, arr2);
        System.out.println("arr1 = " + Arrays.toString(arr1));
        System.out.println("arr2 = " + Arrays.toString(arr2));

        //Test case 2
        int[] arr3 = {1, 3, 5};
        int[] arr4 = {2, 4, 6};
        mergeArrays(arr3, arr4);
        System.out.println("arr3 = " + Arrays.toString(arr3));
        System.out.println("arr4 = " + Arrays.toString(arr4));

        //Test case 3
        int[] arr5 = {10,12,14};
        int[] arr6 = {1,3,5};
        mergeArrays(arr5, arr6);
        System.out.println("arr5 = " + Arrays.toString(arr5));
        System.out.println("arr6 = " + Arrays.toString(arr6));

        //Test case 4
        int[] arr7 = {2,3,8};
        int[] arr8 = {4,6,10};
        mergeArrays(arr7, arr8);
        System.out.println("arr7 = " + Arrays.toString(arr7));
        System.out.println("arr8 = " + Arrays.toString(arr8));
    }
}