package vk.Real;
import vk.Singleton.kunal;

public class hello extends kunal {
    hello(int n,int r){
        super(n,r);
    }
        
    
  /**
 * @param args
 */
public static void main(String[] args){
        hello hel=new hello(34,23);
        System.out.println(hel.num);
  }
}
