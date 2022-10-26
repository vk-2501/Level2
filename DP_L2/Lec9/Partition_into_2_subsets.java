package DP_L2.Lec9;

public class Partition_into_2_subsets {
    public boolean canPartition(int[] nums) {
        
        int sum=0;
        for(int v:nums) sum+=v;
        if(sum%2!=0) return false;
        
        int tar=sum/2;
        int[][] dp=new int[nums.length+1][tar+1];
        for(int[] d:dp)Arrays.fill(d,-1);
        return helper(nums,nums.length,tar,dp)==1?true:false;
        
    }
    
    public  static  int helper(int arr[],int N,int sum,int[][] dp){
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
