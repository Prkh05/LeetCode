/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    // Iterative approach
    public TreeNode searchBST(TreeNode root, int val) {
        while (root != null && root.val != val) {
            root = (val < root.val) ? root.left : root.right;
        }
        return root;
    }
    
    // Alternative: Recursive approach
    public TreeNode searchBSTRecursive(TreeNode root, int val) {
        // Base case: empty tree or found the node
        if (root == null || root.val == val) {
            return root;
        }
        
        // If target is smaller, search left subtree
        if (val < root.val) {
            return searchBSTRecursive(root.left, val);
        }
        
        // If target is larger, search right subtree
        return searchBSTRecursive(root.right, val);
    }
}