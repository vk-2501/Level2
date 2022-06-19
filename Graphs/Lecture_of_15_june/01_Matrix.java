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
    public int[][] updateMatrix(int[][] mat) {
        
        boolean[][] visited=new boolean[mat.length][mat[0].length];
        int[][] ans=new int[mat.length][mat[0].length];
        ArrayDeque<Pair> q=new ArrayDeque<>();
        
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                if(mat[i][j]==0){
                    q.add(new Pair(i,j,0));
                }
            }
        }
        
        while(q.size()>0){
            Pair rem=q.remove();
            
            if(visited[rem.i][rem.j]==true){
                continue;
            }
            visited[rem.i][rem.j]=true;
                
            ans[rem.i][rem.j]=rem.lev;
            
            addN(rem.i+1,rem.j,mat,visited,q,rem.lev+1);
            addN(rem.i-1,rem.j,mat,visited,q,rem.lev+1);
            addN(rem.i,rem.j+1,mat,visited,q,rem.lev+1);
            addN(rem.i,rem.j-1,mat,visited,q,rem.lev+1);
        }
        return ans;
    }
    
    void addN(int i,int j,int[][] mat,boolean[][] visited,ArrayDeque<Pair> q,int lev){
        if(i<0 || j<0 || i>=mat.length ||j>=mat[0].length || visited[i][j]==true){
            return;
        }
        
        q.add(new Pair(i,j,lev));
    }
}
