// https://leetcode.com/problems/recover-a-tree-from-preorder-traversal/

class Solution {
    int i=0;
    public TreeNode recoverFromPreorder(String traversal) {
        return help(traversal,0);
    }
    
    public TreeNode help(String s,int depth){
       int d=0;//no of dashes
       while(i+d<s.length() && s.charAt(i+d)=='-')
           d++;
        
        if(d!=depth)
            return null;
        
        int nd=0;//no of non-dahses
        while(i+d+nd<s.length() && s.charAt(i+d+nd)!='-'){
            nd++;
        }
        
        int val=Integer.parseInt(s.substring(i+d,i+d+nd));
        i=i+d+nd;
        
        TreeNode node=new TreeNode(val);
        node.left=help(s,depth+1);
        node.right=help(s,depth+1);
        return node;
        
            
        
    }
}