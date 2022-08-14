package Arrays_Strings.Lecture_27_july;

class Solution {
    public String pushDominoes(String dominoes) {
        dominoes="L"+dominoes+"R";
        char[] arr=dominoes.toCharArray();
        
        int pi=0;
        for(int i=1;i<arr.length;i++){
            char ch=arr[i];
            
            if(ch=='L'){
                if(arr[pi]=='L'){
                    for(int idx=pi+1;idx<i;idx++){
                        arr[idx]='L';
                    }
                
                }
                else if(arr[pi]=='R'){
                    int lo=pi+1;
                    int hi=i-1;
                    while(lo<hi){
                        arr[lo]='R';
                        arr[hi]='L';
                        lo++;
                        hi--;
                    }
                }
                pi=i;
            }
            else if(ch=='R'){
                 if(arr[pi]=='L'){
                    //do nothing
                }
                else if(arr[pi]=='R'){
                    for(int idx=pi+1;idx<i;idx++){
                        arr[idx]='R';
                    }
                }
                pi=i;
            }
            
            
        }
        
        StringBuilder sb=new StringBuilder();
        for(int i=1;i<arr.length-1;i++){
            sb.append(arr[i]);
        }
        
        return sb.toString();
        
    }
    
    
    
}
