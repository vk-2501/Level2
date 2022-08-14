// 1627. Graph Connectivity With Threshold
//DSU
public class Connectivity {
    
}

class Solution {
    public List<Boolean> areConnected(int n, int threshold, int[][] queries) {
        parent=new int[n+1];
        rank=new int[n+1];
        
        for(int i=0;i<parent.length;i++)
        {
            parent[i]=i;
            rank[i]=0;
        }
        
        
        for(int i=threshold+1;i<=n;i++){
            for(int m=1;i*m<=n;m++){
                union(i,i*m);
            }
        }
        
        List<Boolean> ans=new ArrayList<>();
        
        for(int[] query:queries){
            int n1=query[0];
            int n2=query[1];
            boolean flag=false;
            if(find(n1)==find(n2)) flag=true;
            
           ans.add(flag);
        }
        return ans;
    }
    
    int[] parent;
    int[] rank;
    
    public int find(int x){
        if(parent[x]==x){
            return x;
        }
        else{
            parent[x]=find(parent[x]);
            return parent[x];
        }
    }
    
    public void union(int X,int Y){
        int x=find(X);
        int y=find(Y);
        
        if(x==y) return;
        
        if(rank[x]<rank[y]){
            parent[x]=y;
            rank[y]++;
        }
        else if(rank[x]>rank[y]){
            parent[y]=x;
            rank[x]++;
        }
        else{
            parent[y]=x;
            rank[x]++;
        }
    }
}