// Minimum Moves to Equal Array Elements
class Solution {
    public int minMoves(int[] nums) {
        int min=Integer.MAX_VALUE;
        for(int n:nums){
            min=Math.min(n,min);
        }
        
        int c=0;
        for(int n:nums){
            c+=(n-min);
        }
        
        return c;
    }
}
