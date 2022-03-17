import java.util.HashMap;

class Main{
public static void main(String[] args){
    int ans=0;
    int sum=0;
    int arr[]={1,0,1,1,0,1,0,1};

    HashMap<Integer,Integer> hm=new HashMap<>();
    hm.put(0,1);

    for(int val:arr){
        if(val==0){
            sum+=-1;
        }
        else{
            sum+=1;
        }

        if(hm.containsKey(sum)){
            ans+=hm.get(sum);
            hm.put(sum,hm.get(sum)+1);
        }
        else{
            hm.put(sum,1);
        }
    }
    System.out.println(ans);

}
}