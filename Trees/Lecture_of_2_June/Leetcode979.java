//Distribute coins[https://leetcode.com/problems/distribute-coins-in-binary-tree/]

public class Leetcode979 {
   
class Solution {
    public class Pair{
        int nodes;
        int coins;
    }
    int moves=0;
    public int distributeCoins(TreeNode root) {
        moves=0;
        if(root==null){
            return 0;
        }
        
        help(root);
        return moves;
    }
    
    public Pair help(TreeNode node){
        if(node==null){
            return new Pair();
        }
        Pair lp=help(node.left);
        Pair rp=help(node.right);
        Pair mp=new Pair();
        mp.nodes=lp.nodes+rp.nodes+1;
        mp.coins=lp.coins+rp.coins+node.val;
        moves+=Math.abs(mp.coins-mp.nodes);
        return mp;
    }
}
}
