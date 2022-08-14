class Solution {
    public int numDecodings(String s) {
        
    }

    public int memo(String s,int idx,int[]dp){
        if(s.length()==idx){
           return dp[idx]=1;
        }

        if(dp[idx]!=-1) return dp[idx];

        char ch=s.charAt(idx);
        if(ch=='0'){
            return dp[idx]=0;
        }
        int mod=(int)(1e9+7);
        int n=s.length();
        int count=0;
        if(ch=='*'){
            count=(count%mod+9*memo(s,idx+1,dp)%mod)%mod;

            if(idx<n-1){
                char c2=s.charAt(idx+1);
                if(c2>='0' && ch<='6'){
                    count=(count%mod+2*memo(s,idx+2,dp)%mod)%mod;
                }
                else if(c2>='7' && c2<='9'){
                    count=(count%mod+1*memo(s,idx+2,dp)%mod)%mod;
                }
                else{
                    count=(count%mod+15*memo(s,idx+2,dp)%mod)%mod;
                }
            }
        }
        else{
            count=(count%mod+1*memo(s,idx+1,dp)%mod)%mod;

            if(idx<n-1){
                char c2=s.charAt(idx+1);
                if(c2!='*'){
                int num=10*(ch-'0')+(c2-'0');
                if(num<=26){
                    count=(count%mod+memo(s,idx+2,dp)%mod)%mod;
                }
                }
                else{
                    if(ch=='1'){
                        count=(count%mod+9*memo(s,idx+2,dp)%mod)%mod;
                    }
                    else if(ch=='2'){
                        count=(count%mod+6*memo(s,idx+2,dp)%mod)%mod;
                    }
                }

            }

        }
        return dp[idx]=count;

    }
}