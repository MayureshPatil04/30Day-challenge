import java.util.Scanner;

public class Challenge28
{
    public static void main(String[] args)
     {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter n (0 to 92): ");
        int n = scanner.nextInt();

        if (n == 0) 
        {
            System.out.println("Fibonacci number F(0) is: 0");
            return;
        } else if (n == 1)
         {
            System.out.println("Fibonacci number F(1) is: 1");
            return;
        }

        long[] fib = new long[n + 1];
        fib[0] = 0;
        fib[1] = 1;

        for (int i = 2; i <= n; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }

        System.out.println("Fibonacci number F(" + n + ") is: " + fib[n]);
    }
}
