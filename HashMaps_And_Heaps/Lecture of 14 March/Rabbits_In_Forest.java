// There is a forest with an unknown number of rabbits. We asked
//  n rabbits "How many rabbits have the same color as you?" and collected the 
// answers in an integer array answers where answers[i] is the answer of the ith rabbit.

// Given the array answers, return the minimum number of rabbits
//  that could be in the forest.



class Solution {
    public int numRabbits(int[] answers) {
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(int val:answers){
            hm.put(val,hm.getOrDefault(val,0)+1);
        }
        
        int ans=0;
        for(int key:hm.keySet()){
            int nor=key+1;
            int nop=hm.get(key);
            
            int count=(int)Math.ceil(nop*1.0/nor*1.0);
            int tot=count*nor;
            
            ans+=tot;
        }
        
        return ans;
    }
}