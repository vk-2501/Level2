// https://leetcode.com/problems/step-by-step-directions-from-a-binary-tree-node-to-another/

public class Leetcode_2096 {
    class Solution {
        public String getDirections(TreeNode root, int startValue, int destValue) {
            
            ArrayList<TreeNode> l1=nodeToRoot(root,startValue);
            ArrayList<TreeNode> l2=nodeToRoot(root,destValue);
            
            int i=l1.size()-1;
            int j=l2.size()-1;
            
            while(i>=0 && j>=0){
                if(l1.get(i)==l2.get(j)){
                    i--;
                    j--;
                }
                else{
                    break;
                }
            }
            
            i++;
            j++;
            
            StringBuilder sb=new StringBuilder();
            
            for(int ii=0;ii<i;ii++){
                sb.append("U");
            }
            
            for(int jj=j;jj>0;jj--){
                if(l2.get(jj-1)==l2.get(jj).left){
                    sb.append("L");
                }
                else{
                     sb.append("R");
                }
            }
            
            return sb.toString();
            
        }
        public ArrayList<TreeNode> nodeToRoot(TreeNode root,int tar){
            if(root==null){
                return new ArrayList<TreeNode>();
            }
            
           
            if(root.val==tar){
                 ArrayList<TreeNode> al=new ArrayList<>();
                al.add(root);
                return al;
            }
            
            ArrayList<TreeNode> left=nodeToRoot(root.left,tar);
            if(left.size()>0){
                left.add(root);
                return left;
            }
            
            
            ArrayList<TreeNode> right=nodeToRoot(root.right,tar);
            if(right.size()>0){
                right.add(root);
                return right;
            }
            
            return new ArrayList<TreeNode>();
        }
    }
}
