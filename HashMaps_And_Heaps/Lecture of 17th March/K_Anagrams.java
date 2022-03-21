import java.util.*;

public class Main {
	public static boolean areKAnagrams(String str1, String str2, int k) {
	    
	    if(str1.length()!=str2.length())
	    return false;
		HashMap<Character,Integer> hm=new HashMap<>();
		for(char ch:str1.toCharArray()){
		    hm.put(ch,hm.getOrDefault(ch,0)+1);
		}
		
		for(char ch:str2.toCharArray()){
		    if(hm.containsKey(ch)){
		        if(hm.get(ch)==1)
		        hm.remove(ch);
		        else
		        hm.put(ch,hm.getOrDefault(ch,0)-1);
		    }
		}
		    
		   	int s=0;
		for(char ch:hm.keySet()){
            int a =hm.get(ch);
            s+=a;
		}
		    if(s<=k)
		    return true;
		    else
		    return false;
		
	}

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		String str1 = s.next();
		String str2 = s.next();
		int k = s.nextInt();
		System.out.println(areKAnagrams(str1, str2, k));

	}

}

