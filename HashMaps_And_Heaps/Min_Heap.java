public static class PriorityQueue {
    ArrayList<Integer> data;

    public PriorityQueue() {
      data = new ArrayList<>();
    }

    public void add(int val) {
      // write your code here
      data.add(val);
      upheapify(data.size()-1);
      
    }
    
    public class Min_Heap {
        
    }
     void upheapify(int i){
        if(i==0)
        return;
        int pi=(i-1)/2;
        while(data.get(pi)>data.get(i)){
            swap(pi,i);
            upheapify(pi);
        }
    }
    
    public void swap(int i,int j){
        int t1=data.get(i);
        int t2=data.get(j);
        data.set(i,t2);
        data.set(j,t1);
    }

    public int remove() {
      // write your code here
        if(data.size()==0){
          System.out.println("Underflow");
          return -1;
      }
      
      swap(0,data.size()-1);
      int val=data.remove(data.size()-1);
      downheapify(0);
      return val;
    }
    
    void downheapify(int i){
        
        int mini=i;
        
        int lci=2*i+1;
        int rci=2*i+2;
        if(lci<data.size() && data.get(lci)<data.get(mini)){
            mini=lci;
        }
        
        if(rci<data.size() && data.get(rci)<data.get(mini)){
            mini=rci;
        }
        
        if(mini!=i){
            swap(mini,i);
            downheapify(mini);
        }
    }
    public int peek() {
      // write your code here
      if(data.size()==0){
          System.out.println("Underflow");
          return -1;
      }
      return data.get(0);
    }

    public int size() {
      // write your code here
      
      return data.size();
    }
  }