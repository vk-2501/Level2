public class TargetSet{
    public static int coinchangePer_memo(int[] arr,int tar,int[] dp){
        if(tar==0){
            return dp[tar]=1;
        }

        if(dp[tar]!=-1)
        return dp[tar];


        int count=0;
        for(int ele:arr){
            if(tar-ele>=0){
                count+=coinchangePer_memo(arr,tar-ele,dp);
            }
        }
        return dp[tar]=count;
    }

    public static int coinchangePer_Tabu(int[] arr,int TAR,int[] dp){
        dp[0]=1;
        int count=0;
        for(int tar=0;tar<=TAR;tar++){
            for(int ele:arr){
                if(tar-ele>=0){
                    dp[tar]+=dp[tar-ele];
                }
            }
        }
        return dp[TAR];
    }

    public static int coinchangeCombination_1d(int[] arr,int TAR,int[] dp){
        dp[0]=1;
        int count=0;
        for(int ele:arr){
        for(int tar=ele;tar<=TAR;tar++){
                if(tar-ele>=0){
                    dp[tar]+=dp[tar-ele];
                }
            }
        }
        return dp[TAR];
    }

    public static coinChangeCombination_2d(int[] arr,int tar,int idx,int[][] dp){
        if(tar==0){
            return dp[idx][tar]=1;
        }

        int coins=0;
        for(int i=idx;i>=0;i--){
            if(tar-arr[i]>=0){
                coins+=coinChangeCombination(arr,tat,i,dp);
            }
        }
        return dp[idx][tar]=coins;

    }
}