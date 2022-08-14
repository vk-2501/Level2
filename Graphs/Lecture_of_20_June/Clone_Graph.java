package Lecture_of_20_June;

public class Clone_Graph {
    class Solution {
        public Node cloneGraph(Node node) {
            if(node==null) return null;
            HashMap<Integer,Node> hm=new HashMap<>();
            return help(node,hm);
        }
        
        public Node help(Node node,HashMap<Integer,Node> visited){
            Node nodeClone=new Node(node.val);
            visited.put(node.val,nodeClone);
            
            for(Node nbr:node.neighbors){
                if(visited.containsKey(nbr.val)==false){
                    Node nbrClone=help(nbr,visited);
                    nodeClone.neighbors.add(nbrClone);
                }
                else{
                    Node nbrClone=visited.get(nbr.val);
                    nodeClone.neighbors.add(nbrClone);
                }
            }
            return nodeClone;
        }
    }
}
