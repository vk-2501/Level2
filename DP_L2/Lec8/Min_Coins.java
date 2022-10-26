public class Min_Coins {
    
    public static int min_coins(int[] coins,int amount){
        int[] dp=new int[amount+1];
        dp[0]=0;
        Arrays.fill(dp,(int)1e9);

        for(int tar=1;tar<=amount;tar++){
            for(int ele:coins){
                if(tar-ele>=0){
                    dp[tar]=Math.min(dp[tar-ele]+1,dp[tar]);
                }
            }
        }
        return dp[amount]==(int)1e9?-1:dp[amount];
    }
}
