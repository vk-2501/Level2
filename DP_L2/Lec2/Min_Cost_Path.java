class Solution{
    static int maximumPath(int N, int Matrix[][])
    {
        // code here
        int[][] dp=new int[N][N];
        int[][] dir={{1,0},{1,-1},{1,1}};
        for(int d[]:dp){
            Arrays.fill(d,-1);
        }
        int maxsum=Integer.MIN_VALUE;
        int cidx=0;
        for(int i=0;i<N;i++)
        {
            maxsum=Math.max(rec(Matrix,dp,dir,i,0),maxsum);
        }
        return maxsum;
        
       
        
        
    }
    
    public static int rec(int[][] mat,int[][] dp,int[][] dir,int sc,int sr){
            int n=mat.length ;
            int m=mat[0].length;
            
            if(dp[sr][sc]!=-1) return dp[sr][sc];
            
            if(sr==n-1){
                return dp[sr][sc]=mat[sr][sc];
            }
            
            
            
            int max=0;
            for(int[] d:dir){
                int r=sr+d[0];
                int c=sc+d[1];
                
                if(r>=0 && c>=0 && r<n && c<m){
                    max=Math.max(max,rec(mat,dp,dir,c,r)+mat[sr][sc]);
                    
                }
            }
          return dp[sr][sc]=max;
     
    }
    
    
}