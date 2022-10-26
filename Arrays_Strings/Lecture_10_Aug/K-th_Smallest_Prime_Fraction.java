package Arrays_Strings.Lecture_10_Aug;

class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        double lo=0;
        double hi=1;
        
        
        while(lo<=hi){
            int p=0;
        int q=1;
            double mid=(lo+hi)/2;
            
            
            //count
            int j=0;
            int count=0;
            for(int i=0;i<arr.length;i++){
                while(j<arr.length && arr[i]>mid*arr[j]){
                    j++;
                }
                
                if(j==arr.length){
                    break;
                }
                count+=(arr.length-j);
                
                if(arr[i]*q>p*arr[j]){
                    p=arr[i];
                    q=arr[j];
                }
            }
            
            
            
            
            if(count<k){
                lo=mid;
            }
            else if(count>k){
                hi=mid;
            }
            else{
                return new int[]{p,q};
            }
        }
        return null;
        
    }
}
