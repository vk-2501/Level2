package Arrays_Strings.Lecture_of_5th_Aug;

public class painters_problem {
    https://practice.geeksforgeeks.org/problems/the-painters-partition-problem1535/1
    static long minTime(int[] arr,int n,int k){
        //code here
        long lta=Long.MIN_VALUE;
        long hta=0;
        for(int v:arr){
            hta+=v;
            lta=Math.max(lta,v);
        }
        
        while(lta<hta){
            long mid=(lta+hta)/2;
            
            long paintersReq=1;
            long painterSum=0;
            for(int v:arr){
                if(v+painterSum<=mid){
                    painterSum+=v;
                }
                else{
                    painterSum=v;
                    paintersReq++;
                }
            }
            
            if(paintersReq>k){
                lta=mid+1;
            }
            else{
                hta=mid;
            }
        }
        
        return lta;
    }
}
}
