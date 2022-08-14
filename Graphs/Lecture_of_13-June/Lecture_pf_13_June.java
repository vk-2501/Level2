class Solution {
    public int numIslands(char[][] grid) {
        boolean visited[][]=new boolean[grid.length][grid[0].length];
        
        int c=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1' && visited[i][j]==false){
                    helper(grid,visited,i,j);
                    c++;
                }
            }
        }
        return c;
    }
    
    
    public void helper(char[][] g,boolean[][] visited,int i,int j){
        if(i<0 || j<0 || i>=g.length || j>=g[0].length || g[i][j]=='0' || visited[i][j]==true)
            return;
        
        visited[i][j]=true;
        
        helper(g,visited,i+1,j);
        helper(g,visited,i-1,j);
        helper(g,visited,i,j+1);
        helper(g,visited,i,j-1);
        
        
    }

    //Number of Enclaves
    int len=0;
    boolean flag=true;
    public int numEnclaves(int[][] grid) {
         boolean visited[][]=new boolean[grid.length][grid[0].length];
        int count=0;
                for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1 && visited[i][j]==false){
                    len=0;
                    flag=true;
                     helper(grid,visited,i,j);
                    if(flag==true){
                        count+=len;
                    }
                   
                
                }
            }
        }
        return count;
    }
    
    
       
    public void helper(int[][] g,boolean[][] visited,int i,int j){
        if(i<0 || j<0 || i>=g.length || j>=g[0].length){
            flag=false;
            return;
        }
        else if(g[i][j]==0){
            return;
        }
        else if(visited[i][j]==true){
            return;
        }
            
        
          len++;
        visited[i][j]=true;
      
        
        helper(g,visited,i+1,j);
        helper(g,visited,i-1,j);
        helper(g,visited,i,j+1);
        helper(g,visited,i,j-1);
        
        
    }


    //Rotten Oranges
    class Solution {
    
        class Pair{
            int x;
            int y;
            int t;
            
            Pair(int x,int y,int t){
                this.x=x;
                this.y=y;
                this.t=t;
            }
        }
        public int orangesRotting(int[][] grid) {
            int fresh=0;
            Queue<Pair> q=new ArrayDeque<>();
            for(int x=0;x<grid.length;x++){
                for(int y=0;y<grid[0].length;y++){
                    if(grid[x][y]==2)//rotten ornage
                    {
                        q.add(new Pair(x,y,0));
                    }
                    else if(grid[x][y]==1){
                        fresh++;
                    }
                }
            }
            boolean[][] visited=new boolean[grid.length][grid[0].length];
            int t=0;
            while(q.size()>0){
                //remove mark* work add*
                Pair rem=q.remove();
               
                if(visited[rem.x][rem.y]==true){
                    continue;
                }
                
                
                visited[rem.x][rem.y]=true;
                
                //work
                if(rem.t>t){
                    t=rem.t;
                }
                if(grid[rem.x][rem.y]==1){
                    fresh--;
                }
                //add neighbours
                addNbr(grid,visited,rem.x+1,rem.y,rem.t+1,q);
                addNbr(grid,visited,rem.x-1,rem.y,rem.t+1,q);
                addNbr(grid,visited,rem.x,rem.y+1,rem.t+1,q);
                addNbr(grid,visited,rem.x,rem.y-1,rem.t+1,q);
                
                
                
                
                
            }
            if(fresh==0){
                return t;
            }
            else{
                return -1;
            }
        }
        
        public void addNbr(int[][] grid,boolean[][] visited,int x,int y,int t,Queue<Pair> q){
            if(x<0 || y<0 || x>=grid.length || y>=grid[0].length){
                return;
            }
            else if(grid[x][y]==0){
                return;
            }
            else if(visited[x][y]){
                return;
            }
            
            q.add(new Pair(x,y,t));
        }
    }
}