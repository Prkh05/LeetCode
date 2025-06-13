class Solution {
    public int findJudge(int n, int[][] trust) {
        // Array to track trust balance for each person
        // trustCount[i] = number of people who trust person i - number of people person i trusts
        int[] trustCount = new int[n + 1];
        
        // Process each trust relationship
        for (int[] relation : trust) {
            int truster = relation[0];
            int trusted = relation[1];
            
            // Person who trusts loses a point (they trust someone)
            trustCount[truster]--;
            
            // Person who is trusted gains a point
            trustCount[trusted]++;
        }
        
        // The judge should have trustCount = n - 1
        // (trusted by everyone else, trusts nobody)
        for (int i = 1; i <= n; i++) {
            if (trustCount[i] == n - 1) {
                return i;
            }
        }
        
        // No judge found
        return -1;
    }
}