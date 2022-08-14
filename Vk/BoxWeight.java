public class BoxWeight {
    private int l;
    private int w;
    private int h;

    BoxWeight(int l,int w){
        this.l=l;
        this.w=w;
        this.h=2;
    }


    BoxWeight(){
        this.w=-1;
        this.l=-1;
        this.h=-1;
    }
    
    BoxWeight(int l,int w,int h){
        this.l=l;
        this.w=w;
        this.h=h;
    }
    
    BoxWeight(BoxWeight o){
        this.l=o.l;
        this.w=o.w;
        this.h=o.h;
    }

    public void print(){
        System.out.print(this.l+"@"+this.w+"@"+this.h);
    }
}

