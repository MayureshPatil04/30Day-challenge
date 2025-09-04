import java.util.Stack;

public class Challenge20 {

    public static void sortStack(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }

        int temp = stack.pop();
        sortStack(stack);
        insertSorted(stack, temp);
    }

    private static void insertSorted(Stack<Integer> stack, int element) {
        if (stack.isEmpty() || stack.peek() <= element) {
            stack.push(element);
            return;
        }

        int temp = stack.pop();
        insertSorted(stack, element);
        stack.push(temp);
    }

    public static void printStack(Stack<Integer> stack) {
        // Prints from top to bottom
        for (int i = stack.size() - 1; i >= 0; i--) {
            System.out.print(stack.get(i) + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        test(new int[]{3, 1, 4, 2});
        test(new int[]{7, 1, 5});
        test(new int[]{5});
        test(new int[]{-3, 14, 8, 2});
        test(new int[]{});
        test(new int[]{3, 3, 3});
    }

    private static void test(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        for (int i = arr.length - 1; i >= 0; i--) {
            stack.push(arr[i]);
        }

        System.out.println("Original stack:");
        printStack(stack);

        sortStack(stack);

        System.out.println("Sorted stack:");
        printStack(stack);
        System.out.println("---------------");
    }
}
