public class Cracking_the_safe {
    class Solution {
        public String crackSafe(int n, int k) {
            
            StringBuilder sb=new StringBuilder();
            for(int i=0;i<n;i++){
                sb.append(0);
            }
            
            HashSet<String> vis=new HashSet<>();
            vis.add(sb.toString());
            
            int lim=(int)Math.pow(k,n);
            
            dfs(sb,vis,lim,n,k);
            
            return sb.toString();
        }
        
        public boolean dfs( StringBuilder sb,  HashSet<String> vis, int lim, int n,int k){
            if(vis.size()==lim){
                //ans is this
                return true;
            }
            
            String lmn1=sb.substring(sb.length()-(n-1));
            
            for(int i=0;i<k;i++){
                String newp=lmn1+i;
                
                if(!vis.contains(newp)){
                    vis.add(newp);
                    sb.append(i);
                    boolean flag=dfs(sb,vis,lim,n,k);
                    if(flag) return true;
                    
                    vis.remove(newp);
                    sb.deleteCharAt(sb.length()-1);
                }
            }
            return false;
        }
    }
}
