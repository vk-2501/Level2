class Solution {
    int max=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        max=Integer.MIN_VALUE;
        helper(root);
        return max;
    }
    
    public int helper(TreeNode root){
        if(root==null)
            return 0;
        
        int left=helper(root.left);
        int right=helper(root.right);
        
        int left_dash=Math.max(left,0);
        int right_dash=Math.max(right,0);
        
        int maxpathsum=left_dash+root.val+right_dash;
        if(maxpathsum>max){
            max=maxpathsum;
        }
        
        return Math.max(left_dash,right_dash)+root.val;
        
    }
}public class Max_Path_Sum_node_to_node {
    
}
