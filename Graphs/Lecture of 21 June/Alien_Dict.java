
// https://practice.geeksforgeeks.org/problems/alien-dictionary/1/
import java.util.*;

public class Alien_Dict {
    class Solution
{
    //Approach
    // Step1=> make a graph 
    // Step2=> compare the two words if you got mismatched characters in these two words
    //         then add first mismatched  character  of second word in neighbours of first word
    // Step3=> Now apply topological Sort in the graph and make the answer        
    public String findOrder(String [] dict, int N, int K)
    {
        // Write your code here
        ArrayList<Integer>[] graph=new ArrayList[K];
        for(int i=0;i<K;i++){
            graph[i]=new ArrayList<>();
        }
        
        //Compare the characters
        for(int i=0;i<dict.length-1;i++){
            String w1=dict[i];
            String w2=dict[i+1];
            
            for(int j=0;j<Math.min(w1.length(),w2.length());j++){
                char ch1=w1.charAt(j);
                char ch2=w2.charAt(j);
                
                if(ch1!=ch2){
                    graph[ch1-'a'].add(ch2-'a');
                    break;
                }
            }
        }
        
        //Applying Topsort
        Stack<Integer> st=new Stack<>();
        boolean[] vis=new boolean[K];
        for(int v=0;v<K;v++)
        {
            if(vis[v]==false){
                topSort(graph,vis,v,st);
            }
        }
        
        
        String ans="";
        while(st.size()>0){
            char ch=(char)(st.pop()+'a');
            ans+=ch;
        }
        
        return ans;
    }
    
    public static void topSort(ArrayList<Integer>[] graph,boolean[] vis,int v,Stack<Integer> st){
        
        vis[v]=true;
        for(int n:graph[v]){
            if(!vis[n]){
                topSort(graph,vis,n,st);
            }
        }
        
        st.push(v);


        
    }
    
    
    
    
    
}    
}
