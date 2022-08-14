package DP_L2.Lect1;

public class Maze_Path {
    
    public int memo(int[][] dp,int[][] dir,int sr,int sc,int er,int ec){
        if(sr==er && sc==ec){
            return dp[sr][sc]=1;
        }
        
        if(dp[sr][sc]!=0)return dp[sr][sc];
        int count=0;
        for(int d[]:dir){
            int x=sr+d[0];
            int y=sc+d[1];
            if(x>=0 && y>=0 && x<=er && y<=ec){
                count+=memo(dp,dir,x,y,er,ec);
            }
        }
        return dp[sr][sc]=count;
    }



    public int tabu(int[][] dp,int[][] dir,int SR,int SC,int ER,int EC){
        
        for(int sr=ER;sr>=0;sr--){
            for(int sc=EC;sc>=0;sc--){
                if(sr==ER && sc==EC){
               dp[sr][sc]=1;
                    continue;
       }
               int count=0;
       for(int d[]:dir){
           int x=sr+d[0];
           int y=sc+d[1];
           if(x>=0 && y>=0 && x<=ER && y<=EC){
               count+=dp[x][y];
           }
                
            }
                
            dp[sr][sc]=count;    
        }   
       
    
      
      
       }
       return dp[SR][SC];
   }
}
