//count subarrays whose sum is  divisible by k
import java.util.HashMap;

class Main{
public static void main(String[] args){
    int ans=0;
    int sum=0;
    int arr[]={1,0,1,1,0,1,0,1};
    int k =3;

    HashMap<Integer,Integer> hm=new HashMap<>();
    hm.put(0,1);

    for(int val:arr){
        sum+=val;
        int rem=sum%k;
        if(rem<0){
            rem+=k;
        }

        if(hm.containsKey(rem)){
            ans+=hm.get(rem);
            hm.put(rem,hm.get(rem)+1);
        }
        else{
            hm.put(rem,1);
        }
    }

    
    System.out.println(ans);

}
}
