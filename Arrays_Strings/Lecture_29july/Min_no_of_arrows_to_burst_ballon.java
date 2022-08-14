// Minimum Number of Arrows to Burst Balloons

public class Min_no_of_arrows_to_burst_ballon {
    class Solution {
        public int findMinArrowShots(int[][] points) {
            Arrays.sort(points,(a,b)->{
                if(a[0]<b[0]){
                    return -1;
                }
                else if(a[0]==b[0]){
                    return 0;
                }
                else{
                    return 1;
                }
            });
            
            int c=1;
            int min=points[0][1];
            for(int i=1;i<points.length;i++){
                if(points[i][0]>min){
                    c++;
                     min=points[i][1];
                }
                else
                min=Math.min(min,points[i][1]);
            }
            
            return c;
        }
    }
}
