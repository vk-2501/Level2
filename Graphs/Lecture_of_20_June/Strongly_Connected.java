public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj )
{
    //step1 
    boolean[] vis1=new boolean[V];
    Stack<Integer> st=new Stack<>();
    for(int v=0;v<V;v++){
       if(!vis1[v]){
           dfs1(adj,vis1,v,st);
       }
    }
    
    //step2 Transpose
    ArrayList<ArrayList<Integer>> tsp=new ArrayList<>();
    for(int i=0;i<V;i++){
        tsp.add(new ArrayList<>());
    }
    for(int i=0;i<adj.size();i++){
        for(int e:adj.get(i)){
           tsp.get(e).add(i);
        }
    }
    
    //step 3
    int count=0;
     boolean[] vis2=new boolean[V];
     while(st.size()>0){
         int v=st.pop();
         if(vis2[v]==false){
             dfs2(tsp,vis2,v);
             count++;
         }
     }
     return count;
}

 public void dfs2(ArrayList<ArrayList<Integer>> adj,boolean[] v1,int v){
    v1[v]=true;
     for(int e:adj.get(v)){
        if(v1[e]==false){
            dfs2(adj,v1,e);
        }
    }
 }
public void dfs1(ArrayList<ArrayList<Integer>> adj,boolean[] v1,int v,Stack<Integer> st){
    v1[v]=true;
    for(int e:adj.get(v)){
        if(v1[e]==false){
            dfs1(adj,v1,e,st);
        }
    }
    st.push(v);
}