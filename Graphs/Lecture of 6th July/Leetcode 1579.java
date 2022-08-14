// Remove Max Number of Edges to Keep Graph Fully Traversable

class Solution {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        int[] parenta=new int[n+1];
        int[] parentb=new int[n+1];
        int[] ranka=new int[n+1];
        int[] rankb=new int[n+1];
        
        Arrays.sort(edges, (a, b) -> Integer.compare(b[0],a[0]));
        for(int i=0;i<parenta.length;i++){
            parenta[i]=i;
            parentb[i]=i;
            ranka[i]=1;
            rankb[i]=1;
        }
        
        int mergeda=1;
        int mergedb=1;
        int remove=0;
        
        for(int[] e:edges){
            if(e[0]==3){
                boolean tempa=union(e[1],e[2],parenta,ranka);
                boolean tempb=union(e[1],e[2],parentb,rankb);
                
                if(tempa==true){
                    mergeda++;
                }
                
                
                if(tempb==true){
                    mergedb++;
                }
                
                if(tempa==false && tempb==false){
                    remove++;
                }
                
            }
            else if(e[0]==1){
                boolean tempa=union(e[1],e[2],parenta,ranka);
                if(tempa==true){
                    mergeda++;
                }
                else{
                    remove++;
                }
            }
            else{
                  boolean tempb=union(e[1],e[2],parentb,rankb);
                if(tempb==true){
                    mergedb++;
                }
                else{
                    remove++;
                }
                
            }
        }
        
        if(mergeda!=n || mergedb!=n){
            return -1;
        }
        
         return remove;
        
    }
    
    public int find(int x,int[] parent){
        if(parent[x]==x){
            return x;
        }
        else{
            parent[x]=find(parent[x],parent);
            return parent[x];
        }
    }
    
    public boolean union(int x,int y,int[] parent,int[] rank){
        int xL=find(x,parent);
        int yL=find(y,parent);
        
        if(xL!=yL){
            if(rank[xL]<rank[yL]){
                parent[xL]=yL;
            }
            else if(rank[xL]>rank[yL]){
                parent[yL]=xL;
            }
            else{
                parent[yL]=xL;
                rank[xL]++;
            }
             return true;
        }
        return false;
       
    }
}