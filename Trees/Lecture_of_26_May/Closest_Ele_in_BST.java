public class Closest_Sum {
    class Solution
{
    //Function to find the least absolute difference between any node
    //value of the BST and the given integer.
    static int minD=Integer.MAX_VALUE;
    static int minDiff(Node  root, int K) 
    { 
        minD=Integer.MAX_VALUE;
        helper(root,K);
        return minD;
        
    } 
    
    public static  void helper(Node root,int k){
        if(root==null)
        return;
        
        int m=Math.abs(k-root.data);
        minD=Math.min(m,minD);
        if(root.data>k){
            helper(root.left,k);
        }
        else if(root.data<k){
            helper(root.right,k);
        }
        else{
            return;
        }
    }
}
}
