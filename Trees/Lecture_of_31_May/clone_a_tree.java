public class clone_a_tree {
    class Solution{
        public Tree cloneTree(Tree tree){
           // add code here.
           leftClone(tree);
           setRandom(tree);
           Tree dup=Recover(tree);
           return dup;
         }
         
         public void leftClone(Tree node){
             if(node==null)
             return;
             
             leftClone(node.left);
             leftClone(node.right);
             
             Tree lc=new Tree(node.data);
             lc.left=node.left;
             node.left=lc;
             lc.right=null;
         }
         
         public void setRandom(Tree orig){
             
             if(orig==null) return;
             setRandom(orig.left.left);
             setRandom(orig.right);
             
             if(orig.random!=null){
                 orig.left.random=orig.random.left;
             }
             
         }
         
         public Tree Recover(Tree node){
             if(node==null)
             return null;
             
             Tree left=Recover(node.left.left);
             Tree right=Recover(node.right);
             
             Tree dup=node.left;
             node.left=node.left.left;
             dup.left=left;
             dup.right=right;
             
             return dup;
         }
    }
}
