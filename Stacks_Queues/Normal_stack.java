public static class CustomStack{
    int[] data;
    int tos;

    public CustomStack(int cap){
        data=new int[cap];
        tos=-1;
    }

    int size() {
        // write ur code here
        return tos+1;
      }
  
      void display() {
        // write ur code here
        for(int i=tos;i>=0;i--){
            System.out.print(data[i]+"");
        }
        System.out.println();
      }
  
      void push(int val) {
        // write ur code here
        if(tos==data.length-1){
            System.out.println("Stack Overflow");
            return;
        }
        else{
            tos++;
            data[tos]=val;
        }
      }
  
      int pop() {
        // write ur code here
        if(tos==-1){
            System.out.println("Stack Underflow");
            return -1;
        }
        else{
            int val=data[tos];
            data[tos]=0;
            tos--;
            return val;
        }
      }
  
      int top() {
         // write ur code here
         if(tos==-1){
            System.out.println("Stack Underflow");
            return -1;
        }
        else{
            int val=data[tos];
            return val;
        }
      }
}