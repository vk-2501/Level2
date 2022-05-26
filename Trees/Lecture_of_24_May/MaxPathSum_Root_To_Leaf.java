public class MaxPathSum_Root_To_Leaf {
    //using static 
    public static int maxPathSum(Node root)
    {
         max=Integer.MIN_VALUE;
        help(root,0);
        return max;
        
    }

    public static void help(Node root,int sum){
        if(root==null)
        return;
        if(root.left==null && root.right==null){
            sum+=root.data;
            if(sum>max){
                max=sum;
            }
        }
        help(root.left,sum+root.data);
        help(root.right,sum+root.data);
    }

    //without static
    public static int maxPathSum(Node root)
    {
        if(root.left!=null && root.right!=null){
            int left=maxPathSum(root.left);
            int right=maxPathSum(root.right);
            return Math.max(left,right)+root.data;
        }
        else if(root.left!=null){
            int left=maxPathSum(root.left);
            return left+root.data;
        }
        else if(root.right!=null){
            int right=maxPathSum(root.right);
            return right+root.data;
        }
        else{
            return root.data;
        }
        
    }
}
