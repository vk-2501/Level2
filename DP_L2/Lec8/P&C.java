//Target Set
public class Sol{
    public static int permutation(int[] arr,int tar,int[] dp){
        if(tar==0){
            return dp[tar]=1;
        }

        if(dp[tar]!=-1) return dp[tar];
        
        int count=0;
        for(int ele:arr){
            if(tar-ele>=0)
            count+=permutation(arr,tar-ele,dp);
        }
        return dp[tar]=count;
    }

    public static int permutation_tabu(int[] arr,int Tar,int[] dp){
        
        dp[0]=1;

        for(int tar=1;tar<=Tar;tar++){
            int count=0;
            for(int ele:arr){
                if(tar-ele>=0)
                count+=dp[tar-ele];
            }
            dp[tar]=count;
        }
        
       
        return dp[Tar];
    }


    public static int combination(int[] arr,int n,int tar,int[][] dp){
        if(tar==0){
            return dp[n][tar]=1;
        }

        if(dp[n][tar]!=-1) return dp[n][tar];
        
        int count=0;
        for(int i=n;i>0;i--){
            if(tar-arr[i-1]>=0)
            count+=combination(arr,i,tar-arr[i-1],dp);
        }
        return dp[n][tar]=count;
    }
    
    public static int combination_Tabu(int[] arr,int n,int Tar,int[]dp){
        dp[0]=0;
        
        for(int ele:arr){
            for(int tar=ele;tar<=Tar;tar++){
                if(tar-ele>=0){
                    dp[tar]+=dp[tar-ele];
                }
            }
        }
        return dp[Tar];
    }


    
}