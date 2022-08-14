public class Serialise_Deserialise {
    /**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null)
            return "";
        StringBuilder sb=new StringBuilder();
        help(root,sb);
        return sb.toString();
    }
    
    public void help(TreeNode root,StringBuilder sb){
        
        if(root==null){
            sb.append(".");
            sb.append(" ");
            return;
        }
        sb.append(root.val);
        sb.append(" ");
        
        help(root.left,sb);
        help(root.right,sb);
        
    }
    
    class Pair{
        TreeNode node;
        int state=0;
    }
   

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
     if(data.length()==0) return null;
        
        String arr[]=data.split(" ");
        Stack<Pair> st=new Stack<>();
        Pair rootp=new Pair();
        rootp.node=new TreeNode(Integer.parseInt(arr[0]));
        st.push(rootp);
        
        int idx=1;
        while(st.size()>0){
            Pair rem=st.peek();
            if(rem.state==0){
                if(arr[idx].equals(".")==false){
                    Pair leftp=new Pair();
                    leftp.node=new TreeNode(Integer.parseInt(arr[idx]));
                    st.push(leftp);
                    rem.node.left=leftp.node;
                }
                idx++;
                rem.state++;
            }
            else if(rem.state==1){
                   if(arr[idx].equals(".")==false){
                    Pair rightp=new Pair();
                    rightp.node=new TreeNode(Integer.parseInt(arr[idx]));
                    st.push(rightp);
                    rem.node.right=rightp.node;
                }
                idx++;
                
                rem.state++;
                
            }
            else{
                st.pop();
            }
        }
        
        
        
        
        
        return rootp.node;
        
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
}
