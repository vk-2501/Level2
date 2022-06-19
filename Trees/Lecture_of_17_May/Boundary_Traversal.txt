class Solution
{
    void leftWall(Node node,ArrayList<Integer> al){
        if(node==null)
        return;
        
       if(node.left!=null || node.right!=null){
           al.add(node.data);
       } 
        
        if(node.left!=null){
            leftWall(node.left,al);
        }
        else if(node.right!=null) {
            leftWall(node.right,al);
        }
    }
    
    void leaves(Node node,ArrayList<Integer> al){
        
        if(node==null)
        return ;
        
        leaves(node.left,al);
        
        if(node.left==null && node.right==null)
        al.add(node.data);
        
        leaves(node.right,al);
    }
    
    void rightWall(Node node,ArrayList<Integer> al){
        if(node==null)
        return;
   
        
        if(node.right!=null){
            rightWall(node.right,al);
        }
        else if(node.left!=null){
            rightWall(node.left,al);
        }
        
             
       if(node.left!=null || node.right!=null){
           al.add(node.data);
       } 
    }
	ArrayList <Integer> boundary(Node node)
	{
	    ArrayList<Integer> ans=new ArrayList<>();
	    ans.add(node.data);
	    
	    leftWall(node.left,ans);
	    
	    leaves(node.left,ans);
	    leaves(node.right,ans);
	    
	    rightWall(node.right,ans);
	    
	    return ans;
	}
}
package Trees.Lecture_of_17_May;

public class Boundary_Traversal {
    
}
