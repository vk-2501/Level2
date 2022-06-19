public class Image_Multiplication {
    class Solution {
        long ans=0L;
        long mod=1000000007;
       public long imgMultiply(Node root)
       {
           ans=(root.data*root.data)%mod;
           
           help(root.left,root.right);
           return ans;
       }
       
       public void help(Node n1,Node n2){
           if(n1==null || n2==null)
           return;
           
           ans=(ans+n1.data*n2.data)%mod;
           help(n1.left,n2.right);
           help(n1.right,n2.left);
       }
   }
}
