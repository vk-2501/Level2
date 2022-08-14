import javafx.scene.Parent;

public class  Kruskal_Algo {
    public void kruskal(ArrayList<Edge>[] graph){
        PriorityQueue<Edge> pq=new PriorityQueue<>();
        for(int v=0;v<graph.length;v++){
            for(Edge e:graph[v]){
                pq.add(e);
            }
        }

        parents=new int[graph.length];
        rank=new int[graph.length];

        for(int i=0;i<graph.lenght;i++){
            parents[i]=i;
            rank[i]=0;
        }
        
        while(pq.size()>0){
            Edge rem=pq.remove();

            int srcLead=find(rem.src);
            int nbrLead=find(rem.nbr);

            if(srcLead!=nbrLead){
                System.out.println(rem.src+"@"+ rem.nbr);
                union(srcLead,nbrLead);
            }


        }
    }

    public static int find(int x){
        if(parents[x]==x)
        return x;
        else{
            int pofx=parents[x];
            int lead=find(pofx);
            
            //compression
            parents[x]=lead;

            return lead;
        }
    }

    public void union(int s1l,int s2l){
        if(rank[s1l]<rank[s2l]){
            parents[s1l]=s2l;
        }
        else if(rank[s1l]>rank[s2l]){
            parents[s2l]=s1l;
        }
        else{
            parents[s1l]=s2l;
            rank[s2l]++;
        }
    }

}
