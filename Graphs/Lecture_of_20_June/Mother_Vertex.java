import java.util.*;
public class Mother_Vertex{
    public int findMotherVertex(int V, ArrayList<ArrayList<Integer>>adj)
    {
        // Code here
        int mv=-1;
        boolean[] vis=new boolean[V];
        for(int v=0;v<V;v++){
            if(vis[v]==false){
                dfs(adj,vis,v);
                mv=v;
            }
        }
        
        Arrays.fill(vis,false);
        
        dfs(adj,vis,mv);
        
        for(int i=0;i<V;i++){
            if(vis[i]==false)
            return -1;
        }
        
        return mv;
        
        
    }
    
    public void dfs(ArrayList<ArrayList<Integer>>adj,boolean[] vis,int v){
        vis[v]=true;
        for(int e:adj.get(v)){
            if(vis[e]==false){
                dfs(adj,vis,e);
            }
        }
    }
}