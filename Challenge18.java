import java.util.Stack;

public class Challenge18 {

    public static int evaluatePostfix(String expression) {
        Stack<Integer> stack = new Stack<>();
        String[] tokens = expression.trim().split("\\s+");

        for (String token : tokens) {
            if (isOperator(token)) {
                int b = stack.pop();
                int a = stack.pop();
                int result = applyOperator(a, b, token);
                stack.push(result);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }

        return stack.pop(); // final result
    }

    private static boolean isOperator(String token) {
        return token.equals("+") || token.equals("-") ||
               token.equals("*") || token.equals("/");
    }

    private static int applyOperator(int a, int b, String operator) {
        switch (operator) {
            case "+": return a + b;
            case "-": return a - b;
            case "*": return a * b;
            case "/": return a / b; // Java integer division truncates toward zero
            default: throw new IllegalArgumentException("Invalid operator: " + operator);
        }
    }

    // For quick testing
    public static void main(String[] args) {
        System.out.println(evaluatePostfix("2 1 + 3 *"));            // 9
        System.out.println(evaluatePostfix("5 6 +"));                // 11
        System.out.println(evaluatePostfix("-5 6 -"));               // -11
        System.out.println(evaluatePostfix("15 7 1 1 + - / 3 * 2 1 1 + + -")); // 5
        System.out.println(evaluatePostfix("5"));                    // 5
    }
}
