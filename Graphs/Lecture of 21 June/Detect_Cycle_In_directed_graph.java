public class Detect_Cycle_In_Undirected_graph {
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
        int[] vis=new int[V];
        int[] dfsVis=new int[V];
        
        for(int v=0;v<V;v++){
            if(vis[v]==0){
               if( isCycle(adj,v,vis,dfsVis)==true){
                   return true;
               }
                
            }
        }
        return false;
    }
    
    public boolean isCycle(ArrayList<ArrayList<Integer>> adj,int v,  int[] vis,  int[] dfsVis){
        vis[v]=1;
        dfsVis[v]=1;
        
        for(int it:adj.get(v)){
            if(vis[it]==0){
               boolean is= isCycle(adj,it,vis,dfsVis);
               if(is) return true;
            }
            else if(dfsVis[it]==1){
                return true;
            }
        }
        
        dfsVis[v]=0;
        return false;
    }
}
