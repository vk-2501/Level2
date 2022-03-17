// In a deck of cards, each card has an integer written on it.

// Return true if and only if you can choose X >= 2 such that it is possible to split the entire deck into 1 or more groups of cards, where:

// Each group has exactly X cards.
// All the cards in each group have the same integer.


class Solution {
    public boolean hasGroupsSizeX(int[] deck) {
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(int val:deck){
            hm.put(val,hm.getOrDefault(val,0)+1);
        }
        
        int counter=0;
        int gcd=1;
        
        for(int key:hm.keySet()){
            if(counter==0){
                gcd=hm.get(key);
            }
            else{
                int num=hm.get(key);
                gcd=GCD(gcd,num);
            }
            counter++;
        }
        
        return gcd>=2;
    }
    
    
    public int GCD(int n1,int n2)
    {
        while(n1%n2!=0){
            int rem=n1%n2;
            n1=n2;
            n2=rem;
            
        }
        
        return n2;
    }
}