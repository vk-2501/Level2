class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> hs=new HashSet<>();
        int max=0;
        
        for(String sp:wordDict){
            hs.add(sp);
            max=Math.max(sp.length(),max);
        }
        
        boolean[] dp=new boolean[s.length()+1];
        
        dp[0]=true;
        for(int i=0;i<=s.length();i++){
            if(dp[i]==false) continue;
            for(int len=1;len<=s.length() && i+len<=s.length();len++){
                String sb=s.substring(i,i+len);
                if(hs.contains(sb)){
                    dp[i+len]=true;
                }
            }
        }
        
        return dp[s.length()];
        
    }
}package DP_L2.Lec6;

public class word_break {
    
}
