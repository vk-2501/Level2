package Stacks_Queues;
public static class CustomStack {
    int[] data;
    int tos;

    public CustomStack(int cap) {
      data = new int[cap];
      tos = -1;
    }

    int size() {
      return tos + 1;
    }

    void display() {
      for (int i = tos; i >= 0; i--) {
        System.out.print(data[i] + " ");
      }
      System.out.println();
    }

    // change the code of this function according to question
    void push(int val) {
      if (tos == data.length - 1) {
       int pp[]=new int[2*data.length];
       for(int i=0;i<data.length;i++){
           pp[i]=data[i];
       }
       data=pp;
       tos++;
       data[tos]=val;
      
      } else {
        tos++;
        data[tos] = val;
      }
    }