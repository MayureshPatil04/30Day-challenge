public class Challenge4 {
   static int leaders(int arr[]){
     int leader;

        for(int i=0;i<arr.length;i++){
             leader=1;
            for(int j=i+1;j<arr.length;j++){
                if(arr[i]<=arr[j]){
                    leader=0;
                    break;
                }
            }
            if (leader==1) {
                System.out.println("Leaders:"+arr[i]);
            }
        }System.out.println();
        return 1;
    }
    public static void main(String[] args) {
        Challenge4 sc=new Challenge4();
      //Test case 1
        int [] arr1={1,2,3,4,0};
        sc.leaders(arr1);
      //Test case 2
        int [] arr2={7,10,4,10,6,5,2};
        sc.leaders(arr2);
      //Test case 3
        int arr3[]={5};
        sc.leaders(arr3);

      //Test case4
        int [] arr4={100,50,20,10};
        sc.leaders(arr4);
      //Test case 5
    int n = 99999;
        int[] arr5 = new int[n + 1];
        for(int i = 0; i < n; i++){
            arr5[i] = i + 1;
        }
        arr5[n] = 1000000; 
        sc.leaders(arr5);
       
    }
}