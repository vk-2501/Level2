// https://practice.geeksforgeeks.org/problems/min-distance-between-two-given-nodes-of-a-binary-tree/1/?page=1&difficulty[]=1&category[]=Tree&sortBy=submissions#

class GfG {
    Node lca(Node node,int tar1,int tar2){
        if(node==null)
        return null;
        
      Node left=lca(node.left,tar1,tar2);
      Node right=lca(node.right,tar1,tar2);
      
      if(node.data==tar1){
          return node;
      }
      
      else if(node.data==tar2){
          return node;
      }
      else if(left!=null && right!=null){
          return node;
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
    
    int findlev(Node root,int a,int lv ){
        if(root==null)
        return -1;
        if(root.data==a){
            return lv;
        }
        int left=findlev(root.left,a,lv+1);
        if(left==-1){
            return findlev(root.right,a,lv+1);
        }
        
        return left;
        
        
    }
    int findDist(Node root, int a, int b) {
        // Your code here
        Node lca=lca(root,a,b);
        
        int l=findlev(lca,a,0);
        int r=findlev(lca,b,0);
        return l+r;
        
        
    }
}