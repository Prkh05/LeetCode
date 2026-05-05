class Solution {
    public void moveZeroes(int[] nums) {
        int pos =0;
        int n = nums.length;
        int[] result = new int[n]; 
        for(int i =0;i<nums.length;i++){
            if(nums[i]!=0){
                result[pos] = nums[i];
                pos++;
            }
        }
        for(int i = pos; i < n; i++) {
            result[i] = 0; 
        }
        for(int i = 0; i < n; i++) {
            nums[i] = result[i];
        }
        
    }
}