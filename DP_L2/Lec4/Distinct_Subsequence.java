class Solution {
    public int numDistinct(String s, String t) {
        int n=s.length();
        int m=t.length();
        
        int[][] dp=new int[s.length()+1][t.length()+1];
        for(int[] d:dp)Arrays.fill(d,-1);
        
        return memo(s,t,n,m,dp);
        
    }
    
    public int memo(String s,String t,int n,int m,int[][] dp){
        if(m==0)
            return dp[n][m]=1;
        
        if(n==0 ){
            return dp[n][m]=0;
        }
        
        if(dp[n][m]!=-1) return dp[n][m];
        
        int a=memo(s,t,n-1,m-1,dp);
        int b=memo(s,t,n-1,m,dp);
        
        if(s.charAt(n-1)==t.charAt(m-1)){
            return dp[n][m]=a+b;
        }
        else
            return dp[n][m]=b;
    }
}


//TABULATION
class Solution {
    public int numDistinct(String s, String t) {
        int n=s.length();
        int m=t.length();
        
        int[][] dp=new int[s.length()+1][t.length()+1];
        for(int[] d:dp)Arrays.fill(d,-1);
        
        return memo(s,t,n,m,dp);
        
    }
    
    public int memo(String s,String t,int N,int M,int[][] dp){
        for(int n=0;n<=N;n++){
            for(int m=0;m<=M;m++){
                 if(m==0){
                   dp[n][m]=1;
                     continue;
                 }
                 if(n==0 ){
                      dp[n][m]=0;
                     continue;
                }

                int a=dp[n-1][m-1];
                int b=dp[n-1][m];

                if(s.charAt(n-1)==t.charAt(m-1)){
                    dp[n][m]=a+b;
                  }
                 else
                    dp[n][m]=b;
            }
        }
     
        return dp[N][M];
    }
}