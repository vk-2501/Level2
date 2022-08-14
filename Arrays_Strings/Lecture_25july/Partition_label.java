package Arrays_Strings.Lecture_25july;

public class Partition_label {
    class Solution {
        public List<Integer> partitionLabels(String s) {
            List<Integer> al=new ArrayList<>();
            
            
            int[] fmap=new int[26];
            Arrays.fill(fmap,-1);
            for(int i=0;i<s.length();i++){
                char ch=s.charAt(i);
                fmap[ch-'a']=i;
            }
            
            int b=0,e=0;
            
           for(int i=0;i<s.length();i++){
               char c=s.charAt(i);
               
               e=Math.max(e,fmap[c-'a']);
               
               if(i==e){
                   al.add(e-b+1);
                   e=b=i+1;
               }
               
               
               
           }
            
            return al;
            
        }
    }
}
