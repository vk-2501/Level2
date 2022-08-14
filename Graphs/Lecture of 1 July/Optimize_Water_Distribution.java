// https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/graphs/optimize-water-distribution-official/ojquestion

public class Optimize_Water_Distribution {
    
  public static int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
      
    ArrayList<ArrayList<Pair>> graph=new ArrayList<>();
    for(int i=0;i<=n;i++){
        graph.add(new ArrayList<>());
    }
    
    for(int i=0;i<pipes.length;i++){
        int u=pipes[i][0];
        int v=pipes[i][1];
        int wt=pipes[i][2];
        
        graph.get(u).add(new Pair(v,wt));
        graph.get(v).add(new Pair(u,wt));
        
    }
    
    for(int i=1;i<=n;i++){
        graph.get(i).add(new Pair(0,wells[i-1]));
        graph.get(0).add(new Pair(i,wells[i-1]));
    }
    
    PriorityQueue<Pair> pq=new PriorityQueue<>();
    int ans=0;
    pq.add(new Pair(0,0));
    boolean[] vis=new boolean[n+1];
    while(pq.size()>0){
        Pair rem=pq.remove();
        if(vis[rem.vtx]==true) continue;
        
        vis[rem.vtx]=true;
        ans+=rem.wt;
        
        for(Pair p:graph.get(rem.vtx)){
            if(vis[p.vtx]==false){
                pq.add(new Pair(p.vtx,p.wt));
            }
        }
    }
    return ans;
}

public static class Pair implements Comparable<Pair>{
            int vtx;
            int wt;
            Pair(int vtx,int wt){
                this.vtx=vtx;
                this.wt=wt;
            }
            
            @Override
            public int compareTo(Pair o){
                return this.wt-o.wt;
            }
}
}
