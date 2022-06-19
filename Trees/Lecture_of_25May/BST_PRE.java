class Solution {
    int idx=0;
    public TreeNode bstFromPreorder(int[] preorder) {
        return helper(preorder,Integer.MIN_VALUE,Integer.MAX_VALUE);
        
    }
    
    public TreeNode helper(int[] pre,int min,int max){
        if(idx==pre.length)
            return null;
        else if(pre[idx]>min && pre[idx]<max){
            TreeNode node=new TreeNode();
            node.val=pre[idx];
            idx++;
            node.left=helper(pre,min,node.val);
            node.right=helper(pre,node.val,max);
            return node;
        }
        else{
            return null;
        }
    
    }
}