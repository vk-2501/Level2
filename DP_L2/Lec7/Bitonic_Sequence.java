package DP_L2.Lec7;

public class Bitonic_Sequence {
    public int lis_LR(int[] arr,int[] dp){
        int n=arr.length;
        int maxLen=0;
        for(int i=0;i<n;i++){
            dp[i]=1;
            for(int j=i-1;j>=0;j--){
                if(arr[i]>arr[j]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
            maxLen=Math.max(maxLen,dp[i]);
        }
        return maxLen;
    }

    

    //Left to right this is lds
    //right to left this is seeming as lis
    public int lis_RL(int[] arr,int[] dp){
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

    public int bitonic(int[] arr){
        int n=arr.length,maxLen=0;
        int[] LIS=new int[n];
        int[] LDS=new int[n];

        lis_LR(arr, LIS);
        lis_RL(arr, LDS);

        for(int i=0;i<n;i++){
            maxLen=Math.max(maxLen,LIS[i]+LDS[i]-1);
        }
        return maxLen;
    }
}

//maximum sum bitonic subsequence
