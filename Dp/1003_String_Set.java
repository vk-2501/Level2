public class 1003_String_Set{
    //LONGEST PALINDROMIC SUBSEQUENCE
    public int help_memo(String s,int i,int j,int[][] dp){
        if(i>=j){
            return dp[i][j]=i==j?1:0;
        }
        
        int a=help_memo(s,i+1,j-1,dp);
        int b=help_memo(s,i+1,j,dp);
        int c=help_memo(s,i,j-1,dp);
        
        if(s.charAt(i)==s.charAt(j)){
            return dp[i][j]=a+2;
        }
        else{
            return dp[i][j]=Math.max(b,c);
        }
    }

    public int help_tabu(String s,int I,int J,int[][] dp){

        int n=s.length();
        for(int g=0;g<n;g++ ){
            for( int i=0,j=g;j<n;i++,j++){
                if(i>=j){
                     dp[i][j]=i==j?1:0;
                     continue;
                }
                int a=dp[i+1][j-1];//help_memo(s,i+1,j-1,dp);
                int b=dp[i+1][j];//help_memo(s,i+1,j,dp);
                int c=dp[i][j-1];//help_memo(s,i,j-1,dp);

                   
                if(s.charAt(i)==s.charAt(j)){
                     dp[i][j]=a+2;
                }
                else{
                     dp[i][j]=Math.max(b,c);
                }
            }
        }
       
        
       
     return dp[I][J];
    }

    //Print longest palindromic subsequence
    public String print_longestSubsequence(String s){

        String[][] dp=new String[s.length()][s.length()];
        for(String d[]:dp) Arrays.fill(d,"");
        int n=s.length();
        for(int g=0;g<n;g++){
            for(int i=0,j=g;j<n;i++,j++){
                if(i==j){
                    dp[i][j]=s.charAt(i)+"";
                    continue;
                }

                if(s.charAt(i)==s.charAt(j)){
                    dp[i][j]=s.charAt(i)+dp[i+1][j-1]+s.charAt(j);
                }else{
                    dp[i][j]=(dp[i+1][j].length()>dp[i][j-1].length())?dp[i+1][j]:dp[i][j-1];
                }
            }
        }
        return dp[0][n-1];
    }
    

    public int numDistinct(String s, String t) {
        int n=s.length();
        int m=t.length();
        int dp[][]=new int[n+1][m+1];
        for(int[] d:dp) Arrays.fill(d,-1);
        return help(s,t,n,m,dp);
    }
    

    //DISTINCT SUBSEQUENCES
    public int help(String s ,String t,int n,int m,int[][] dp){
        if(m==0){
            return dp[n][m]=1;
        }
        if(n==0)
        {
            return dp[n][m]=0;
        }
        if(n==0 || m==0){
            return dp[n][m]=1;
        }
        
        if(dp[n][m]!=-1)
            return dp[n][m];
        
        int a=help(s,t,n-1,m-1,dp);
        int c=help(s,t,n-1,m,dp);
        
        if(s.charAt(n-1)==t.charAt(m-1)){
            return dp[n][m]=a+c;
        }
        
        else{
            return dp[n][m]=c;
        }
    }

    //count palindromic subsequences
    
}