//leaf to leaf without consideration of root as leaf node


public class Leaf_To_Leaf2 {
    class Solution
{
    int max=Integer.MIN_VALUE;
    int maxPathSum(Node root)
    { 
        max=Integer.MIN_VALUE;
        helper(root);
        return max;
    } 

    int helper(Node node){

        if(node.left!=null && node.right!=null){
            int left=helper(node.left);
            int right=helper(node.right);
            
            max=Math.max(max,left+right+node.data);
            return Math.max(left,right)+node.data;
        }
        else if(node.left!=null){
            int left=helper(node.left);
            return left+node.data;
        }
        else if(node.right!=null){
            int right=helper(node.right);
            return right+node.data;
        }
        else{
            return node.data;
        }
    }
}
}
