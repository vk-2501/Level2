package DP_L2.Lec10;

//Memoization
public class Matrix_Multiplication {
    static int matrixMultiplication(int N, int arr[])
    {
        // code here
        int[][] dp=new int[arr.length][arr.length];
        return memo(arr,0,N-1,dp);
    }
    
    static int memo(int[] arr,int si,int ei,int[][] dp){
        
        if(ei-si==1)return dp[si][ei]=0;
        
        if(dp[si][ei]!=0) return  dp[si][ei];
        int min=(int)1e9;
        for(int cut=si+1;cut<ei;cut++){
            int left=memo(arr,si,cut,dp);
            int right=memo(arr,cut,ei,dp);
            min=Math.min(min,left+arr[si]*arr[cut]*arr[ei]+right);
            
        }
        return dp[si][ei]=min;
    }
}

//Tabulation
static int tabu(int[] arr,int SI,int EI,int[][] dp){
        int n=arr.length;
    for(int gap=1;gap<n;gap++){
        for(int si=0,ei=gap;ei<n;si++,ei++){
            if(ei-si==1){ 
                dp[si][ei]=0;
                continue;
            }

            int min=(int)1e9;
        for(int cut=si+1;cut<ei;cut++){
        int left=dp[si][cut];
        int right=dp[cut][ei];
        if(left+arr[si]*arr[cut]*arr[ei]+right<min){
            min=left+arr[si]*arr[cut]*arr[ei]+right;
        }
        dp[si][ei]=min;
    }
            
        }
    }
 
    return dp[SI][EI];
   
     
}

//Print the order of string 
static int print_the_string(int[] arr,int SI,int EI,int[][] dp){
    String[][] sdp=new String[n][n];
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
}
        
    }
}
System.out.println(sdp[SI][EI]);
return dp[SI][EI];

 
}

