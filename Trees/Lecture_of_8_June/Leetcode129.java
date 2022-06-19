class Solution {
    int tot=0;
    public int sumNumbers(TreeNode root) {
        helper(root,0);
        return tot;
    }
    
    public void helper(TreeNode root,int sum){
        if(root==null) return;
        sum=sum*10+root.val;
        if(root.left==null && root.right==null)
            tot+=sum;
        
        helper(root.left,sum);
        helper(root.right,sum);
        
        
        
    }
}public class Leetcode129 {
    
}
