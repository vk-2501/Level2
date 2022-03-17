//count subarray sum equal to k

import java.util.HashMap;
 class subarrray_sum_k {

    public static void main(String[] args){
    int ans=0;
    int sum=0;
    int arr[]={1,0,1,1,0,1,0,1};
    int k=12;

    HashMap<Integer,Integer> hm=new HashMap<>();
    hm.put(0,1);

    for(int val:arr){
       sum+=val;
       if(hm.containsKey(sum-k)){
            ans+=hm.get(sum-k);

       }
       if(hm.containsKey(sum)){
           hm.put(sum,hm.get(sum)+1);
       }
       else{
        hm.put(sum,1);
       }
    }
    System.out.println(ans);
}
}
