public class Detect_Cycle_In_Undirected_graph {
     
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean vis[]=new boolean[V];
        
        for(int v=0;v<V;v++){
            if(vis[v]==false){
                boolean isC=cycle(adj,vis,v);
                if(isC) return true;
            }
        }
        return false;
    }
    
    
    public boolean cycle(ArrayList<ArrayList<Integer>> adj,boolean[] vis,int v){
        
        Queue<Integer> q=new ArrayDeque<>();
        q.add(v);
        
        while(q.size()>0){
            int rem=q.remove();
            
            if(vis[rem]==true) return true;
            
            vis[rem]=true;
            
            for(int e:adj.get(rem)){
                if(vis[e]==false)
                q.add(e);
            }
        }
        return false;
    }
}
