// https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/graphs/sentence_similarity_official/ojquestion



public class Sentence_similarity{
     static HashMap<String,String> parent;
    static HashMap<String,Integer> rank;
    
  public static boolean areSentencesSimilarTwo(String[] Sentence1, String[] Sentence2, String[][] pairs) {
      parent=new HashMap<>();
      rank=new HashMap<>();
      
      //intializing
      for(int i=0;i<pairs.length;i++){
        if(parent.containsKey(pairs[i][0])==false){
            parent.put(pairs[i][0],pairs[i][0]);
            rank.put(pairs[i][0],0);
        }
        
        if(parent.containsKey(pairs[i][1])==false){
            
            parent.put(pairs[i][1],pairs[i][1]);
            rank.put(pairs[i][1],0);
        }
      }
      
      //union karte hain leads ko set karte hain
      for(int i=0;i<pairs.length;i++){
          String s1=pairs[i][0];
          String s2=pairs[i][1];
          
          String s1L=find(s1);
          String s2L=find(s2);
          
          if(!s1L.equals(s2L)){
            union(s1L,s2L); 
          }
          
      }
      
      if(Sentence1.length!=Sentence2.length){
          return false;
      }
      
      for(int i=0;i<Sentence1.length;i++){
          String s1=Sentence1[i];
          String s2=Sentence2[i];
          
          if(s1.equals(s2)){
              continue;
          }
          else if(parent.containsKey(s1) == false  || parent.containsKey(s2) == false){
              return false;
          }
          
          String s1f=find(s1);
          String s2f=find(s2);
          
          if(s1f.equals(s2f)==false){
            return false;
          }
          
      }
      
      return true;
      

  }
  
  public static String find(String x){
      if(parent.get(x).equals(x)){
          return x;
      }
      else{
          String pox=parent.get(x);
          String setLead=find(pox);
          
          parent.put(x,setLead);
          
          return setLead;
      }
  }
  
  
  public static void union(String x,String y){
      if(rank.get(x)<rank.get(y)){
        parent.put(x,y);
      }
      else if(rank.get(x)>rank.get(y)){
        parent.put(y,x);
      }
      else{
        parent.put(x,y);
        rank.put(y,rank.get(y)+1);
      }
  }
  
  
  
  
  
  
}