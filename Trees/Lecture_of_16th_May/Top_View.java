public class Top_View {
    class Solution
{
    //Function to return a list of nodes visible from the top view 
    //from left to right in Binary Tree.
    static class Pair{
        Node node;
        int vertical;
        Pair(Node node,int vertical){
            this.node=node;
            this.vertical=vertical;
        }
    }
    static ArrayList<Integer> topView(Node root)
    {
        // add your code
        ArrayList<Integer> li=new ArrayList<>();
        if(root==null) return li;
        
        int lv=0;
        int rv=0;
        
        Queue<Pair> q=new ArrayDeque<>();
        HashMap<Integer,Node> hm=new HashMap<>();
        
        q.add(new Pair(root,0));
        while(!q.isEmpty()){
            Pair rem=q.remove();
            if(!hm.containsKey(rem.vertical)){
                hm.put(rem.vertical,rem.node);
            }
            
            if(rem.vertical<lv) lv=rem.vertical;
            if(rem.vertical>rv) rv=rem.vertical;
            
            if(rem.node.left!=null) q.add(new Pair(rem.node.left,rem.vertical-1));
            if(rem.node.right!=null) q.add(new Pair(rem.node.right,rem.vertical+1));
            
        }
        
        for(int i=lv;i<=rv;i++){
            Node r=hm.get(i);
            li.add(r.data);
        }
        return li;
    }
}
}
