class Solution {
    int[] parent;
    int[] rank;
    
    public int[] findRedundantConnection(int[][] edges) {
        parent=new int[edges.length+1];
        rank=new int[edges.length+1];
        
        for(int i=0;i<edges.length;i++){
            parent[i]=i;
            rank[i]=0;
        }
        
        for(int[] e:edges){
            int src=find(e[0]);
            int nbr=find(e[1]);
            
            if(src!=nbr){
                union(src,nbr);
            }
            else{
                return e;
            }
            
        }
        
        return null;
    }
    
    public int find(int x){
        if(parent[x]==x)
            return x;
        else{
            int pof=parent[x];
            int lead=find(pof);
            
            parent[x]=lead;
            
            return lead;
        }
    }
    
    public void union(int s1,int s2){
        if(rank[s1]<rank[s2]){
            parent[s1]=s2;
        }
        else if(rank[s1]>rank[s2]){
              parent[s2]=s1;
        }
        else{
            parent[s1]=s2;
            rank[s2]++;
        }
    }
}