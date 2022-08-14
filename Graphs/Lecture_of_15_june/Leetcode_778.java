package Lecture_of_15_june;

class Solution {

    class pair implements Comparable<pair> {
       int i;
       int j;
       int w;

       pair(int i, int j, int w) {
           this.i = i;
           this.j = j;
           this.w = w;
       }

       public int compareTo(pair o) {
           return this.w - o.w;
       }
   }

   public int swimInWater(int[][] grid) {
       //int level = 0;
       PriorityQueue<pair> q = new PriorityQueue<>();
       boolean[][] visit = new boolean[grid.length][grid[0].length];
       q.add(new pair(0, 0, grid[0][0]));
       while (q.size() > 0) {
           pair rem = q.remove();
           
           if (visit[rem.i][rem.j] == true) {
               continue;
           }
           visit[rem.i][rem.j] = true;
           if (rem.i == grid.length - 1 && rem.j == grid[0].length - 1) {
               return rem.w;
           }

           

           help(rem.i - 1, rem.j, rem.w, visit, grid, q);
           help(rem.i, rem.j - 1, rem.w, visit, grid, q);
           help(rem.i + 1, rem.j, rem.w, visit, grid, q);
           help(rem.i, rem.j + 1, rem.w, visit, grid, q);
       }
       
       return -1;
   }

   public void help(int i, int j, int ot, boolean[][] visit, int[][] grid, PriorityQueue<pair> q) {
       if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || visit[i][j] == true) {
           return;
       }
       q.add(new pair(i, j, Math.max(ot, grid[i][j])));
   }
}
