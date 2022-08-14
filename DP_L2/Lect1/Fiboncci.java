package DP_L2.Lect1;

public class Fiboncci {
    public static int fib_memo(int n,int dp[]){
        if(n<=1){
            return dp[n]=n;
        }

        if(dp[n]!=0){
            return dp[n];
        }

        int ans=fib_memo(n-1,dp)+fib_memo(n-2, dp);
        return dp[n]=ans;
    }

    public static int fib_tab(int N,int dp[]){
        for(int n=0;n<dp.length;n++){
            if(n<=1){
                 dp[n]=n;
                 continue;
            }
            int ans=dp[n-1]+dp[n-2];
             dp[n]=ans;
        }
        return dp[N];
        
    }
}
