public class Flatten_LL {

    //Good Approach
    class Solution {
        TreeNode prev=null;
        public void flatten(TreeNode root) {
            if(root==null){
                return;
            }
            
            flatten(root.right);
            flatten(root.left);
            
            root.left=null;
            root.right=prev;
            prev=root;
            
        }
    }

//Approach 2
class Solution {
    class Pair{
        TreeNode head;
        TreeNode tail;

        Pair(TreeNode head,TreeNode tail){
            this.head=head;
            this.tail=tail;
        }
        Pair(){
            
        }
    }
    public void flatten(TreeNode root) {
       if(root!=null){
           help(root);
       }

    }

    public Pair help(TreeNode root){
       if(root.left!=null && root.right!=null){
            Pair lp=help(root.left);
            Pair rp=help(root.right);
            Pair mp=new Pair();
            mp.head=root;
            mp.head.left=null;
            mp.head.right=lp.head;
            lp.tail.right=rp.head;
            mp.tail=rp.tail;
            return mp;

       }
       else if(root.left!=null){
            Pair lp=help(root.left);
            Pair mp=new Pair();
            mp.head=root;
            mp.head.left=null;
            mp.head.right=lp.head;
            mp.tail=lp.tail;
            return mp;

            
       }
       else if(root.right!=null){
            Pair rp=help(root.right);
            Pair mp=new Pair();
            mp.head=root;
            mp.head.left=null;
            mp.head.right=rp.head;
            mp.tail=rp.tail;
            return mp;
            
       }
       else{
           Pair mp=new Pair(root,root);
           return mp;
       }
    }
}
}
