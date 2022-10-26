class Solution{
    //permutation infinite patternpackage DP_L2.Lec9;
    
    public class unbounded_knapsack {
        
    }
    
    static int knapSack(int N, int W, int val[], int wt[])
    {
        // code here
        int[] dp=new int[W+1];
        dp[0]=0;
        
        for(int i=1;i<=W;i++){
            for(int j=0;j<wt.length;j++){
              
                if(i-wt[j]>=0){
                    dp[i]=Math.max(dp[i],dp[i-wt[j]]+val[j]);
                }
            }
        }
        
        return dp[W];
    }
}