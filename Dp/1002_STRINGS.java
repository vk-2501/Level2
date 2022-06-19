//leetcode 91
//DECODE WAYS

class 1002_STRINGS{
    //RECURSIVE
    public int numDecodings(String s,int idx){
        
        if(idx==s.length())
        return 1;

        char ch1=s.charAt(i);
        if(ch1=='0')
        return 0;

        int count=0;
        count+=numDecodings(s,idx+1);

        if(idx<s.length()-1){
            char ch2=s.charAt(idx+1);
            int val=(ch1-'0')*10+(ch2-'0');
            if(val<=26) count+=numDecodings(s,idx+2);
        }

        return count;
    }

    //MEMO
    public int numDecodings(String s,int idx,int[] dp){
    
        if(idx==s.length())
        return dp[idx]=1;
        
        if(dp[idx]!=-1)return dp[idx];
            
        char ch1=s.charAt(idx);
        if(ch1=='0')
        return 0;

        int count=0;
        count+=numDecodings(s,idx+1,dp);

        if(idx<s.length()-1){
            char ch2=s.charAt(idx+1);
            int val=(ch1-'0')*10+(ch2-'0');
            if(val<=26) count+=numDecodings(s,idx+2,dp);
        }

        return dp[idx]=count;
    }
    
    public int numDecodings(String s){
        int dp[]=new int[s.length()+1];
       Arrays.fill(dp,-1);
        return numDecodings(s,0,dp);
    }

    //TABULATION
    public int numDecodings_TABU(String s,int IDX,int[] dp){
        
        for(int idx=s.length();idx>=0;idx--){
            if(idx==s.length()){
             dp[idx]=1;
            continue;
           }
            
          
                
            char ch1=s.charAt(idx);
            if(ch1=='0'){
            dp[idx]= 0;
            continue;}
    
            int count=0;
            count+=dp[idx+1];//numDecodings(s,idx+1,dp);
    
            if(idx<s.length()-1){
                char ch2=s.charAt(idx+1);
                int val=(ch1-'0')*10+(ch2-'0');
                if(val<=26) count+=dp[idx+2];//numDecodings(s,idx+2,dp);
            }
            dp[idx]=count;
        }
      return dp[IDX];
         
    }


    ///--------------------------------------------------------------------------------------
    // Leetcode 639
     //MEMO
     class Solution {
        int mod=(int)1e9+7;
        public long numDecodings_memo(String s,int idx,long[] dp){
            //base case
            if(idx==s.length()){
                return dp[idx]=1;
            }
            
            if(dp[idx]!=-1)
                return dp[idx];
            
            //get the first character and check if it is not 0
            char ch1=s.charAt(idx);
            if(ch1=='0')
                return 0;
            
            //Take a count variable
            long count=0;
            //There can be 4 cases
            //  *,n   **,*n,n*,nn

            //if first character is a *
            //Then it can have 2 calls --> single(it can have 9 combinations as (1-9) any digit can come)
            //                         --> double--> Leads to 3 cases if again it is * forming  **(double star)then there are 15 coombinations
             //                                      if next char lies between 0 and 6 then *0 -> 10 & 20 , *1-> 11,21 so 2 calls for each digit from 0 to 6
           //                                        if next char is greater than 7 then only single call
             if(s.charAt(idx)=='*'){
                count=(count%mod + 9*numDecodings_memo(s,idx+1,dp) % mod )%mod;
                if(idx<s.length()-1){
                    char ch2=s.charAt(idx+1);
                    if(ch2=='*'){
                          count=(count%mod + 15*dp[idx+2] % mod )%mod;
                    }
                   else  if(ch2>='0' && ch2<='6'){
                         count=(count%mod + 2*dp[idx+2] % mod )%mod;
                    }
                    else if(ch2>'6'){
                        count=(count%mod + dp[idx+2] % mod )%mod;
                    }
                }
                
            }
            else{
                count=(count%mod + numDecodings_memo(s,idx+1,dp) % mod )%mod;
                if(idx<s.length()-1){
                    if(s.charAt(idx+1)!='*'){
                    char ch2=s.charAt(idx+1);
                    int num=(ch1-'0')*10+(ch2-'0');
                    if(num<=26) 
                        count=(count%mod + dp[idx+2] % mod )%mod;
                    }
                    else {
                        if(s.charAt(idx)=='1')
                             count=(count%mod + 9*dp[idx+2] % mod )%mod;
                    
                        else if(s.charAt(idx)=='2')
                             count=(count%mod + 6*dp[idx+2] % mod )%mod;
                        
                    }
                }
                
                
                
                
            }
            return dp[idx]=count;
        }
        
        public int numDecodings(String s) {
            long[] dp=new long[s.length()+1];
            Arrays.fill(dp,-1);
            long ans= numDecodings_memo(s,0,dp);
            return (int)(ans);
        }
    }


    public long numDecodings_tabu(String s,int IDX,long[] dp){

        for(int idx=s.length();idx>=0;idx--){
            if(idx==s.length()){
                 dp[idx]=1;
                 continue;
            }
            char ch1=s.charAt(idx);
            if(ch1=='0'){
                dp[idx]=0;
                continue;
            }

            long count=0;
        //There can be 4 cases
        //  *,n   **,*n,n*,nn
        if(s.charAt(idx)=='*'){
            count=(count%mod + 9*dp[idx+1] % mod )%mod;
            if(idx<s.length()-1){
                char ch2=s.charAt(idx+1);
                if(ch2=='*'){
                      count=(count%mod + 15*dp[idx+2] % mod )%mod;
                }
               else  if(ch2>='0' && ch2<='6'){
                     count=(count%mod + 2*dp[idx+2] % mod )%mod;
                }
                else if(ch2>'6'){
                    count=(count%mod + dp[idx+2] % mod )%mod;
                }
            }
            
        }
        else{
            count=(count%mod + dp[idx+1] % mod )%mod;
            if(idx<s.length()-1){
                if(s.charAt(idx+1)!='*'){
                char ch2=s.charAt(idx+1);
                int num=(ch1-'0')*10+(ch2-'0');
                if(num<=26) 
                    count=(count%mod + dp[idx+2] % mod )%mod;
                }
                else {
                    if(s.charAt(idx)=='1')
                         count=(count%mod + 9*dp[idx+2] % mod )%mod;
                
                    else if(s.charAt(idx)=='2')
                         count=(count%mod + 6*dp[idx+2] % mod )%mod;
                    
                }
            } 
        }
         dp[idx]=count;

        }
        return dp[IDX];
    }


    // https://www.geeksforgeeks.org/count-number-of-ways-to-partition-a-set-into-k-subsets/

    public static int noOfWays(int n,int k,int[][] dp){
            if(k==1)
            return dp[n][k]=1;

            if(n==k)
            return dp[n][k]=1;

            if(dp[n][k]!=0)
            return dp[n][k];

            int uniqueGroups=noOfWays(n-1, k-1, dp);
            int partOfExisitingGroup=noOfWays(n-1, k, dp)*k;
            int ans=partOfExisitingGroup+uniqueGroups;

            return dp[n][k]=ans;

    }

}