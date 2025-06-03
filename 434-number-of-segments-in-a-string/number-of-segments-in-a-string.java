class Solution {
    
    public int countSegments(String s) {
        
        String[] parts = s.split(" ");
        int count = 0;
        
        for (String part : parts) {
            if (!part.isEmpty()) {
                count++;
            }
        }
        
        return count;
    }
}