class Solution {
    HashMap<String,String> parent;
    HashMap<String,Integer> rank;
    public int numSimilarGroups(String[] strs) {
        parent=new HashMap<>();
        rank=new HashMap<>();
        
        for(String s:strs){
            parent.put(s,s);
            rank.put(s,1);
        }
        
        for(int i=0;i<strs.length;i++){
            for(int j=i+1;j<strs.length;j++){
                String si=strs[i];
                String sj=strs[j];
                
                if(areSame(si,sj)){
                    String l1=find(si);
                    String l2=find(sj);
                    
                    if(l1.equals(l2)==false){
                        unionHelp(l1,l2);
                    }
                }
            }
        }
        
        int count=0;
        for(String s:parent.keySet()){
            if(s.equals(parent.get(s))){
                count++;
            }
        }
        
        return count;
        
    }
    
    public boolean areSame(String s1,String s2){
        int res=0;
        for(int i=0;i<s1.length();i++){
            if(s1.charAt(i)!=s2.charAt(i)){
                res++;
            }
        }
        return res==2;
    }
    
    public String find(String x){
        if(parent.get(x).equals(x)){
            return x;
        }
        else{
            String xl=find(parent.get(x));
            parent.put(x,xl);
            return xl;
        }
    }
    
    public void unionHelp(String s1,String s2){
       if(rank.get(s1)<rank.get(s2)){
           parent.put(s1,s2);
           
       }
        else if(rank.get(s1)>rank.get(s2)){
               parent.put(s2,s1);
        }
        else{
            parent.put(s1,s2);
            rank.put(s2,rank.get(s2)+1);
        }
    }
}