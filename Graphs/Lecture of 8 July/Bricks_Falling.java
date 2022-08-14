// Bricks Falling When Hit
public class Bricks_Falling{
    class Solution {
        int n;
        int m;
        public int[] hitBricks(int[][] grid, int[][] hits) {
            n=grid.length;
            m=grid[0].length;
            
            parent=new int[n*m+1];
            rank=new int[n*m+1];
            size=new int[n*m+1];
            
            for(int i=0;i<parent.length;i++){
                parent[i]=i;
                rank[i]=0;
                size[i]=1;
            }

            //Crash the bricks having 1
         for(int[] hit: hits){
                int x = hit[0];
                int y = hit[1];
                
                if(grid[x][y] == 1){
                    grid[x][y] = 2;
                }
            }
            
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    if(grid[i][j]==1){
                        handleUnion(grid,i,j);
                    }
                }
            }
            
            int res[]=new int[hits.length];
         
            for(int i=hits.length-1;i>=0;i--){
                int x=hits[i][0];
                int y=hits[i][1];
                
                if(grid[x][y]==2){
                    int noBricksIn0=size[find(0)];
                    grid[x][y]=1;
                    handleUnion(grid,x,y);
                    
                    int noBricksafterUnion=size[find(0)];
                    
                    if(noBricksafterUnion>noBricksIn0){
                        res[i]=noBricksafterUnion-noBricksIn0-1;
                    }
                }
            }
            
            
            return res;
            
        }
        
        int[][] dir={{0,-1},{0,1},{1,0},{-1,0}};
        public void handleUnion(int[][] grid,int i,int j){
            int boxno=i*m+j+1;
            
            for(int[] d:dir){
                int ni=i+d[0];
                int nj=j+d[1];
                
                if(ni>=0 && ni<n && nj>=0 && nj<m && grid[ni][nj]==1){
                    int newbox=ni*m+nj+1;
                    union(newbox,boxno);
                }
            }
            
            if(i==0){
                union(0,boxno);
            }
        }
        int[] parent;
        int[] rank;
        int[] size;
        
        public int find(int x){
            if(parent[x]==x){
                return x;
            }
            else{
                parent[x]=find(parent[x]);
                return parent[x];
            }
        }
        
        
        public void union(int X,int Y) {
            int x=find(X);
            int y=find(Y);
            
            if(x==y) return;
            
            if(rank[x]<rank[y]){
                parent[x]=y;
                size[y]+=size[x];
            }
            else if(rank[x]>rank[y]){
                parent[y]=x;
                size[x]+=size[y];
            }
            else{
                parent[y]=x;
                rank[x]++;
                size[x]+=size[y];
            }
        }
       
    }
}
