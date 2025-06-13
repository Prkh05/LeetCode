class Solution {
    public String gcdOfStrings(String str1, String str2) {
        // If str1 + str2 != str2 + str1, then there's no common divisor
        if (!(str1 + str2).equals(str2 + str1)) {
            return "";
        }
        
        // The length of the GCD string must be the GCD of the lengths
        int gcdLength = gcd(str1.length(), str2.length());
        
        // Return the substring of length gcdLength
        return str1.substring(0, gcdLength);
    }
    
    // Helper method to find GCD of two numbers using Euclidean algorithm
    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}