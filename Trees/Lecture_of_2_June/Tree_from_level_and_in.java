
// https://practice.geeksforgeeks.org/problems/construct-tree-from-inorder-and-levelorder/1/
class GfG
{
    Node buildTree(int inord[], int level[])
    {
        //your code here
            HashMap<Integer,Integer> hm=new HashMap<>();
            for(int i=0;i<level.length;i++){
                hm.put(level[i],i);
            }
            Node root=helper(inord,hm,0,inord.length-1);
            return root;
    }
    
            Node helper(int[] in,HashMap<Integer,Integer> hm,int lo,int hi){
                if(lo>hi)
                return null;

            int minIdx=lo;
            for(int j=lo+1;j<=hi;j++){
                if(hm.get(in[j])<hm.get(in[minIdx])){
                    minIdx=j;//minidx is the idx of the root present in inorder array
                }
            }

            Node node=new Node(in[minIdx]);
            node.left=helper(in, hm, lo, minIdx-1);
            node.right=helper(in,hm,minIdx+1,hi);
            return node;
        }
    
   
}


