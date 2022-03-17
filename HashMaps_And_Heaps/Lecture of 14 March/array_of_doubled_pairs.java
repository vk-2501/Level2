import java.util.HashMap;

class Main{
    public static boolean doubledPairs(int[] n){
        //storing the frequencies
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(int val:n){
            hm.put(val,hm.getOrDefault(val,0)+1);
        }

        //sort the array 
        Arrays.sort(n);

        //traverse the array
        // if I find val and val*2 presnt in hashmap then i will decrement their frequencies 
        // but while decrementing i will check whether the frequency is not 1 .If its is 1 then I will 
        //remove it from hashmap

        // If the hashmap becomes empty then return true
        // else if (hm.size()==1 and it contains only 0 ) then return true
        //else return false

        for(int val:arr){
            if(val!=0 && hm.containsKey(val) && hm.containsKey(2*val)){
                if(hm.getOrDefault(val,0)>1){
                    //decrement
                    hm.put(val,hm.getOrDefault(val, 0)-1);
                }
                else{
                    //remove
                    hm.remove(val);
                }

                //for doubled value
                if(hm.getOrDefault(2*val,0)>1){
                    //decrement
                    hm.put(2*val,hm.getOrDefault(2*val, 0)-1);
                }
                else{
                    //remove
                    hm.remove(2*val);
                }
            }
        }

        if(hm.size()==0)
        return true;
        else if(hm.size()==1 && hm.containsKey(0))
        return true;
        else
        return false;
        
    }
}