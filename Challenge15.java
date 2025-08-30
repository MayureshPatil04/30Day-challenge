public class Challenge15
{
    public static long gcd(long a,long b)
    {
        while(b !=0)
        {
            long temp = b;
            b=a%b;
            a=temp;
        }
        return a;
    }
    public static long lcm(long a,long b)
    {
        return(a/gcd(a,b))*b;
    }
    public static void main(String[]args)
    {
        long[][]testCases=
        {
            //Test case1
            {4,6},
            //Test case2
            {5,10},
            //Test case3
            {7,10},
            //Test case4
            {
                1,987654321
            },
            //Test case5
            {
                123456,7889012
            }
        };
            for(long[]tc : testCases)
            {
                long N=tc[0],M=tc[1];
                long result=lcm(N,M);
                System.out.printf("Input:N=%d,M=%d\nOutput:%d\n\n",N,M,result);
            }
        
    }
}