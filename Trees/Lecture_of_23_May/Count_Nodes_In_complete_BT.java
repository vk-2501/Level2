//count nodes in a complete binary tree
public class Sol{
    public int count(TreeNode root){
        if(root==null)
        return 0;

        TreeNode node=root.left;
        int lh=0;
        while(node!=null){
            node=node.left;
            lh++;
        }

        node=root.right;
        int rh=0;
        while(node!=null){
            node=node.right;
            rh++;
        } 

        if(lh==rh){
            int ht=lh+1;
            return (1<<ht)-1;
        }
        else{
            return 1+count(root.left)+count(root.right);
        }
    }
}