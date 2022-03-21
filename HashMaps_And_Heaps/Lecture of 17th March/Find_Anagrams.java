//using array freq map

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
     ArrayList<Integer> al=new ArrayList<>();
        if(s.length()<p.length())
            return al;
            int[] map1=new int[26];
        for(int i=0;i<p.length();i++){
            char ch=p.charAt(i);
            map1[ch- 'a']++;
        }
        
        //acquire till p.length
          int[] map2=new int[26];
        for(int i=0;i<p.length();i++){
            char ch=s.charAt(i);
            map2[ch-'a']++;
        }

        if(areAnagrams(map1,map2)){
            al.add(0);
        }
        
        //acquire and release
        int j=0;
        for(int i=p.length();i<s.length();i++){
            //acquire
            char chh=s.charAt(i);
            map2[chh-'a']++;
            
            
            //release
            
            char chh1=s.charAt(j);
            if(map2[chh1-'a']>0)
            map2[chh1-'a']--;
            
             if(areAnagrams(map1,map2)){
            al.add(j+1);
        }
            j++;
        }
     
     
        return al;
        
    }
    
    public boolean areAnagrams(int[] map1,int[] map2){
        for(int i=0;i<26;i++){
            if(map1[i]!=map2[i])
                return false;
        }
        return true;
    }
}


