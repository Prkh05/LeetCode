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
    // Recursive Solution (Clean and Intuitive)
    public TreeNode insertIntoBST(TreeNode root, int val) {
        // Base case: if current node is null, create new node
        if (root == null) {
            return new TreeNode(val);
        }
        
        // If value is less than current node, insert in left subtree
        if (val < root.val) {
            root.left = insertIntoBST(root.left, val);
        } 
        // If value is greater than current node, insert in right subtree
        else {
            root.right = insertIntoBST(root.right, val);
        }
        
        return root;
    }
    
    // Iterative Solution (More Space Efficient)
    public TreeNode insertIntoBST_Iterative(TreeNode root, int val) {
        // Handle empty tree
        if (root == null) {
            return new TreeNode(val);
        }
        
        TreeNode current = root;
        
        while (true) {
            if (val < current.val) {
                // Go left
                if (current.left == null) {
                    current.left = new TreeNode(val);
                    break;
                } else {
                    current = current.left;
                }
            } else {
                // Go right
                if (current.right == null) {
                    current.right = new TreeNode(val);
                    break;
                } else {
                    current = current.right;
                }
            }
        }
        
        return root;
    }
}