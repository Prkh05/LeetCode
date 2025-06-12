class Solution {
    
    // Approach 1: Convert to Array (Easier to understand)
    public TreeNode sortedListToBST(ListNode head) {
        // Convert linked list to array for easy random access
        List<Integer> values = new ArrayList<>();
        ListNode curr = head;
        while (curr != null) {
            values.add(curr.val);
            curr = curr.next;
        }
        
        return buildBST(values, 0, values.size() - 1);
    }
    
    private TreeNode buildBST(List<Integer> values, int left, int right) {
        if (left > right) {
            return null;
        }
        
        // Choose middle element as root for balanced tree
        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(values.get(mid));
        
        // Recursively build left and right subtrees
        root.left = buildBST(values, left, mid - 1);
        root.right = buildBST(values, mid + 1, right);
        
        return root;
    }
    
    // Approach 2: Two-Pointer Technique (More space-efficient)
    public TreeNode sortedListToBST_Optimized(ListNode head) {
        if (head == null) return null;
        return buildBSTFromList(head, null);
    }
    
    private TreeNode buildBSTFromList(ListNode head, ListNode tail) {
        if (head == tail) return null;
        
        // Find middle node using slow-fast pointer technique
        ListNode slow = head;
        ListNode fast = head;
        
        while (fast != tail && fast.next != tail) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // Middle node becomes root
        TreeNode root = new TreeNode(slow.val);
        
        // Recursively build left and right subtrees
        root.left = buildBSTFromList(head, slow);
        root.right = buildBSTFromList(slow.next, tail);
        
        return root;
    }
    
    // Approach 3: Inorder Simulation (Most space-efficient)
    private ListNode globalHead;
    
    public TreeNode sortedListToBST_InorderSimulation(ListNode head) {
        globalHead = head;
        
        // First, count the total number of nodes
        int size = getListSize(head);
        
        return buildBSTInorder(0, size - 1);
    }
    
    private int getListSize(ListNode head) {
        int size = 0;
        while (head != null) {
            size++;
            head = head.next;
        }
        return size;
    }
    
    private TreeNode buildBSTInorder(int left, int right) {
        if (left > right) return null;
        
        int mid = left + (right - left) / 2;
        
        // Build left subtree first (inorder: left -> root -> right)
        TreeNode leftChild = buildBSTInorder(left, mid - 1);
        
        // Process current node (this simulates inorder traversal)
        TreeNode root = new TreeNode(globalHead.val);
        root.left = leftChild;
        globalHead = globalHead.next; // Move to next node
        
        // Build right subtree
        root.right = buildBSTInorder(mid + 1, right);
        
        return root;
    }
}