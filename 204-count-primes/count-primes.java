class Solution {
    public int countPrimes(int n) {
        // Handle edge cases
        if (n <= 2) {
            return 0;
        }
        
        // Create boolean array to track prime numbers
        // isPrime[i] represents whether i is prime
        boolean[] isPrime = new boolean[n];
        
        // Initialize all numbers as prime (except 0 and 1)
        for (int i = 2; i < n; i++) {
            isPrime[i] = true;
        }
        
        // Sieve of Eratosthenes
        for (int i = 2; i * i < n; i++) {
            if (isPrime[i]) {
                // Mark all multiples of i as non-prime
                for (int j = i * i; j < n; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        
        // Count prime numbers
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime[i]) {
                count++;
            }
        }
        
        return count;
    }
}

// Alternative more optimized version with space optimization
class SolutionOptimized {
    public int countPrimes(int n) {
        if (n <= 2) return 0;
        
        // Only track odd numbers (except 2)
        // Index i represents number 2*i+3
        boolean[] isPrime = new boolean[(n-1)/2];
        java.util.Arrays.fill(isPrime, true);
        
        int count = 1; // Count 2 as prime
        
        // Check odd numbers starting from 3
        for (int i = 0; i < isPrime.length; i++) {
            if (isPrime[i]) {
                int num = 2 * i + 3;
                count++;
                
                // Mark multiples as non-prime
                for (long j = (long)num * num; j < n; j += 2 * num) {
                    isPrime[((int)j - 3) / 2] = false;
                }
            }
        }
        
        return count;
    }
}