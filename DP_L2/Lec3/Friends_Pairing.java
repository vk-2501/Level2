package DP_L2.Lec3;

public class Friends_Pairing {
    
    public long countFriendsPairings(int n) 
    { 
       //code here
       long[] dp=new long[n+1];
       return tab(n,dp);
       
    }
    
    int mod=(int)1e9+7;
    
    public long tab(int n,long[] dp){
        
        if(n==0){
            return dp[n]=1;
        }
        
        if(dp[n]!=0) return dp[n];
        
        long single=tab(n-1,dp);
        long dou=n-2>=0?tab(n-2,dp)*(n-1):0;
        
        return dp[n]=(single+dou%mod)%mod;
        
        
        
        
    }
}
