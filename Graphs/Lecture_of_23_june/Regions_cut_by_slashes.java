class Solution {
    int parent[];
    int rank[];
    public int regionsBySlashes(String[] grid) {
        parent=new int[4 * grid.length * grid.length];
        rank=new int[4 * grid.length * grid.length];
        
        for(int i=0;i<parent.length;i++){
            parent[i]=i;
            rank[i]=0;
        }
        
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length();j++){
                char ch=grid[i].charAt(j);
                
                int bno=i*grid.length+j;
                
                if(ch!='/'){
                    unionHelp(4 * bno + 0,4 * bno +1);
                    unionHelp(4 * bno + 3,4 * bno +2);
                    
                }
                if(ch!='\\'){
                    unionHelp(4 * bno + 3,4 * bno +0);
                    unionHelp(4 * bno + 2,4 * bno +1);
                }
                
                if(i>0){
                    int ono=(i-1)*grid.length+j;
                    unionHelp(4 * bno + 0,4 * ono +2);
                   
                }
                if(j>0){
                    int ono=i*grid.length+(j-1);
                    unionHelp(4 * bno + 3,4 * ono +1);
                }
            }
        }
        
        int c=0;
        for(int i=0;i<parent.length;i++){
            if(parent[i]==i)
                c++;
        }
        
        return c;
        
        
    }
    
    public int find(int x){
        if(parent[x]==x)
            return x;
        else{
            parent[x]=find(parent[x]);
            return parent[x];
        }
    }
    
    public void union(int s1,int s2){
        if(rank[s1]<rank[s2]){
            parent[s1]=s2;
        }
        else if(rank[s1]>rank[s2]){
            parent[s2]=s1;
        }
        else{
            parent[s1]=s2;
            rank[s1]++;
        }
    }
    
    public void unionHelp(int x,int y){
        int x1=find(x);
        int y1=find(y);
        if(x1!=y1){
            union(x1,y1);
        }
    }
}