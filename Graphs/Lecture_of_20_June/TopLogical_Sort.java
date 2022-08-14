pubpackage Lecture_of_20_June;

public class TopLogical_Sort {
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        // add your code here
        Stack<Integer> st=new Stack<>();
        boolean[] vis=new boolean[V];
        for(int v=0;v<V;v++){
            if(!vis[v]){
                top(adj,v,vis,st);
            }
        }
        
        int[] ans=new int[st.size()];
        int idx=0;
        while(st.size()>0){
            ans[idx++]=st.pop();
        }
        return ans;
    }
    
    static void top( ArrayList<ArrayList<Integer>> adj,int v,boolean[] vis,Stack<Integer> st){
        vis[v]=true;
        for(int nbr:adj.get(v)){
            if(vis[nbr]==false){
                top(adj,nbr,vis,st);
            }
        }
        st.push(v);
    }
}
l