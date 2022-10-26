// package Arrays_Strings.Lecture_of_8Aug;

public class Minimum_no_of_books {
    public class Solution {
        public int books(int[] A, int B) {
            if(A.length<B){
                return -1;
            }
            int lo=Integer.MIN_VALUE;
            int hi=0;
            for(int v:A){
                lo=Math.max(lo,v);
                hi+=v;
            }
            
            while(lo<hi){
                int mid=(lo+hi)/2;
                
                int no_of_stu=1;
                int sum_of_page=0;
                
                for(int v:A){
                    if(v+sum_of_page<=mid){
                        sum_of_page+=v;
                    }
                    else{
                        sum_of_page=v;
                        no_of_stu++;
                    }
                }
                
                if(no_of_stu>B){
                    lo=mid+1;
                }
                else{
                    hi=mid;
                }
            }
            return lo;
        }
    }
    
}
https://www.interviewbit.com/problems/allocate-books/
