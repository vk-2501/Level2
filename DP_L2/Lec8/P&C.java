//Target Set
public class Sol{
    public static int permutation(int[] arr,int tar,int[] dp){
        if(tar==0){
            return dp[tar]=1;
        }

        if(dp[tar]!=-1) return dp[tar];
        
        int count=0;
        for(int ele:tar){
            if(tar-ele>=0)
            count+=permutation(arr,tar-ele,dp);
        }
        return dp[tar]=count;
    }

    public static int combinationpackage DP_L2.Lec8;
    
    public class P&C {
        
    }
    (int[] arr,int tar,int[] dp){
        if(tar==0){
            return dp[tar]=1;
        }

        if(dp[tar]!=-1) return dp[tar];
        
        int count=0;
        for(int ele:tar){
            if(tar-ele>=0)
            count+=permutation(arr,tar-ele,dp);
        }
        return dp[tar]=count;
    }
}