class Solution {
    public String reverseVowels(String s) {
        // Convert string to char array for easy manipulation
        char[] chars = s.toCharArray();
        
        // Two pointers: left starts from beginning, right from end
        int left = 0;
        int right = s.length() - 1;
        
        // Set of vowels for quick lookup (both cases)
        String vowels = "aeiouAEIOU";
        
        while (left < right) {
            // Move left pointer until we find a vowel
            while (left < right && vowels.indexOf(chars[left]) == -1) {
                left++;
            }
            
            // Move right pointer until we find a vowel
            while (left < right && vowels.indexOf(chars[right]) == -1) {
                right--;
            }
            
            // Swap the vowels at left and right positions
            if (left < right) {
                char temp = chars[left];
                chars[left] = chars[right];
                chars[right] = temp;
                
                // Move both pointers inward
                left++;
                right--;
            }
        }
        
        return new String(chars);
    }
}