class Solution {
    public boolean canMakeArithmeticProgression(int[] arr) {
        
      HashSet<Integer> hs=new HashSet<>();
       int n=arr.length;
       
       if(n<=1){
           return true;
       }
        
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        for(int val:arr){
            hs.add(val);
            
            min=Math.min(val,min);
            max=Math.max(val,max);
            
        }
        
        int d=(max-min)/(arr.length-1);
        
        for(int i=0;i<n;i++){
            int term=min+(i)*d;
            
            if(hs.contains(term)==false){
                return false;
            }
        }
        return true;
    }
}

// class Solution {
//     public boolean canMakeArithmeticProgression(int[] arr) {
//         Arrays.sort(arr);
//         int diff=arr[1]-arr[0];
//         for(int i=2;i<arr.length;i++){
//             if(arr[i]-arr[i-1]!=diff) return false;
//         }
//         return true;
//     }
// }