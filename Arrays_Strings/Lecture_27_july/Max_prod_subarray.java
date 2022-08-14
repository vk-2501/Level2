package Arrays_Strings.Lecture_27_july;

class Solution {
    public int maxProduct(int[] nums) {
        int n=nums.length;
      int maxp=Integer.MIN_VALUE, prod=1;
      for(int i=0;i<n;i++){
          prod=prod*nums[i];
          maxp=Math.max(maxp,prod);
          if(prod==0){
              prod=1;
          }
          
      }
      
      prod=1;
      for(int i=n-1;i>=0;i--){
        prod=prod*nums[i];
          maxp=Math.max(maxp,prod);
          if(prod==0){
              prod=1;
          }  
      }
      return maxp; 
    }
}
