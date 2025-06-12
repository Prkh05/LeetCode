class Solution {
    // Helper method to check if a character is a vowel
    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
    
    public int maxVowels(String s, int k) {
        
        // Count vowels in the first window of size k
        int currentVowels = 0;
        for (int i = 0; i < k; i++) {
            if (isVowel(s.charAt(i))) {
                currentVowels++;
            }
        }
        
        int maxVowels = currentVowels;
        
        // Slide the window from position k to end of string
        for (int i = k; i < s.length(); i++) {
            // Remove the leftmost character of previous window
            if (isVowel(s.charAt(i - k))) {
                currentVowels--;
            }
            
            // Add the rightmost character of current window
            if (isVowel(s.charAt(i))) {
                currentVowels++;
            }
            
            // Update maximum
            maxVowels = Math.max(maxVowels, currentVowels);
        }
        
        return maxVowels;
    }
}