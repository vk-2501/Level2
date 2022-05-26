public class Post_IN_Construction {
    class Solution {
        public TreeNode buildTree(int[] inorder, int[] postorder) {
             HashMap<Integer,Integer> hm=new HashMap<>();
            for(int i=0;i<inorder.length;i++){
                int val=inorder[i];
                hm.put(val,i);
            }
            
            TreeNode root=construct(0,postorder.length-1,0,inorder.length-1,postorder,hm);
            return root;
        }
        
         TreeNode construct(int post_lo,int post_hi,int in_lo,int in_hi,int[] post, HashMap<Integer,Integer> hm){
            //base case
            if(post_lo>post_hi || in_lo>in_hi){
                return null;
            }
            
            TreeNode node=new TreeNode();
            node.val=post[post_hi];
            
            int idx=hm.get(post[post_hi]);
            int rhs=in_hi-idx;   
            
            node.left=construct(post_lo,post_hi-rhs-1,in_lo,idx-1,post,hm);
            node.right=construct(post_hi-rhs,post_hi-1,idx+1,in_hi,post,hm);
            
            return node;
        }
    }
}
