package DP_L2.Lect1;

public class Unique_Paths2 {
    class Solution {
        public  int helper(int sr,int sc,int er,int ec,int[][] dir,int[][] visited,int[][] dp){
         if(sr==er && sc==ec){
             dp[sr][sc]= 1;
         }
            
            if(dp[sr][sc]!=0)
                return dp[sr][sc];
         
         
         int count=0;
         for(int d=0;d<dir.length;d++){
            int r=sr+ dir[d][0];
            int c=sc+ dir[d][1];
 
            if(r>=0 && c>=0 && r<=er && c<=ec && visited[r][c]==0){
                 count+=helper(r, c, er, ec, dir,visited,dp);
               
            }
             
         }
 
                   
         return dp[sr][sc]=count;
     }
     
     
     public int uniquePathsWithObstacles(int[][] obstacleGrid) {
            int m=obstacleGrid.length; 
         int n=obstacleGrid[0].length;
         if(obstacleGrid[0][0]==1 || obstacleGrid[m-1][n-1]==1 )
             return 0;
      
         int dir[][]={{0,1},{1,0}};
         int dp[][]=new int[m][n];
         return helper(0,0,m-1,n-1,dir,obstacleGrid,dp);
     }
 }
}

// -----------------------------------TABULATION------------------------------------
class Solution {
    public  int helper(int SR,int SC,int ER,int EC,int[][] dir,int[][] visited,int[][] dp){
        
        for(int sr=ER;sr>=0;sr--){
            for(int sc=EC;sc>=0;sc--){
                 if(sr==ER && sc==EC){
                      dp[sr][sc]= 1;
                     continue;
            }
                
                
      int count=0;
     for(int d=0;d<dir.length;d++){
        int r=sr+ dir[d][0];
        int c=sc+ dir[d][1];

        if(r>=0 && c>=0 && r<=ER && c<=EC && visited[r][c]==0){
             count+=dp[r][c];
           
        }
         
     }
                
        dp[sr][sc]=count;
            }
            
        }

       return dp[SR][SC];
       
 }
 
 
 public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m=obstacleGrid.length; 
     int n=obstacleGrid[0].length;
     if(obstacleGrid[0][0]==1 || obstacleGrid[m-1][n-1]==1 )
         return 0;
  
     int dir[][]={{0,1},{1,0}};
     int dp[][]=new int[m][n];
     return helper(0,0,m-1,n-1,dir,obstacleGrid,dp);
 }
}
