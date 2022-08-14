public class Edit_Distance {
    class Solution {
        public int minDistance(String word1, String word2) {
            int n=word1.length();
            int m=word2.length();
            
            int[][] dp=new int[n+1][m+1];
            for(int[] d:dp)Arrays.fill(d,-1);
            
            return memo(word1,word2,n,m,dp);
            
        }
        
        public int memo(String s1,String s2,int n,int m,int[][] dp){
            
            if(n==0 || m==0){
                return dp[n][m]=n!=0?n:m;
            }
            
            if(dp[n][m]!=-1)return dp[n][m];
            
            int insert=memo(s1,s2,n,m-1,dp);
            int del=memo(s1,s2,n-1,m,dp);
            int rep=memo(s1,s2,n-1,m-1,dp);
            
            if(s1.charAt(n-1)==s2.charAt(m-1)){
                return dp[n][m]=rep;
            }
            else{
                return dp[n][m]=Math.min(Math.min(insert,del),rep)+1;
            }
            
            
        }
    }
}

//TABULATION
public int memo(String s1,String s2,int N,int M,int[][] dp){
         
    for(int n=0;n<=N;n++){
        for(int m=0;m<=M;m++){
             if(n==0 || m==0){
         dp[n][m]=n!=0?n:m; continue;
   }
            
   int insert=dp[n][m-1];//memo(s1,s2,n,m-1,dp);
   int del=dp[n-1][m];//memo(s1,s2,n-1,m,dp);
   int rep=dp[n-1][m-1];//memo(s1,s2,n-1,m-1,dp);
   
   if(s1.charAt(n-1)==s2.charAt(m-1)){
        dp[n][m]=rep;
   }
   else{
        dp[n][m]=Math.min(Math.min(insert,del),rep)+1;
   }    
        }
    }
   
  return dp[N][M];
}

//FOLLOW-UP
//IF cost of insert,delete and replace operation is given

public int memo(String s1,String s2,int N,int M,int[][] dp,int[] cost){
         
    for(int n=0;n<=N;n++){
        for(int m=0;m<=M;m++){
             if(n==0 || m==0){
         dp[n][m]=n==0?m*cost[0]:n*cost[1]; continue;
   }
            
   int insert=dp[n][m-1];//memo(s1,s2,n,m-1,dp);
   int del=dp[n-1][m];//memo(s1,s2,n-1,m,dp);
   int rep=dp[n-1][m-1];//memo(s1,s2,n-1,m-1,dp);
   
   if(s1.charAt(n-1)==s2.charAt(m-1)){
        dp[n][m]=rep;
   }
   else{
        dp[n][m]=Math.min(Math.min(insert+cost[0],del+cost[1]),rep+cost[2])+1;
   }    
        }
    }
   
  return dp[N][M];

   

   
   
}


           