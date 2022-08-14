class Solution {
    int parent[];
    int rank[];
    public boolean equationsPossible(String[] equations) {
        parent=new int[26];
        rank=new int[26];
        
        for(int i=0;i<26;i++){
            parent[i]=i;
            rank[i]=0;
        }
        
        for(int i=0;i<equations.length;i++){
            String word=equations[i];
            
            char ch=word.charAt(1);
            if(ch=='='){
                int o1=word.charAt(0)-'a';
                int o2=word.charAt(3)-'a';
                
                int of1=find(o1);
                int of2=find(o2);
                
                if(of1!=of2){
                    union(of1,of2);
                }
            }
        }
        
        for(int i=0;i<equations.length;i++){
          String word=equations[i];
            
              char ch=word.charAt(1);
             if(ch=='!'){
                 int o1=word.charAt(0)-'a';
                int o2=word.charAt(3)-'a';
                
                 int of1=find(o1);
                int of2=find(o2);
                
                 
                if(of1==of2){
                    return false;
                }
            }
            
        }
        
        return true;
        
    }
    
    public int find(int x){
        if(parent[x]==x){
            return x;
        }
        else{
            parent[x]=find(parent[x]);
            return parent[x];
        }
    }
    
    public void union(int x,int y){
        if(rank[x]<rank[y]){
            parent[x]=y;
        }
        else if(rank[x]>rank[y]){
             parent[y]=x;
        }
        else{
            parent[x]=y;
            rank[y]++;
        }
    }
}
