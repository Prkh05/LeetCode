class Solution {
    public int mySqrt(int x) {
        // Handle edge cases
        if (x == 0 || x == 1) {
            return x;
        }
        
        // Binary search approach
        int left = 1;
        int right = x;
        int result = 0;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            // Use division to avoid overflow: mid <= x/mid instead of mid*mid <= x
            if (mid <= x / mid) {
                result = mid; // This could be our answer
                left = mid + 1; // Search for a potentially larger answer
            } else {
                right = mid - 1; // mid is too large, search smaller values
            }
        }
        
        return result;
    }
}