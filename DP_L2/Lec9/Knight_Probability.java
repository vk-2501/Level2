class Solution {
    int[] dx={2,1,-1,-2,-2,-1,1,2};
    int[] dy={1,2,2,1,-1,-2,-2,-1};
    
    public double knightProbability(int n, int k, int row, int column) {
        
       double dp[][][]=new double[k+1][n+1][n+1];
        return help(n,k,row,column,dp);
    }
    public double help(int n,int k,int row,int col,double dp[][][]){
        if(k==0) return dp[k][row][col]=1.0;
        
        if(dp[k][row][col]!=0.0)return dp[k][row][col];
        
        double count=0;
        
        for(int i=0;i<dx.length;i++){
            int r=row+dx[i];
            int c=col+dy[i];
            
            if(r>=0 && c>=0 && r<n &&c<n){
                count+=help(n,k-1,r,c,dp);
            }
           
        }
        
        return dp[k][row][col]=count/8.0;
    }
    
}
