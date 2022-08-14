/*  https://www.geeksforgeeks.org/find-k-most-frequent-in-linear-time/

Try It link-> https://practice.geeksforgeeks.org/problems/top-k-frequent-elements-in-array/1/#

We can use hashmap+priorityQueue-> Klogd+d
           hashmap+ Arraylist of arraylist -> 0(N) */

           import java.util.*;
           
           class Solution {
            public int[] topK(int[] nums, int k) {
                // Code here
                HashMap<Integer,Integer> hm=new HashMap<>();
                for(int n:nums){
                    hm.put(n,hm.getOrDefault(n,0)+1);
                }
                
                ArrayList<ArrayList<Integer>> al=new ArrayList<>();
                for(int i=0;i<=nums.length;i++){
                    al.add(new ArrayList<Integer>());
                }
                
                for(int i=0;i<nums.length;i++){
                    int val=nums[i];
                    int f=hm.get(val);
                    if(f!=-1){
                        al.get(f).add(val);
                        hm.put(val,-1);
                    }
                }
                
                int count=0;
                int ans[]=new int[k];
                int idx=0;
                for(int i=nums.length;i>=0;i--){
                    ArrayList<Integer> all=al.get(i);
                    
                    if(all.size()==1 ){
                    for(int x:al.get(i)){
                        
                        ans[idx++]=x;
                        count++;
                        if(count==k){
                            return ans;
                        }
                    }
                    }
                    else{
                        Collections.sort(all);
                        Collections.reverse(all);
                           for(int x:all){
                        
                        ans[idx++]=x;
                        count++;
                        if(count==k){
                            return ans;
                        }
                    }
                        
                    }
                }
                
                return new int[]{};
                
            }
        }