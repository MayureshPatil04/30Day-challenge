import java.util.arrays;
public class Challenge5 {
     
     static int arr(int arr[]){
        
        int n = arr.length;

        System.out.print("Output: [");

        boolean first = true; 
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += arr[j];
                if (sum == 0) {
                    if (!first) {
                        System.out.print(", ");
                    }
                    System.out.print("(" + i + ", " + j + ")");
                    first = false;
                }
            }
        }

        System.out.println("]");
        return 1;
    }
    public static void main(String[] args) {

        Challenge5 sc=new Challenge5();

        //Case study1
        int[] arr1 = {4, -1, -3, 1, 2, -1};
        sc.arr(arr1);

        //Case study2
        int [] arr2={1, 2, 3, 4};
        sc.arr(arr2);

        //Case study3
        int [] arr3={0, 0, 0};
        sc.arr(arr3);

        //Case study4
        int [] arr4={-3, 1, 2, -3, 4, 0};
        sc.arr(arr4);

    }
       
}