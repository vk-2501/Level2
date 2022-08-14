class Solution{

    public int[] articulationPoints(int V, ArrayList<ArrayList<Integer>> adj)
    {
      boolean vis[]=new boolean[V];
      int[] disc=new int[V];
      int[] low=new int[V];
      boolean[] ap=new boolean[V];

      for(int i=0;i<V;i++){
        if(vis[i]==false){
            dfs(adj,vis,disc,low,i,-1,ap);
        }
      }

      int count=0;
      for(int i=0;i<ap.length;i++){
        if(ap[i]==true) count++;
      }
      
      if(count==0){
          return new int[]{-1};
      }

      int[] res=new int[count];
      int d=0;
      for(int i=0;i<ap.length;i++){
        if(ap[i]==true){
        res[d++]=i;
        }
      }
      
      
      return res;
    }

    int time=0;
    public void dfs(ArrayList<ArrayList<Integer>> adj,boolean vis[],int[] disc,int[] low,int u,int p,boolean[] ap){
        vis[u]=true;
        disc[u]=low[u]=++time;

        int c=0;
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
                c++;
                dfs(adj,vis,disc,low,e,u,ap);
                low[u]=Math.min(low[u],low[e]);
                if(p!=-1 && low[e]>=disc[u]){
                    ap[u]=true;
                }
            }
        }
        if(p==-1 && c>1){
            ap[u]=true;
        }

    }
}

