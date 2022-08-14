//bridge edge in a graph

class Solution
{
    //Function to find if the given edge is a bridge in graph.
    static int time=0;
    static int res=0;
    static int isBridge(int V, ArrayList<ArrayList<Integer>> adj,int c,int d)
    {
        // code here
        time=0;
        res=0;
        boolean vis[]=new boolean[V];
      int[] disc=new int[V];
      int[] low=new int[V];
      

      for(int i=0;i<V;i++){
        if(vis[i]==false){
            dfs(adj,vis,disc,low,i,-1,c,d);
        }
      }
      return res;
    }
    
    public static void dfs(ArrayList<ArrayList<Integer>> adj,boolean vis[],int[] disc,int[] low,int u,int p,int c,int d){
        vis[u]=true;
        disc[u]=low[u]=++time;

        
        for(int e:adj.get(u)){
            if(e==p){
                //parent
                continue;
            }
            else if(vis[e]){
                //already visited
                low[u]=Math.min(low[u],disc[e]);
            }
            else{
                //not visited
                
                dfs(adj,vis,disc,low,e,u,c,d);
                low[u]=Math.min(low[u],low[e]);
                if( low[e]>disc[u]){
                    if(c==e && d==u || c==u && d==e){
                        res=1;
                    }
                }
            }
        }
       

    }
    
    
    
}public class Bridge_Edge {
    
}
