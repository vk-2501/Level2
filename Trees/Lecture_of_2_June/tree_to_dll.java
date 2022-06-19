//tree to doubly linkedlist
// https://practice.geeksforgeeks.org/problems/binary-tree-to-cdll/1/
public class tree_to_dll {
    
    Node bTreeToClist(Node root)
    {
        //your code here
        return helper(root);
    }
    Node helper(Node root){
        if(root==null)
        return null;

        Node lhead=helper(root.left);
        Node rhead=helper(root.right);

        Node onl=root;
        onl.left=onl.right=onl;

        //This is done in inorder 
        Node s1=concat(lhead,onl);
        Node res=concat(s1,rhead);
        return res;

    }

    //concatination function which merges two doubly linked lists
    Node concat(Node h1,Node h2){
        if(h1==null){
            return h2;
        }
        else if(h2==null){
            return h1;
        }
        
        Node t1=h1.left;
        Node t2=h2.left;

        t1.right=h2;
        h2.left=t1;

        t2.right=h1;
        h1.left=t2;

        return h1;


    }
}
