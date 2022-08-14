class Solution {
    public boolean isMatch(String s, String p) {
      p=remove(p);
        int n=s.length();
        int m=p.length();
        
        int[][] dp=new int[n+1][m+1];
        for(int[] d:dp)Arrays.fill(d,-1);
        
       
        return memo(s,p,n,m,dp)==1?true:false;
    }
    public String remove(String p){
        if(p.length()==0) return p;
        StringBuilder sb=new StringBuilder();
        sb.append(p.charAt(0));
        
        int i=1;
        while(i<p.length()){
            while(i<p.length() && sb.charAt(sb.length()-1)=='*' && p.charAt(i)=='*') i++;
            
            if(i<p.length()){
                sb.append(p.charAt(i));
            }
            i++;
            
        }
        
        return sb.toString();
    }
    public int memo(String s,String p,int n,int m,int[][] dp){
        
        if(n==0 || m==0){
        if(n==0 && m==0){
            return dp[n][m]=1;
        }
        else if(m==1 && p.charAt(m-1)=='*'){
            return dp[n][m]=1;
        }
            else{
                return dp[n][m]=0;
            }
            
        }
        
        
        if(dp[n][m]!=-1)return dp[n][m];
        
        char c1=s.charAt(n-1);
        char c2=p.charAt(m-1);
        
        if(c1==c2 || c2=='?'){
            return dp[n][m]=memo(s,p,n-1,m-1,dp);
        }
        else if(c2=='*'){
            boolean res=false;
            res=res || memo(s,p,n-1,m,dp)==1;
            res=res || memo(s,p,n,m-1,dp)==1;//star mapping to empty string 
            
            return dp[n][m]=res?1:0;
        }
        else{
            return dp[n][m]=0;
            
        }
        
    }
}


