package Stacks_Queues;
// Stack to queue add efficient
import java.util.*;
public class Stack_to_Queue_Add {
    public static class StackToQueueAdapter {
        Stack<Integer> mainS;
        Stack<Integer> helperS;
    
        public StackToQueueAdapter() {
          mainS = new Stack<>();
          helperS = new Stack<>();
        }
    
        int size() {
          // write your code here
          return  mainS.size();
        }
    
        void add(int val) {
          // write your code here
          mainS.push(val);
        }
    
        int remove() {
          // write your code here
            if(size()==0){
              System.out.println("Queue underflow");
              return -1;
              
          }
          else{
              while(mainS.size()>1){
                 helperS.push(mainS.pop());
              }
              int v=mainS.pop();
              
              while(helperS.size()>0){
                  mainS.push(helperS.pop());
              }
              return v;
          }
        }
    
        int peek() {
          // write your code here
          if(size()==0){
              System.out.println("Queue underflow");
              return -1;
              
          }
          else{
              while(mainS.size()>1){
                 helperS.push(mainS.pop());
              }
              int v=mainS.peek();
              
              while(helperS.size()>0){
                  mainS.push(helperS.pop());
              }
              return v;
          }
          
        }
      }
}
