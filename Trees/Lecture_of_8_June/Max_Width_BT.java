public class Max_Width_BT {
    class Solution {
        class Pair{
            long min;
            long max;
        }
        
        long maxW=0;
        public int widthOfBinaryTree(TreeNode root) {
            if(root==null) return 0;
            HashMap<Integer,Pair> hm=new HashMap<>();
            helper(root,1,1,hm);
            return (int)maxW;
        }
        
        public void helper(TreeNode root,int lev,long idx, HashMap<Integer,Pair> hm){
            if(root==null) return;
            
            helper(root.left,lev+1,2*idx,hm);
            helper(root.right,lev+1,2*idx+1,hm);
            Pair np=null;
            if(hm.containsKey(lev)){
                  np=hm.get(lev);
                np.min=Math.min(np.min,idx);
                np.max=Math.max(np.max,idx);
            }
            else{
                 np=new Pair();
                np.min=idx;
                np.max=idx;
                
                hm.put(lev,np);
            }
            
            long width=np.max-np.min+1;
            if(width>maxW){
                maxW=width;
            }
            
        }
    }
}
