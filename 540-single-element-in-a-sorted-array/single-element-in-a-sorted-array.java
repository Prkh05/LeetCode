class Solution {
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        if (n%2!=0){
            if (n==1) return nums[0];
            for (int i=0; i<n; i++){
                if (i==n-1) return nums[i];
                if (nums[i]!=nums[i+1]){
                    return nums[i];
                }
                else{
                    i++;
                }
            }
        }
        return 0;
    }
}
        