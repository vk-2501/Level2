// using HashMaps


class Solution {
    public List<Integer> findAnagrams(String s, String p) {
            ArrayList<Integer> al=new ArrayList<>();
        if(s.length()<p.length()){
            return al ;
        }
        HashMap<Character,Integer> phm=new HashMap<>();
        for(char ch:p.toCharArray()){
            phm.put(ch,phm.getOrDefault(ch,0)+1);
        }
        
          HashMap<Character,Integer> shm=new HashMap<>();
        for(int i=0;i<p.length();i++){
            shm.put(s.charAt(i),shm.getOrDefault(s.charAt(i),0)+1);
        }
        
        
        if(phm.equals(shm)){
            al.add(0);
        }
        
        int j=0;
        for(int i=p.length();i<s.length();i++){
            //acquire
             shm.put(s.charAt(i),shm.getOrDefault(s.charAt(i),0)+1);
            
            //release
            if(shm.get(s.charAt(j))==1){
                shm.remove(s.charAt(j));
            }
            else{
             shm.put(s.charAt(j),shm.getOrDefault(s.charAt(j),0)-1);
            }
           
            if(phm.equals(shm)){
            al.add(j+1);
        }
            j++;
            
        }
     
        return al;
        
    }
    
 
}
