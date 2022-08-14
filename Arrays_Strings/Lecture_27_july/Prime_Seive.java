class Solution {
    public int countPrimes(int n) {
        if(n<2) return 0;
        boolean[] arr=new boolean[n+1];
        Arrays.fill(arr,true);
        
        arr[0]=false;
        arr[1]=false;
        
        for(int div=2;div*div<=n;div++){
            if(arr[div]==false) continue;
            for(int m=div;div*m<=n;m++){
                arr[div*m]=false;
            }
        }
        
        int c=0;
        for(int v=0;v<arr.length-1;v++){
            if(arr[v]) c++;
        }
        return c;
    }
}