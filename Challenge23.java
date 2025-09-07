import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int x) { val = x; }
}

class LowestCommonAncestorBinaryTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        return (left != null && right != null) ? root : (left != null ? left : right);
    }

    public TreeNode buildTree(Integer[] nodes) {
        if (nodes.length == 0 || nodes[0] == null) return null;
        TreeNode root = new TreeNode(nodes[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int i = 1;
        while (!queue.isEmpty() && i < nodes.length) {
            TreeNode current = queue.poll();
            if (i < nodes.length && nodes[i] != null) {
                current.left = new TreeNode(nodes[i]);
                queue.add(current.left);
            }
            i++;
            if (i < nodes.length && nodes[i] != null) {
                current.right = new TreeNode(nodes[i]);
                queue.add(current.right);
            }
            i++;
        }
        return root;
    }

    public TreeNode findNode(TreeNode root, int val) {
        if (root == null) return null;
        if (root.val == val) return root;
        TreeNode left = findNode(root.left, val);
        return (left != null) ? left : findNode(root.right, val);
    }
}

public class Challenge23 {
    public static void main(String[] args) {
        LowestCommonAncestorBinaryTree solver = new LowestCommonAncestorBinaryTree();
        Integer[] tree = {3,5,1,6,2,0,8,null,null,7,4};
        TreeNode root = solver.buildTree(tree);
        TreeNode p = solver.findNode(root, 5);
        TreeNode q = solver.findNode(root, 1);
        TreeNode lca = solver.lowestCommonAncestor(root, p, q);
        System.out.println("LCA of " + p.val + " and " + q.val + " is: " + lca.val); // Should print 3
    }
}
