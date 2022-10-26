class Solution{
     
    static String matrixChainOrder(int p[], int n){
        // code here
        int[][] dp=new int[n][n];
         String[][] sdp=new String[n][n];
          print_the_string(p,0,n-1,dp, sdp);
          return sdp[0][n-1];
    }
    
    static int print_the_string(int[] arr,int SI,int EI,int[][] dp,String[][] sdp){
  
    int n=arr.length;
for(int gap=1;gap<n;gap++){
    for(int si=0,ei=gap;ei<n;si++,ei++){
        if(ei-si==1){ 
            dp[si][ei]=0;
            sdp[si][ei]=(char)(si+'A')+"";
            continue;
        }

        int min=(int)1e9;
        String minstr="";
    for(int cut=si+1;cut<ei;cut++){
    int left=dp[si][cut];
    int right=dp[cut][ei];
    if(left+arr[si]*arr[cut]*arr[ei]+right<min){
        min=left+arr[si]*arr[cut]*arr[ei]+right;
        minstr="("+sdp[si][cut]+sdp[cut][ei]+")";
    }
    dp[si][ei]=min;
    sdp[si][ei]=minstr;
}
        
    }
}
// System.out.println(sdp[SI][EI]);
return dp[SI][EI];

 
}
    
}







