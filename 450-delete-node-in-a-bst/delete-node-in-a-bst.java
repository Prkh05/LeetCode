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
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        
        // Search for the node to delete
        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else {
            // Found the node to delete
            
            // Case 1: Node has no children (leaf node)
            if (root.left == null && root.right == null) {
                return null;
            }
            
            // Case 2: Node has one child
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }
            
            // Case 3: Node has two children
            // Find the inorder successor (smallest node in right subtree)
            TreeNode successor = findMin(root.right);
            
            // Replace current node's value with successor's value
            root.val = successor.val;
            
            // Delete the successor node (which has at most one right child)
            root.right = deleteNode(root.right, successor.val);
        }
        
        return root;
    }
    
    // Helper method to find the minimum value node in a subtree
    private TreeNode findMin(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }
}