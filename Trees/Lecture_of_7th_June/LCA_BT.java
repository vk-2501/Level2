//LCA OF BINARY TREE
// https://practice.geeksforgeeks.org/problems/lowest-common-ancestor-in-a-binary-tree/1

public class LCA_BT {
    boolean f1=false;
    boolean f2=false;

    Node lca(Node root, int n1,int n2)
	{
        f1=false;
        f2=false;
        
		Node lca=helper(root,n1,n2);

        if(f1 && f2)
        return lca;
        else
        return null;
	
	}

    public Node helper(Node root,int n1,int n2){
        if(root==null)
        return null;

        Node left=helper(root.left,n1,n2);
        Node right=helper(root.right,n1,n2);

        if(root.data==n1){
            f1=true;
            return root; 
        }
        else if(root.data==n2){
            f2=true;
            return root;
        }
        else if(left!=null && right!=null){
            return root;
        }
        else if(left!=null){
            return left;
        }
        else if(right!=null){
            return right;
        }
        else{
            return null;
        }
        
    }
}

