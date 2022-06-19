package Lecture_of_14_June;

public class ifGraphBip {
    class Solution {
        public boolean isBipartite(int[][] graph) {
            
            
            int[] visited=new int[graph.length];
            for(int v=0;v<graph.length;v++){
                if(visited[v]==0){
                boolean isbip=helper(graph,visited,v);
                if(isbip==false){
                    return false;
                }
                }
              
            }
            return true;
        }
        
        
        
        public class Pair{
            int v;
            int clr;
            Pair(int v,int clr){
                this.v=v;
                this.clr=clr;
            }
        }
    
        
        public boolean helper(int[][] graph,int[] visited,int v){
            ArrayDeque<Pair> q=new ArrayDeque<>();
            
            q.add(new Pair(v,1));
            while(q.size()>0){
                //remove
                Pair rem=q.remove();
                
                //mark *
                if(visited[rem.v]!=0){
                    int oc=visited[rem.v];
                    int nc=rem.clr;
                    if(oc==nc)
                        continue;
                    else
                        return false;
                }
                visited[rem.v]=rem.clr;
                
                //work
                
                //add nbr
                for(int nbr:graph[rem.v]){
                    if(visited[nbr]==0){
                        q.add(new Pair(nbr,rem.clr*-1));
                    }
                }
            }
            return true;
        }
        
            public boolean helper_dfs(int[][] graph,int[] visited,int v,int clr){
            visited[v]=clr;
            for(int nbr:graph[v]){
                if(visited[nbr]==0){
                    boolean isB=helper_dfs(graph,visited,v,clr*-1);
                    if(isB==false){
                        return false;
                    }
                }
                else{
                    int oc=visited[nbr];
                    int nc=clr*-1;
                    if(oc!=nc){
                        return false;
                    }
                }
            }
                return true;
        }
    }
}
