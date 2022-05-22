public class Right_View {
 import java.util.*;
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
       TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
 
       class Solution {
           public List<Integer> rightSideView(TreeNode root) {
               List<Integer> li=new ArrayList<>();
               if(root==null) return li;
               
               Queue<TreeNode> q=new ArrayDeque<>();
               q.add(root);
               
               while(!q.isEmpty()){
                   int size=q.size();
                   
                   for(int i=0;i<size;i++){
                       TreeNode temp=q.remove();
                       
                       if(i==size-1){
                           li.add(temp.val);
                       }
                       
                       if(temp.left!=null) q.add(temp.left);
                       if(temp.right!=null) q.add(temp.right);
                       
                   }
               }
               
               return li;
           }
       }
   
   
}
