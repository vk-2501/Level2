package DP_L2.Lec3;


// TABULATION
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp=new int[text1.length()+1][text2.length()+1];
        for(int[] d:dp){
            Arrays.fill(d,-1);
        }
        return memo(text1,text2,dp,text1.length(),text2.length());
    }
    
    public int memo(String s1,String s2,int[][]dp,int N,int M){
        for(int n=0;n<=N;n++){
            for(int m=0;m<=M;m++){
                 if(n==0 || m==0){
                  dp[n][m]=0;
                     continue;
                  }
               
                if(s1.charAt(n-1)==s2.charAt(m-1)){
             dp[n][m]=dp[n-1][m-1]+1;
        }
                 else{
             dp[n][m]=Math.max(dp[n-1][m],dp[n][m-1]);
        }
                
            }
        }
       
       
        return dp[N][M];
       
    }
}
