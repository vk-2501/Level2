class Solution {
    HashMap<String,String> parent;
    HashMap<String,Double> mult;
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        parent=new HashMap<>();
        mult=new HashMap<>();
        
        //add karwa lo hashmaps mai
        // a-> a       a->1.0
        // b-> b       b->1.0
        //parent       mult 
        for(List<String> eq:equations){
            addToDsu(eq.get(0));
            addToDsu(eq.get(1));
        }
        
        int i=0;
        for(List<String> eq:equations){
            String l0=find(eq.get(0));
            String l1=find(eq.get(1));
            
           
                double m0=mult.get(eq.get(0));
                double m1=mult.get(eq.get(1));
                
                parent.put(l0,l1);
                mult.put(l0,(values[i]*m1)/m0);
                i++;
        }
        
        double res[]=new double[queries.size()];
        i=0;
        
        for(List<String> q:queries){
            String q0=q.get(0);
            String q1=q.get(1);
            if(parent.containsKey(q0)==false || parent.containsKey(q1)==false){
                res[i++]=-1;
                continue;
            }
           
            String l0=find(q.get(0));
            String l1=find(q.get(1));
            
            if(l0.equals(l1)==false){
                res[i++]=-1;
                continue;
            }
            
            double m0=mult.get(q0);
            double m1=mult.get(q1);
            
            res[i++]=m0/m1;
        }
        
        return res;
        
        
    }
    
    public void addToDsu(String x){
        if(parent.containsKey(x)==false){
            parent.put(x,x);
            mult.put(x,1.0);
        }
    }
    
    public String find(String x){
        if(parent.get(x).equals(x)){
            return x;
        }
        else{
            String curr=parent.get(x);
            String lead=find(curr);
            
            parent.put(x,lead);
            double currval=mult.get(curr);
            double myval=mult.get(x);
            
            mult.put(x,currval*myval);
                
            return lead;
        }
    }
    
    
}public class Evaluate_Division {
    
}
