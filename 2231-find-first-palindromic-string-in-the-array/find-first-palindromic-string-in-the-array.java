class Solution {
    public String firstPalindrome(String[] words) {
        // Iterate through each word in the array
        for (String word : words) {
            // Check if the current word is a palindrome
            if (isPalindrome(word)) {
                return word;
            }
        }
        // If no palindrome is found, return empty string
        return "";
    }
    
    // Helper method to check if a string is a palindrome
    private boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        
        // Compare characters from both ends moving inward
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}