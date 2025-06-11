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
    
    // Approach 1: Recursive In-order Traversal with Early Stopping
    // Time: O(H + k) where H is height of tree, Space: O(H) for recursion stack
    private int count = 0;
    private int result = 0;
    
    public int kthSmallest(TreeNode root, int k) {
        count = 0;
        inorder(root, k);
        return result;
    }
    
    private void inorder(TreeNode node, int k) {
        if (node == null) return;
        
        inorder(node.left, k);
        
        count++;
        if (count == k) {
            result = node.val;
            return;
        }
        
        inorder(node.right, k);
    }
    
    // Approach 2: Iterative In-order Traversal (Alternative)
    // Time: O(H + k), Space: O(H) for stack
    public int kthSmallestIterative(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        int count = 0;
        
        while (curr != null || !stack.isEmpty()) {
            // Go to the leftmost node
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            
            // Process current node
            curr = stack.pop();
            count++;
            
            if (count == k) {
                return curr.val;
            }
            
            // Move to right subtree
            curr = curr.right;
        }
        
        return -1; // Should never reach here given constraints
    }
}

/*
Explanation:

The key insight is that in-order traversal of a BST visits nodes in ascending order.
So the kth node visited during in-order traversal is the kth smallest element.

Approach 1 (Recursive):
1. Perform in-order traversal: left -> root -> right
2. Keep a counter to track how many nodes we've visited
3. When counter reaches k, we've found our answer
4. Early stopping prevents unnecessary traversal

Approach 2 (Iterative):
1. Use a stack to simulate the recursive in-order traversal
2. Push all left children onto stack first
3. Pop and process nodes, incrementing counter
4. When counter reaches k, return the current node's value

Time Complexity: O(H + k) where H is the height of the tree
- In worst case, we might need to go down to a leaf (H operations)
- Then visit k nodes
- Best case: O(k), Worst case: O(n) when k = n

Space Complexity: O(H) for the recursion stack or explicit stack
- H can be O(log n) for balanced tree or O(n) for skewed tree

Example walkthrough for root = [5,3,6,2,4,null,null,1], k = 3:
Tree structure:
       5
      / \
     3   6
    / \
   2   4
  /
 1

In-order traversal visits: 1, 2, 3, 4, 5, 6
So kth smallest for k=3 is 3.
*/