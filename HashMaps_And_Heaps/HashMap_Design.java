import java.util.LinkedList;

public class HashMap<K,V>{
    private class HMNode {
        K key;
        V value;

        HMNode(K key,V value){
            this.key=key;
            this.value=value;
        }
    }

    private int size;
    private LinkedList<HMNode> buckets[];

    
    public HashMap(){
        initBuckets(4);
        size=0;
    }

    private void initBuckets(int n){
        buckets=new LinkedList[n];
        for(int i=0;i<buckets.length;i++){
            buckets[i]=new LinkedList<HMNode>();
        }
    }

    public void put(K key,V value){
        int bi=hashfn(key);
        int di=getIndexWithin(key,bi);//data index

        if(di==-1){
            //insert
            HMNode node=new HMNode(key,value);
            buckets[bi].add(node);
            size++;
        }
        else{
            //update
            HMNode node=buckets[bi].get(di);
            node.value=value;
        }

        //have to handle lamda= n/N where n=no of total nodes and N is no of buckets , lamda<=K
        double lamda=size*1.0/buckets.length;
        if(lamda>2.0){
            //Rehashing-> it will create a bucket array of length double than old bucket length 
            rehashing();

        }
    }

    public void rehashing(){
        LinkedList<HMNode> old[]=buckets;
        initBuckets(old.length*2);
        size=0;
        for(int i=0;i<old.length;i++){
            for(HMNode node:old[i]){
                put(node.key,node.value);
            }
        }

    }

    public int hashfn(K key){
        int hc=key.hashCode();
        return Math.abs(hc)%buckets.length;
    }

    public int getIndexWithin(K key,int bi){
        int di=0;
        for(HMNode node:buckets[bi]){
            if(node.key.equals(key)){
                return di;
            }
            di++;
        }
        return -1;
    }

    public V get(K key){
        int bi=hashfn(key);//bucket index
        int di=getIndexWithin(key,bi);//data index

        if(di==-1){
            return null;
        }
        else{
            HMNode node=buckets[bi].get(di);
            return node.value;
        }

    }

    public boolean containsKey(K key,V value){
        int bi=hashfn(key);//bucket index
        int di=getIndexWithin(key,bi);//data index

        if(di==-1){
            return false;
        }
        else{
          return true;
        }
    }

    public ArrayList<k> keySet() throws Exception{
        ArrayList<k> ans=new ArrayList<>();
        for(int i=0;i<buckets.length;i++){
            for(HMNode node:buckets[i]){
                ans.add(node.key);
            }
        }
        return ans;
    }

    public V remove(K key){
        int bi=hashfn(key);//bucket index
        int di=getIndexWithin(key,bi);//data index

        if(di==-1){
            return null;
        }
        else{
            HMNode node=buckets[bi].remove(di);
            size--;
            return node.value;
        }

    }

    public int size(){
        return this.size;
    }
}