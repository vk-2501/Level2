package Arrays_Strings.Lecture_of-28july;

public class Merge_Interval {
    class Solution {
        public int[][] merge(int[][] intervals) {
            
            Arrays.sort(intervals,(a,b)->{
                return a[0]-b[0];
            });
            
            ArrayList<int[]> res=new ArrayList<>();
            
            for(int[] inter:intervals){
                if(res.size()==0){
                    res.add(inter);
                }
                else{
                  int  interval[]=res.get(res.size()-1);
                  if(inter[0]>interval[1]){
                      res.add(inter);
                  }
                    else{
                      interval[1]=Math.max(interval[1],inter[1]);
                    }
                }
            }
            
            int[][] ress=new int[res.size()][2];
            for(int i=0;i<res.size();i++){
                ress[i]=res.get(i);
            }
            
            return ress;
        }
    }
}
