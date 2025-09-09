class Solution {
    public boolean isAnagram(String s, String t) {
        
        char[] chrArrayy = s.toCharArray();
        char[] chrArray = t.toCharArray();
        Arrays.sort(chrArray);
        Arrays.sort(chrArrayy);
        if(chrArrayy.length != chrArray.length) return false;
        
        for(int i =0;i<chrArrayy.length;i++){
            
             if(chrArray[i] != chrArrayy[i]) return false;
            
        }return true;
    }
    
}