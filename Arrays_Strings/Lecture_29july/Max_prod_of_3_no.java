public class Max_prod_of_3_no {
    class Solution {
        public int maximumProduct(int[] nums) {
            int min1=Integer.MAX_VALUE;
            int min2=Integer.MAX_VALUE;
            int max1=Integer.MIN_VALUE;
            int max2=Integer.MIN_VALUE;
            int max3=Integer.MIN_VALUE;
           
            
            for(int v:nums){
                if(v<=min1){
                    min2=min1;
                    min1=v;
                }
                else if(v<=min2){
                    min2=v;
                }
                 if(v>=max1){
                    max3=max2;
                    max2=max1;
                    max1=v;
                }
                
                else if(v>=max2){
                    max3=max2;
                    max2=v;
                }
                else if(v>=max3){
                    max3=v;
                }
            }
            
            return Math.max(min1*min2*max1,max1*max2*max3);
            
        }
    }
}
