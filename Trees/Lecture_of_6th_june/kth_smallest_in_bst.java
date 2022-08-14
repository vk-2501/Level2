public class kth_smallest_in_bst {
    public int kth_smallest(Node root,int k){
        int count=0;
        Node curr=root;
        while(curr!=null){
            if(curr.left==null){
                //print
                count++;
                if(count==k){
                    return root.val;
                }

                curr=curr.right;
            }
            else{
                Node iop=curr.left;
                while(iop.right!=null && iop.right!=curr){
                    iop=iop.right;
                }

                if(iop.right==null){
                    //make a thread
                    iop.right=curr;
                    curr=curr.left;
                }
                else{
                    iop.right=null;
                    //print
                    
                    count++;
                    if(count==k){
                        return root.val;
                    }
                    curr=curr.right;
                }
            }
        }
        return -1;
    }
}
