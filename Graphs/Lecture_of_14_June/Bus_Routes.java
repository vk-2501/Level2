class Solution {
    public class Pair{
        int bus;
        int csf;
        
        Pair(int bus,int csf){
            this.bus=bus;
            this.csf=csf;
        }
    }
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if(source==target)
            return 0;
        
        ArrayDeque<Pair> q=new ArrayDeque<>();
        HashMap<Integer,ArrayList<Integer>> hm=new HashMap<>();
        
        //step1
        for(int bus=0;bus<routes.length;bus++){
            for(int stop:routes[bus]){
                if(hm.containsKey(stop)==false){
                    hm.put(stop,new ArrayList<>());
                }
                hm.get(stop).add(bus);
            }
        }
        
        //step2
        boolean[] visited=new boolean[routes.length];
        
        for(int bus:hm.get(source)){
            q.add(new Pair(bus,1));
        }
        
        while(q.size()>0){
            Pair rem=q.remove();
            
            if(visited[rem.bus]==true) continue;
            visited[rem.bus]=true;
            
            //work
            for(int rstop:routes[rem.bus]){
                if(rstop==target)
                    return rem.csf;
            }
            
            //add Nbr
            
            for(int rstop:routes[rem.bus]){
                for(int bus:hm.get(rstop)){
                    if(visited[bus]==false){
                        q.add(new Pair(bus,rem.csf+1));
                    }
                }
            }
        }
        
        return -1;
    }
}