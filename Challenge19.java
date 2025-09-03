import java.util.Stack;

public class Challenge19 {

    static void sortStack(Stack<Integer> stack) 
    {
        if (!stack.isEmpty()) 
        {
            int top = stack.pop();         
            sortStack(stack);              
            insertSorted(stack, top);      
        }
    }

    static void insertSorted(Stack<Integer> stack, int value)
     {
        if (stack.isEmpty() || stack.peek() > value) 
        {
            stack.push(value);
        }
         else 
        {
            int top = stack.pop();
            insertSorted(stack, value);
            stack.push(top);
        }
    }

    static void printStack(Stack<Integer> stack)
     {
        for (int i = stack.size() - 1; i >= 0; i--) 
        {
            System.out.print(stack.get(i) + " ");
        }
        System.out.println();
    }

    
    public static void main(String[] args) 
    {
        test(new int[]{3, 1, 4, 2});
        test(new int[]{7, 1, 5});
        test(new int[]{5});
        test(new int[]{-3, 14, 8, 2});
        test(new int[]{});
        test(new int[]{3, 3, 3});
    }

    static void test(int[] arr)
    
    {
        Stack<Integer> stack = new Stack<>();
        for (int i = arr.length - 1; i >= 0; i--)
         {
            stack.push(arr[i]);
        }

        System.out.print("Original: ");
        printStack(stack);

        sortStack(stack);

        System.out.print("Sorted:   ");
        printStack(stack);
        System.out.println();
    }
}
