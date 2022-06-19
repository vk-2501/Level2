import java.util.*;
public class l001_Two_Pointers {
    /*
     * 1. Faith 2. Recursive Tree 3. Recursion Code 4. Convert Recursion code into
     * memoization 5. Observation 6. Tabulation 7. Optimization
     */

     //FIBONACCI
     // F(n) = F(n - 1) + F(n - 2)
    public static int fibo_memo(int n, int[] dp) {
        if (n <= 1) {
            return dp[n] = n;
        }

        if (dp[n] != 0)
            return dp[n];

        int ans = fibo_memo(n - 1, dp) + fibo_memo(n - 2, dp);
        return dp[n] = ans;
    }

    public static int fibo_tabu(int N, int[] dp) {
        for(int n=0;n<=N;n++){
            if (n <= 1) {
                 dp[n] = n;
                 continue;
            }

            dp[n]=dp[n-1]+dp[n-2];

        }
        
        return dp[N];
    }

    public static int fibo_opti(int n) {
        int a = 0, b = 1;
        for (int i = 0; i < n; i++) {
            int sum = a + b;
            a = b;
            b = sum;
        }
        return a;
    }

       // total no of paths from all given direction
       public static int mazePath_memo(int sr, int sc, int er, int ec, int[][] dir, int[][] dp) {
        if (sr == er && sc == ec) {
            return dp[sr][sc] = 1;
        }

        if (dp[sr][sc] != 0)
            return dp[sr][sc];

        int count = 0;
        for (int[] d : dir) {
            int r = sr + d[0];
            int c = sc + d[1];

            if (r >= 0 && c >= 0 && r <= er && c <= ec)
                count += mazePath_memo(r, c, er, ec, dir, dp);
        }

        return dp[sr][sc] = count;
    }

    //Tabulation
    public int mazePath_tabu(int sr,int sc,int er,int ec,int[][] dir,int[][] dp){
    
        for(sr=er;sr>=0;sr--){
           for( sc=ec;sc>=0;sc--){
              if(sr==er && sc==ec){
                  dp[sr][sc]= 1;
                  continue;
             }
             int count=0;
        
           for(int d=0;d<dir.length;d++){
            int r=sr+dir[d][0];
            int c=sc+dir[d][1];
            
            if(r>=0 && c>=0 && r<=er && c<=ec){
                count+=dp[r][c];
                
            }
        }
             dp[sr][sc]=count;
           }
        }
        return dp[0][0];
     }
         


     //CLIMBING STAIRS
     public int climbStairs_tabu(int N,int[] dp) {
        for(int n=0;n<=N;n++){
           if(n<=1){
              dp[n]=1;
              continue;
          }
  
          dp[n]=dp[n-1]+dp[n-2];
        }
        return dp[N];  
   }

   //MIN COST CLIMBING STAIRS
   public int mincost_memo(int[] costs,int n,int[] dp){

    if(n<=1){
       return dp[n]=costs[n];
    }
 
    if(dp[n]!=0)
    return dp[n];
 
    int fm1=mincost_memo(costs,n-1,dp);
    int fm2=mincost_memo(costs,n-2,dp);
 
    int ans= Math.min(fm1,fm2)+(n==costs.length?0:costs[n]);
    return dp[n]=ans;
 
 
  }
    
      
  public int help(int[] cost,int N,int[] dp){
        
    for(int n=0;n<=N;n++){
        if(n<=1){
         dp[n]=cost[n];
            continue;
    }
            
      int lv=dp[n-1];
     int rv =dp[n-2];
    int ans=Math.min(lv,rv)+(n==cost.length?0:cost[n]);
    
    dp[n]=ans;
        
    
    }
    
    return dp[N];
     }


     //FRIENDS PAIRING
     public static int fp_memo(int n,int[]dp){
         if(n<=1){
             return dp[n]=1;
             
         }

         if(dp[n]!=0)
         return dp[n];

         int single=fp_memo(n-1,dp);
         int pair=fp_memo(n-2, dp)*(n-1);
         int ans=single+pair;
         return dp[n]=ans;
     }

     //PRINT ANS OF FRINEDS PAIRING
     public static long printFriendPairing(String friends,String ans){
         char ch=friends.charAt(0);
         long count=0;
         count+=printFriendPairing(friends, ans+ch+" ");
         for(int i=1;i<friends.length();i++){
             String rstr=friends.substring(1,i)+friends.substring(i+1);
             count+=printFriendPairing(friends,ans+ch+friends.charAt(i)+" ");
         }
     }

     //GOLD MINE
     public static int goldMine(int r,int c,int[][] mat,int[][] dp,int[][] dir){
         if(c==mat[0].length-1){
             return dp[r][c]=mat[r][c];
         }
         if(dp[r][c]!=-1)
         return dp[r][c];

         int maxgold=0;

         for(int i=0;i<dir.length;i++){
             int x=r+dir[i][0];
             int y=c+dir[i][1];
             if(x>=0 && x<mat.length){
                 maxgold=Math.max(maxgold,goldMine(x, y, mat, dp, dir));
             }
         }

         return dp[r][c]=maxgold+mat[r][c];
     }

     public static int goldMine_tabu(int R,int C,int[][] mat,int[][] dp,int[][] dir){
       
        int n=mat.length;
        int m=mat[0].length;

        for(int c=m-1;c>=0;c--){
            for(int r=n-1;r>=0;r--){
                if(c==mat[0].length-1){
                     dp[r][c]=mat[r][c];
                     continue;
                }
                
        
                int maxgold=0;
        
                for(int i=0;i<dir.length;i++){
                    int x=r+dir[i][0];
                    int y=c+dir[i][1];
                    if(x>=0 && x<n){
                        maxgold=Math.max(maxgold,dp[x][y]);
                    }
                }
        
                 dp[r][c]=maxgold+mat[r][c];
            }
        }
        return dp[R][C];
      
    }

     public static void callGoldMine(){
        int [][] mat={};
        int dp[][]=new int[mat.length][mat[0].length];
        for(int[] d:dp) Arrays.fill(d,-1);
        int dir[][]={{-1,1},{1,1},{0,1}};

        int maxgold=0;
        for(int i=0;i<mat.length;i++){
            maxgold=Math.max(maxgold,goldMine(i,0, mat, dp, dir));
        }
        System.out.println(maxgold);
     }

}