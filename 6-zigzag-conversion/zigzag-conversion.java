class Solution {
    
    // Approach 1: Simulation - Build rows by following zigzag pattern
    // Time: O(n), Space: O(n)
    public String convert(String s, int numRows) {
        // Edge case: if only 1 row or string length <= numRows, return original
        if (numRows == 1 || s.length() <= numRows) {
            return s;
        }
        
        // Create a list of StringBuilder for each row
        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            rows.add(new StringBuilder());
        }
        
        int currentRow = 0;
        boolean goingDown = false;
        
        // Process each character
        for (char c : s.toCharArray()) {
            rows.get(currentRow).append(c);
            
            // Change direction when we hit top or bottom row
            if (currentRow == 0 || currentRow == numRows - 1) {
                goingDown = !goingDown;
            }
            
            // Move to next row
            currentRow += goingDown ? 1 : -1;
        }
        
        // Concatenate all rows
        StringBuilder result = new StringBuilder();
        for (StringBuilder row : rows) {
            result.append(row);
        }
        
        return result.toString();
    }
}