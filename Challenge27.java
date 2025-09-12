class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Challenge27{

    // Main function to check if tree is symmetric
    public boolean isSymmetric(TreeNode root) 
    {
        if (root == null) return true;
        return isMirror(root.left, root.right);
    }

    // Helper function to check if two trees are mirror of each other
    private boolean isMirror(TreeNode t1, TreeNode t2) 
    {
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;
        if (t1.val != t2.val) return false;

        return isMirror(t1.left, t2.right) && isMirror(t1.right, t2.left);
    }

    // Example usage
    public static void main(String[] args)
     {
        SymmetricTree st = newSymmetricTree();


        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);

        // Check if the tree is symmetric
        System.out.println(st.isSymmetric(root)); 
    }
}
