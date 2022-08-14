package DP_L2.Lec7;

public class LIS {
    public int lis_memo(int[] arr,int ei,int[] dp){
        if(dp[ei]!=0) return dp[ei];
        int maxLen=1;
        for(int i=ei-1;i>=0;i--){
            if(arr[i]<arr[ei]){
                int len=lis_memo(arr,i,dp);
                maxLen=Math.max(maxLen,len+1);
            }
        }
        return dp[ei]=maxLen;
    }

    public int lengthOfLIS(int[] nums) {
        int max=0;
        int[] dp=new int[nums.length];
        for(int i=nums.length-1;i>=0;i--){
            max=Math.max(max,lis_memo(nums,i,dp));
        }
        return max;
    }


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
}

//count no of longest increasing subsequences