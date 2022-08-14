public class Longest_univalue {
    class Solution {
        int len=0;
        public int longestUnivaluePath(TreeNode root) {
            if(root==null)
                return 0;
            
            helper(root,-1);
            if(len>0)
            return len-1;
            else
                return len;
        }
        public int helper(TreeNode root,int val){
            if(root==null)
                return 0;
            
            int left=helper(root.left,root.val);
            int right=helper(root.right,root.val);
            if(left+right+1>len) len=left+right+1;
            if(val==root.val){
                return Math.max(left,right)+1;
            }
            else
                return 0;
        }
    }
}
