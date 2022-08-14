// https://leetcode.com/problems/course-schedule-ii/

import java.util.*;

public class Course_Schedule {
    class Solution {
        public int[] findOrder(int numCourses, int[][] prerequisites) {
            ArrayList<Integer>[] graph=new ArrayList[numCourses];
            
            for(int v=0;v<numCourses;v++){
                graph[v]=new ArrayList<>();
            }
            
          for(int[] req:prerequisites){
              graph[req[0]].add(req[1]);
          }
            
            int[] topSort=new int[numCourses];
            
            int[] in=new int[numCourses];
            for(int v=0;v<numCourses;v++){
                for(int nbr:graph[v]){
                    in[nbr]++;
                }
            }
            
            ArrayDeque<Integer> q=new ArrayDeque<>();
            for(int v=0;v<numCourses;v++){
                if(in[v]==0){
                    q.add(v);
                }
            }
            
            int idx=topSort.length-1;
            while(q.size()>0){
                int rem=q.remove();
                topSort[idx--]=rem;
                
                for(int nbr:graph[rem]){
                    in[nbr]--;
                    if(in[nbr]==0){
                        q.add(nbr);
                    }
                }
            }
            
            if(idx==-1){
                return topSort ;
            }
            else
            return new int[] {};
        }
    }
}
