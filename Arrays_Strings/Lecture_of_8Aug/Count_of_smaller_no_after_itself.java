class Solution {
    int[] res;
    class Pair{
        int idx;
        int val;
        
        Pair(int idx,int val){
            this.idx=idx;
            this.val=val;
        }
    }
    public List<Integer> countSmaller(int[] nums) {

        Pair[] pair=new Pair[nums.length];
        for(int i=0;i<nums.length;i++){
            pair[i]=new Pair(i,nums[i]);
        }
        res=new int[nums.length];
        ArrayList<Integer> ans=new ArrayList<>();
      
        
        mergeSort(pair,0,pair.length-1);
          for(int v:res){
            ans.add(v);
        }
        return ans;
        
    }
    
    public Pair[] mergeSort(Pair[] pair,int lo,int hi){
        if(lo==hi){
            Pair[] bp=new Pair[1];
            bp[0]=new Pair(pair[lo].idx,pair[lo].val);
            return bp;
        }
        int mid=(lo+hi)/2;
        Pair[] fh=mergeSort(pair,lo,mid);
        Pair[] sh=mergeSort(pair,mid+1,hi);
        Pair[] merge=merge2(fh,sh);
        return merge;
        
    }
    
    public Pair[] merge2(Pair[] fh,Pair[] sh){
        Pair[] ansPair=new Pair[fh.length+sh.length];
        int i=0;
        int j=0;
        int k=0;
        while(i<fh.length && j<sh.length){
            if(fh[i].val>sh[j].val){
                 ansPair[k]=fh[i];
                  res[fh[i].idx]+=(sh.length-j);
                    i++;
                    k++;
                
            }
            else{
                  ansPair[k]=sh[j];
                    j++;
                    k++;
            }
        }
        
        while(i<fh.length){
            ansPair[k]=fh[i];
            i++;
            k++;
        }
        
        while(j<sh.length){
            ansPair[k]=sh[j];
            j++;
            k++;
        }
        
        return ansPair;
    }package Arrays_Strings.Lecture_of_8Aug;
    
    public class Count_of_smaller_no_after_itself {
        
    }
    
}