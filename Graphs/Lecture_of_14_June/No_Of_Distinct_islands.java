public static int numDistinctIslands(int[][] arr) {
    HashSet<String> hs=new HashSet<>();
   boolean[][] visited=new boolean[arr.length][arr[0].length];
   for(int i=0;i<arr.length;i++){
       for(int j=0;j<arr[0].length;j++){
           if(visited[i][j]==false && arr[i][j]==1){
           psf=new StringBuilder();
           help(arr,i,j,visited);
           hs.add(psf.toString());
           }
       }
   }
    return hs.size();
  }
  
  public static void help(int[][] arr,int i,int j,boolean[][] visited){
      visited[i][j]=true;
      
      if((i-1)>=0 && arr[i-1][j]==1 && visited[i-1][j]==false){
          psf.append("N");
          help(arr,i-1,j,visited);
      }
      
      
      if((j-1)>=0 && arr[i][j-1]==1 && visited[i][j-1]==false){
          psf.append("W");
          help(arr,i,j-1,visited);
      }
      
      
      if((i+1)<arr.length && arr[i+1][j]==1 && visited[i+1][j]==false){
          psf.append("S");
          help(arr,i+1,j,visited);
      }
      
         if((j+1)<arr[0].length && arr[i][j+1]==1 && visited[i][j+1]==false){
          psf.append("E");
          help(arr,i,j+1,visited);
      }
      
      psf.append("b");
      
  }