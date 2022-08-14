package DP_L2.Lec7;

public class LDS {
    public int LDS_LR(int[] arr,int[] dp){
        int n=arr.length;
        int maxLen=0;
        for(int i=0;i<n;i++){
            dp[i]=1;
            for(int j=i-1;j>=0;j--){
                if(arr[i]<arr[j]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
            maxLen=Math.max(maxLen,dp[i]);
        }
        return maxLen;
    }

    public int LDS_RL(int[] arr,int[] dp){
        int n=arr.length;
        int maxLen=0;
        for(int i=n-1;i>=0;i--){
            dp[i]=1;
            for(int j=i+1;j<n;j++){
                if(arr[i]>arr[j]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
            maxLen=Math.max(maxLen,dp[i]);
        }
        return maxLen;
    }
}
