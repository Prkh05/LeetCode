class Solution {
    public int findCenter(int[][] edges) {
        // The center node must appear in every edge
        // So it must appear in both the first and second edge
        // Check which node from the first edge also appears in the second edge
        
        int[] firstEdge = edges[0];
        int[] secondEdge = edges[1];
        
        // Check if first node of first edge is in second edge
        if (firstEdge[0] == secondEdge[0] || firstEdge[0] == secondEdge[1]) {
            return firstEdge[0];
        }
        // Otherwise, the second node of first edge must be the center
        else {
            return firstEdge[1];
        }
    }
}