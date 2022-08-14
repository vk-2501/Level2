//Longest Palindromic subsequence string

class Sol{
    public static String lps_backEngine(String s,int si,int ei,int[][] dp){

        if(s.charAt(si)==s.charAt(ei)){
            return s.charAt(ei)+lps_backEngine(s,si+1,ei-1,dp)+s.charAt(ei);
        }
        else if(dp[si][ei-1]>dp[si+1][ei]){
            return lps_backEngine(s,si,ei-1,dp);
        }
        else{
            return lps_backEngine(s, si+1, ei, dp)
        }
    }
}