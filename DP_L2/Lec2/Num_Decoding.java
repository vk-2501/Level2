import java.util.*;
class Solution {
    public int numDecodings(String s) {
        
        int[] dp=new int[s.length()+1];
        Arrays.fill(dp,-1);
        return memo(s,0,dp);
        
    }
    
    public int memo(String s,int idx,int[] dp){
        if(s.length()==idx){
            return dp[idx]=1;
        }
           if(dp[idx]!=-1) return dp[idx];
        char ch=s.charAt(idx);
        if(ch=='0')
            return dp[idx]=0;
        
     
        
        int a=memo(s,idx+1,dp);
        
        if(idx<s.length()-1){
            char c2=s.charAt(idx+1);
            int num=10*(ch-'0')+(c2-'0');
            if(num<=26){
                a+=memo(s,idx+2,dp);
            }
        }
        return dp[idx]=a;
    } 
}

// -------------------------------------TABULATION-----------------------------------------
public int tabu(String s,int IDX,int[] dp){

    for(int idx=s.length();idx>=0;idx--){
        if(s.length()==idx){
             dp[idx]=1;
             continue;
        }

        char ch=s.charAt(IDX);

        if(ch=='0')
        {
            dp[idx]=0;
            continue;
        } 
        
        int a=0;
         a+=dp[idx+1];//memo(s,idx+1,dp);

        if(idx<s.length()-1){
            char c2=s.charAt(idx+1);
            int num=10*(ch-'0')+(c2-'0');
            if(num<=26){
                a+=dp[idx+2];//memo(s,idx+2,dp);
            }
        }
        dp[idx]=a;
    }
   
    return dp[IDX];
} 