//count substrings with equal no of 0 ,1 and 2

import java.util.*;

class Main{
public static void main(String[] args){
    int ans=0;
   
    String st="01220112002121120";

    HashMap<String,Integer> hm=new HashMap<>();
    String key="0#0";
    hm.put(key,1);

    int c0=0;
    int c1=0;
    int c2=0;
    for(int i=0;i<st.length();i++){
        char ch=st.charAt(i);

        if(ch=='0'){
            c0++;
        }
        else if(ch=='1'){
            c1++;

        }
        else{
            c2++;

        }

        key=(c1-c0)+"#"+(c2-c1);
        if(hm.containsKey(key)){
            ans+=hm.get(key);
            hm.put(key,hm.get(key)+1);
        }
        else{
            hm.put(key,1);
        }
    }

  System.out.println(ans);



}
}