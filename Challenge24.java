import java.util.*; 

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class Challenge24 {

    // Method to check if the tree is a valid BST
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    // Helper method that checks the BST property using value bounds
    private boolean isValidBST(TreeNode node, long min, long max) {
        if (node == null) return true;

        if (node.val <= min || node.val >= max) return false;

        return isValidBST(node.left, min, node.val) &&
               isValidBST(node.right, node.val, max);
    }

    // Main method with test cases
    public static void main(String[] args) {
        Challenge24 validator = new Challenge24();

        // Test Case 1: [2, 1, 3]
        TreeNode root1 = new TreeNode(2);
        root1.left = new TreeNode(1);
        root1.right = new TreeNode(3);
        System.out.println("Test Case 1: " + validator.isValidBST(root1)); // true

        // Test Case 2: [5, 1, 4, null, null, 3, 6]
        TreeNode root2 = new TreeNode(5);
        root2.left = new TreeNode(1);
        root2.right = new TreeNode(4);
        root2.right.left = new TreeNode(3);
        root2.right.right = new TreeNode(6);
        System.out.println("Test Case 2: " + validator.isValidBST(root2)); // false

        // Test Case 3: [10, 5, 15, null, null, 6, 20]
        TreeNode root3 = new TreeNode(10);
        root3.left = new TreeNode(5);
        root3.right = new TreeNode(15);
        root3.right.left = new TreeNode(6);
        root3.right.right = new TreeNode(20);
        System.out.println("Test Case 3: " + validator.isValidBST(root3)); // false

        // Test Case 4: Single Node
        TreeNode root4 = new TreeNode(1);
        System.out.println("Test Case 4: " + validator.isValidBST(root4)); // true

        // Test Case 5: Duplicate Value (Invalid BST)
        TreeNode root5 = new TreeNode(2);
        root5.left = new TreeNode(2);
        System.out.println("Test Case 5: " + validator.isValidBST(root5)); // false
    }
}
