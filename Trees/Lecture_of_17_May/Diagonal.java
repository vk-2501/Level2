package Trees.Lecture_of_17_May;

public class Diagonal {
    class Tree
{
    static int md=0;
    public void traversal(Node node,int diag,HashMap<Integer,ArrayList<Integer>> map){
        
        if(node==null) return;
        if(diag>md) md=diag;
        
        if(map.containsKey(diag)==false){
            map.put(diag,new ArrayList<>());
           
        }
         map.get(diag).add(node.data);
        traversal(node.left,diag+1,map);
        traversal(node.right,diag,map);
    }
     public ArrayList<Integer> diagonal(Node root)
      {
           //add your code here.
           HashMap<Integer,ArrayList<Integer>> map =new HashMap<>();
           traversal(root,0,map);
           
           ArrayList<Integer> ans=new ArrayList<>();
           for(int d=0;d<=md;d++){
               ArrayList<Integer> temp=map.get(d);
               if(temp==null) continue;
               
               for(int it:temp){
                   ans.add(it);
               }
           }
           return ans;
      }
}
}
