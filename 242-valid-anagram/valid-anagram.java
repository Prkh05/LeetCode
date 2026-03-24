class Solution {
    public boolean isAnagram(String s, String t) {
        char[] arr1 = s.toCharArray();
        char[] arr2 = t.toCharArray();

        Arrays.sort(arr1);
        Arrays.sort(arr2);
        int m = arr1.length;
        int n = arr2.length;

        if(m!=n) return false;

        for(int i = 0;i<arr1.length;i++){
            if (arr1[i]!=arr2[i]){
                return false;
            }
        }
            
        return true;

    }
}