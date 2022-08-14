public class AVL {
    public static class Node{
        int data;
        Node left;
        Node right;

        int ht=1;
        int bal=0;

        Node(int data){
            this.data=data;
        }

        Node(){

        }
    }

    public static Node construct(int[] arr){
        return construct_tree(arr,0,arr.length-1);
    }

    public static Node construct_tree(int[] arr,int lo,int hi){
        if(lo>hi) return null;
        int mid=(lo+hi)/2;

        Node node=new Node(arr[mid]);
        node.left=construct_tree(arr, lo, mid-1);
        node.right=construct_tree(arr, mid+1, hi);

        node.ht=getHeight(node);
        node.bal=getBal(node);

        return node;
    }

    public static int getHeight(Node node){
        int lh=node.left!=null?node.left.ht:0;
        int rh=node.right!=null?node.right.ht:0;
        return Math.max(lh+rh)+1;
    }

    public static int getBal(Node node){
        int lh=node.left!=null?node.left.ht:0;
        int rh=node.right!=null?node.right.ht:0;
        return lh-rh;
    }


}
