public class Target_Subset_sum {
    public static int subset_sum(int[] nums,int n,int tar,int[][] dp){

        if(n==0 || tar==0){
            return dp[n][tar]=(tar==0)?1:0;
        }

        boolean res=false;
        //call with adding
        if(tar-nums[n-1]){
            res=res || subset_sum(nums, n-1, tar-nums[n-1], dp)==1;
        }

        //call but not adding
        res=res || subset_sum(nums, n-1, tar, dp)==1;
        
        return dp[n][tar]=res?1:0;

    }


    static Boolean isSubsetSum(int N, int arr[], int sum){
        // code here
        int[][] dp=new int[N+1][sum+1];
        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i],-1);
        }
        return helper(arr,N,sum,dp)==1?true:false;
        
    }
    
   static  int helper(int arr[],int N,int sum,int[][] dp){
       for(int tar=0;tar<=sum;tar++){
           for(int n=0;n<=N;n++){
               if(n==0 || tar==0){
            dp[n][tar]=(tar==0?1:0);
            continue;
       }
       boolean res=false;
       if(tar-arr[n-1]>=0)
       res=res || dp[n-1][tar-arr[n-1]]==1?true:false;
       
        res=res || dp[n-1][tar]==1?true:false;
          dp[n][tar]=res?1:0;
           }
           
       }
       
       
       
       return dp[N][sum];
       
      
      
       
   }



}
