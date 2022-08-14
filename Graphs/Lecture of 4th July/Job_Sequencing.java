// https://practice.geeksforgeeks.org/problems/job-sequencing-problem-1587115620/1

public class Job_Sequencing {
    class Solution
{
    //Function to find the maximum profit and the number of jobs done.
    int[] parent;
    int[] JobScheduling(Job arr[], int n)
    {
        // Your code here
        Arrays.sort(arr,(a,b)->{
            return b.profit-a.profit;
        });
        parent=new int [101];
        for(int i=0;i<parent.length;i++){
            parent[i]=i;
        }
        int pro=0;
        int c=0;
        
        for(Job j:arr){
            int empty=find(j.deadline);
            
            if(empty>0){
            pro+=j.profit;
            c++;
            
            parent[empty]=find(empty-1);
            }
        }
        return new int[]{c,pro};
        
    }
    
    public int find(int x){
        if(parent[x]==x){
            return x;
        }
        else{
            parent[x]=find(parent[x]);
            
            return parent[x];
        }
    }
}  
}
