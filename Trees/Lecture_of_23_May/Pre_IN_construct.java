//construct tree from preorder and inoreder
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            int val=inorder[i];
            hm.put(val,i);
        }
        
        TreeNode root=construct(0,preorder.length-1,0,inorder.length-1,preorder,hm);
        return root;
    }
    
    TreeNode construct(int pre_lo,int pre_hi,int in_lo,int in_hi,int[] pre, HashMap<Integer,Integer> hm){
        //base case
        if(pre_lo>pre_hi || in_lo>in_hi){
            return null;
        }
        
        TreeNode node=new TreeNode();
        node.val=pre[pre_lo];
        
        int idx=hm.get(pre[pre_lo]);
        int lhs=idx-in_lo;   
        
        node.left=construct(pre_lo+1,pre_lo+lhs,in_lo,idx-1,pre,hm);
        node.right=construct(pre_lo+lhs+1,pre_hi,idx+1,in_hi,pre,hm);
        
        return node;
    }
}

// ----------------------------------------------------------------------------------
//USING WITHOUT EXTRA SPACE
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
       
        
        TreeNode root=construct(0,preorder.length-1,0,inorder.length-1,preorder,inorder);
        return root;
    }
    
    TreeNode construct(int pre_lo,int pre_hi,int in_lo,int in_hi,int[] pre,int[] in){
        //base case
        if(pre_lo>pre_hi || in_lo>in_hi){
            return null;
        }
        
        TreeNode node=new TreeNode();
        node.val=pre[pre_lo];
        
        int fval=pre[pre_lo];
        int idx=0;
        while(idx<in.length){
            if(in[idx]==fval){
                break;
            }
            idx++
        }
        int lhs=idx-in_lo;   
        
        node.left=construct(pre_lo+1,pre_lo+lhs,in_lo,idx-1,pre,in);
        node.right=construct(pre_lo+lhs+1,pre_hi,idx+1,in_hi,pre,in);
        
        return node;
    }
}
