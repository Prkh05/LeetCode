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
    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }
    
    private int dfs(TreeNode node, int currentNumber) {
        // Base case: if node is null, return 0
        if (node == null) {
            return 0;
        }
        
        // Build the current number by appending the node's value
        currentNumber = currentNumber * 10 + node.val;
        
        // If it's a leaf node, return the complete number
        if (node.left == null && node.right == null) {
            return currentNumber;
        }
        
        // Recursively sum the numbers from left and right subtrees
        int leftSum = dfs(node.left, currentNumber);
        int rightSum = dfs(node.right, currentNumber);
        
        return leftSum + rightSum;
    }
}