public class Max_Path_sum_Root_to_node {
    public static int maxPathSum(Node root)
    {
        if(root.left!=null && root.right!=null){
            int left=maxPathSum(root.left);
            int right=maxPathSum(root.right);

            int left_dash=Math.max(0,left);
            int right_dash=Math.max(0,right);

            return Math.max(left_dash,right_dash)+root.data;
        }
        else if(root.left!=null){
            int left=maxPathSum(root.left);
            int left_dash=Math.max(0,left);
            return left_dash+root.data;
        }
        else if(root.right!=null){
            int right=maxPathSum(root.right);
            int right_dash=Math.max(0,right);
            return right_dash+root.data;
        }
        else{
            return root.data;
        }
        
    }
}
