import java.util.*;

public class Main {
	public static int[] anagramMappings(int[] arr1, int[] arr2) {
		// write your code here
		int[] ans=new int[arr1.length];
        HashMap<Integer,ArrayDeque<Integer>> hm=new HashMap<>();
        
        for(int i=0;i<arr2.length;i++){
            int val=arr2[i];
            if(hm.containsKey(val)){
             hm.get(val).add(i);
            }
            else{
                ArrayDeque<Integer> q=new ArrayDeque<>();
                q.add(i);
                hm.put(val,q);
            }
            
        }
        
        for(int i=0;i<arr1.length;i++){
           
                ans[i]=hm.get(arr1[i]).remove();
                
            
        }
        
        return ans;
		
		
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int[] a = new int[n];
		int[] b = new int[n];
		for (int i = 0; i < a.length; i++) {
			a[i] = s.nextInt();
		}
		for (int j = 0; j < b.length; j++) {
			b[j] = s.nextInt();
		}
		int[] res = anagramMappings(a, b);
		for (int j = 0; j < res.length; j++) {
			System.out.print(res[j] + " ");
		}
	}

}

