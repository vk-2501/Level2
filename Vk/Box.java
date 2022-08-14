public class Box extends BoxWeight {
    int weight;
   

    Box(int l,int w,int h,int weight){
        super(l,w,h);
        this.weight=weight;

    }

    Box(Box o){
        super(o);//This is equivalent to BoxWeight o=new Box();  so reference type will be decided by BoxWeight
        this.weight=o.weight;
    }

    public void print2(){
        System.out.print("@"+this.weight);
    }

  

    public static void main(String[] args){
      
        Box b1=new Box(2,3,5,5);
        Box b2=new Box(b1);

        b2.print();
        b2.print2();

    }
}
