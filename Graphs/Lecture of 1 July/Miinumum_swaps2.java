public class Miinumum_swaps2 {
    import java.io.*;
import java.util.*;

class GFG {
	public static void main (String[] args) {
	    int[] a={3, 6, 4, 8};
	    int[] b={4, 6, 8, 3};
	    
	    HashMap<Integer,Integer> hm=new HashMap<>();
	    for(int i=0;i<b.length;i++){
	        hm.put(b[i],i);
	    }
	    
	    boolean[] vis=new boolean[a.length];
	    int ans=0;
	    for(int i=0;i<a.length;i++){
	        if(vis[i]==true || hm.get(a[i])==i){
	            continue;
	        }
	        
	        vis[i]=true;
	        int c=0;
	        int j=i;
	        
	        do{
	           j=hm.get(a[j]);
	           vis[j]=true;
	           c++;
	           
	        } while(i!=j);
	        ans+=c-1;
	    }
	    System.out.println(ans);
	}
}
}
