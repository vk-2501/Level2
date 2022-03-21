// Minimum Number of Steps to Make Two Strings Anagram

class Solution {
    public int minSteps(String s, String t) {
        HashMap<Character,Integer> hm=new HashMap<>();
        for(char ch:s.toCharArray()){
            hm.put(ch,hm.getOrDefault(ch,0)+1);
        }
        
        	for(char ch:t.toCharArray()){
		    if(hm.containsKey(ch)){
		        if(hm.get(ch)==1)
		        hm.remove(ch);
		        else
		        hm.put(ch,hm.getOrDefault(ch,0)-1);
		    }
		}
        
        	   	int sum=0;
		for(char ch:hm.keySet()){
            int a =hm.get(ch);
            sum+=a;
		}
        
        return sum;
    }
}
