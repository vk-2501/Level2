public static class MinStack {
    Stack<Integer> allData;
    Stack<Integer> minData;

    public MinStack() {
      allData = new Stack<>();
      minData = new Stack<>();
    }package Stacks_Queues;
    
    public class MinStack {
        
    }
    


    int size() {
      // write your code here  
      return allData.size();
    }

    void push(int val) {
      // write your code here
      allData.push(val);
      if(minData.size()==0 || val<=minData.peek()){
        minData.push(val);
      }
    }

    int pop() {
      // write your code here
         if(size()==0){
  	      System.out.println("Stack underflow");
  	      return -1;
  	  }
  	  else{
  	      int val=allData.pop();
  	      if(minData.peek()==val){
  	          minData.pop();
  	      }
  	      return val;
  	  }
    }

    int top() {
      // write your code here
       if(size()==0){
  	      System.out.println("Stack underflow");
  	      return -1;
  	  }
  	  else{
  	      return allData.peek();
  	  }
    }

    int min(){
  	  // write your code here
  	  if(size()==0){
  	      System.out.println("Stack underflow");
  	      return -1;
  	  }
  	  else{
  	      return minData.peek();
  	  }
    }
  }