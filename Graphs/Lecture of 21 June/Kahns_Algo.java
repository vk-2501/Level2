import java.util.*;
public class Kahns_Algo{
    public static int[] topSort_Kahns(int V,ArrayList<ArrayList<Integer>> adj){
        
      int[] topsort=new int[V];

      int[] in=new int[V];
      for(int v=0;v<V;v++){
        for(int nbr:adj.get(v)){
            in[nbr]++;
        }
      }

      ArrayDeque<Integer> q=new ArrayDeque<>();
      for(int v=0;v<V;v++){
        if(in[v]==0){
            q.add(v);
        }
      }

      int idx=0;
      while(q.size()>0){
        int rem=q.remove();
        topsort[idx++]=rem;

        for(int nbr:adj.get(rem)){
            in[nbr]--;

            if(in[nbr]==0){
                q.add(nbr);
            }
        }
      }

      if(idx<V){
        return new int[] {};
      }

      return topsort;
    }
}