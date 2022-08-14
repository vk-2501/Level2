//MEMO
class Solution {
    public int longestPalindromeSubseq(String s) {
        int[][] dp=new int[s.length()][s.length()];
        return memo(s,0,s.length()-1,dp);
    }
    
    public int memo(String s,int i,int j,int[][] dp){
        if(i>=j){
            return dp[i][j]=(i==j?1:0);
        }
        
        if(dp[i][j]!=0) return dp[i][j];
        
        if(s.charAt(i)==s.charAt(j)){
            return dp[i][j]=memo(s,i+1,j-1,dp)+2;
        }
        else
            return dp[i][j]=Math.max(memo(s,i+1,j,dp),memo(s,i,j-1,dp));
        
    }
}

//TABULATION
class Solution {
    public int longestPalindromeSubseq(String s) {
        int[][] dp=new int[s.length()][s.length()];
        return memo(s,0,s.length()-1,dp);
    }
    
    public int memo(String s,int I,int J,int[][] dp){
        int n=s.length();
        for(int gap=0;gap<n;gap++){
            for(int i=0,j=gap;j<n;i++,j++){
                if(i>=j){
                     dp[i][j]=(i==j?1:0);
                    continue;
                }

                
                if(s.charAt(i)==s.charAt(j)){
                     dp[i][j]=dp[i+1][j-1]+2;
                }
                else
                     dp[i][j]=Math.max(dp[i+1][j],dp[i][j-1]);
                
            }
        }
        return dp[I][J];
    }
}
