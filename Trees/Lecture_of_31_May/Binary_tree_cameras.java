public class Binary_tree_cameras {
    class Solution {
        int c=0;
        final int cam=1;
        final int mon=2;
        final int nmon=3;
        public int minCameraCover(TreeNode root) {
            int v=helper(root);
            if(v==nmon){
                c++;
            }
            return c;
            
        }
        
        public int helper(TreeNode root){
            if(root==null)
                return mon;
            int left=helper(root.left);
            int right=helper(root.right);
            
            if(left==nmon || right==nmon){
                c++;
                return cam;
            }
            else if(left==cam|| right==cam){
                return mon;
            }
            else{
                return nmon;
            }
        }
    }
}
