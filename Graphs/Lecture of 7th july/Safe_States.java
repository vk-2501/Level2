public class Safe_States {
    class Solution {
        int[] vis;
       public List<Integer> eventualSafeNodes(int[][] graph) {
           List<Integer> ans=new ArrayList<>();
           vis=new int[graph.length];
           
           for(int v=0;v<graph.length;v++){
                   
                boolean safe=dfs(graph,v);
               if(safe){
                   ans.add(v);
               }
               
           }
           return ans;
           
       }
       
       
       public boolean dfs(int[][] graph,int v){
        if(vis[v]==2){
            return true;
        }
        else if(vis[v]==1){
            return false;
        }
        else{
           vis[v]=1;
           for(int e:graph[v]){
            boolean isSafe=dfs(graph,e);
            if(isSafe==false){
                return false;
            }
           }
           
           vis[v]=2;
           return true;
        }
       }
   }
}
