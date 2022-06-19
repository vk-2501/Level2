package Lecture_of_15_june;

class Solution {
    class Pair{
        int i;
        int j;
        int lev;
        Pair(int i,int j,int lev){
            this.i=i;
            this.j=j;
            this.lev=lev;
        }
    }
    public int maxDistance(int[][] grid) {
        boolean[][] visited=new boolean[grid.length][grid[0].length];
        ArrayDeque<Pair> q=new ArrayDeque<>();
        int count=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    q.add(new Pair(i,j,0));
                }
                else{
                    count++;
                }
            }
        }
        
        if(count==0) return -1;
        
        int dist=-1;
        
        while(q.size()>0){
            Pair rem=q.remove();
            
            if(visited[rem.i][rem.j]==true)
                continue;
            visited[rem.i][rem.j]=true;
            
            dist=Math.max(dist,rem.lev);
            
            addN(rem.i-1,rem.j,visited,q,rem.lev+1);
            addN(rem.i+1,rem.j,visited,q,rem.lev+1);
            addN(rem.i,rem.j-1,visited,q,rem.lev+1);
            addN(rem.i,rem.j+1,visited,q,rem.lev+1);
            
        }
        return dist;
    }
    
    void addN(int i,int j,boolean[][] visited, ArrayDeque<Pair> q,int lev){
        if(i<0 || j<0 || i>=visited.length || j>=visited[0].length || visited[i][j]==true)
            return ;
        
        q.add(new Pair(i,j,lev));
    }
}