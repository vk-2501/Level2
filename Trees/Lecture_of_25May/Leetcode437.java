
class Solution {
    int c=0;
    public int pathSum(TreeNode root, int targetSum) {
        c=0;
        if(root==null)
            return 0;
        HashMap<Integer,Integer> hm=new HashMap<>();
        hm.put(0,1);
        help(root,root.val,targetSum,hm);
        return c;
        
        
    }
    
    public void help(TreeNode root,int psum,int tar, HashMap<Integer,Integer> hm){
        if(hm.containsKey(psum-tar)==true){
            c+=hm.get(psum-tar);
        }
        
        if(hm.containsKey(psum)==false){
            hm.put(psum,1);
        }
        else{
            hm.put(psum,hm.get(psum)+1);
        }
        
        if(root.left!=null){
            help(root.left,psum+root.left.val,tar,hm);
        }
        
        if(root.right!=null){
            help(root.right,psum+root.right.val,tar,hm);
        }
        

        
        if(hm.get(psum)==1){
            hm.remove(psum);
        }
        else{
            hm.put(psum,hm.get(psum)-1);
        }
    }
}