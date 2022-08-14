package DP_L2.Lec6;

public class GoldMine_back_engine {
    public static void gm(int[][] dp,int[][] dir,int sr,int sc,String asf){
        if(sc==dp[0].length-1){
            System.out.println(asf+"("+sr+","+sc+")");
            return;
        }

        int maxGold=0;
        int idx=-1;
        for(int d=0;d<dir.length;d++){
            int r=sr+dir[d][0];
            int c=sc+dir[d][1];

            if(r>=0 && c>=0 && r<dp.length && c<dp[0].length && dp[r][c]>maxGold){
                maxGold=dp[r][c];
                idx=d;
            }
        }

        if(idx!=-1){
            int r=sr+dir[idx][0],c=sc+dir[idx][1];
            GoldMine_back_engine(dp,dir,r,c,asf+"("+sr+","+sc+")");
        }
    }
}
