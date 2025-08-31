import java.util.*;

public class Challenge16
{

    public static List<Integer> primeFactors(int n) 
    {
        List<Integer> factors = new ArrayList<>();

        // Factor out all 2s first
        while (n % 2 == 0) 
        {
            factors.add(2);
            n /= 2;
        }

        // Check for odd divisors from 3 onwards
        for (int i = 3; i * i <= n; i += 2) 
        {
            while (n % i == 0) 
            {
                factors.add(i);
                n /= i;
            }
        }

        // If n is a prime number greater than 2
        if (n > 2) 
        {
            factors.add(n);
        }

        return factors;
    }

    public static void main(String[] args) 
    {
        // Example test cases
        int[] testInputs = {18, 30, 49, 19, 64, 123456};

        for (int n : testInputs)
         {
            System.out.println("Input: N = " + n);
            System.out.println("Output: " + primeFactors(n));
            System.out.println();
        }
    }
}
