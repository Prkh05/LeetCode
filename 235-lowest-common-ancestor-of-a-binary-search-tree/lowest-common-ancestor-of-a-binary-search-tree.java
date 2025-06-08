/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
       
        TreeNode current = root;
        
        while (current != null) {
            
            if (p.val < current.val && q.val < current.val) {
                current = current.left;
            }
            
            else if (p.val > current.val && q.val > current.val) {
                current = current.right;
            }
           
            
            else {
                return current;
            }
        }
        
        return null; 
    }
    
    // Alternative recursive approach
    public TreeNode lowestCommonAncestorRecursive(TreeNode root, TreeNode p, TreeNode q) {
        // Base case: if root is null
        if (root == null) return null;
        
        
        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestorRecursive(root.left, p, q);
        }
        
       
        if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestorRecursive(root.right, p, q);
        }
        
    
        return root;
    }
}