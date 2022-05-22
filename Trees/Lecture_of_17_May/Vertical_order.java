package Trees.Lecture_of_17_May;


public class Vertical_order {
    class Solution {
        public class Pair implements Comparable<Pair>{
            TreeNode node;
            int h;
            int v;
            
            Pair(TreeNode node,int h,int v){
                this.node=node;
                this.h=h;
                this.v=v;
            }
            
            public int compareTo(Pair other){
                if(this.v==other.v){
                    return this.node.val-other.node.val;
                }
                else{
                    return this.v-other.v;
                }
            }
        }
        public List<List<Integer>> verticalTraversal(TreeNode root) {
            Queue<Pair> que=new LinkedList<>();
            que.add(new Pair(root,0,1));
            
            int lmh=0;
            int rmh=0;
            HashMap<Integer,PriorityQueue<Pair>> map=new HashMap<>();
            
            while(!que.isEmpty()){
                Pair rem=que.remove();
                
                if(rem.h<lmh) lmh=rem.h;
                if(rem.h>rmh) rmh=rem.h;
                
                if(!map.containsKey(rem.h)){
                    map.put(rem.h,new PriorityQueue<>());
                    map.get(rem.h).add(rem);
                }
                else{
                   map.get(rem.h).add(rem); 
                }
                
                if(rem.node.left!=null){
                    que.add(new Pair(rem.node.left,rem.h-1,rem.v+1));
                }
                
                if(rem.node.right!=null){
                     que.add(new Pair(rem.node.right,rem.h+1,rem.v+1));
                }
                
            }
            
           List<List<Integer>> res=new ArrayList<>();
            for(int i=lmh;i<=rmh;i++){
                List<Integer> li=new ArrayList<>();
                PriorityQueue<Pair> pq=map.get(i);
                
                while(pq.size()>0){
                    Pair temp=pq.remove();
                    li.add(temp.node.val);
                }
                res.add(li);
            }
            
            return res;
        }
    }
}
