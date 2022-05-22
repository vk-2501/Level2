public class Left_View {
    class Tree
{
    //Function to return list containing elements of left view of binary tree.
    ArrayList<Integer> leftView(Node root)
    {
      // Your code here
        ArrayList<Integer> res=new   ArrayList<>();
      Queue<Node> q=new LinkedList<>();
      q.add(root);
      while(q.size()>0){
          int size=q.size();
         for(int i=0;i<size;i++){
             Node peek=q.remove();
             if(i==0){
                 res.add(peek.data);
             }
             
             if(peek.left!=null)
             q.add(peek.left);
             
             if(peek.right!=null)
             q.add(peek.right);
         }
          
          
      }
      return res;
    }
}
}
