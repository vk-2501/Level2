// https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/arrays-and-strings/best-meeting-point/ojquestion#!

public static int minTotalDistance(int[][] grid) {
    // Write your code here
    ArrayList<Integer> rows=new ArrayList<>();
    for(int i=0;i<grid.length;i++){
        for(int j=0;j<grid[i].length;j++){
            if(grid[i][j]==1){
                rows.add(i);
            }
        }
    }
    
    ArrayList<Integer> cols=new ArrayList<>();
    for(int j=0;j<grid[0].length;j++){
        for(int i=0;i<grid.length;i++){
            if(grid[i][j]==1){
                cols.add(j);
            }
        }
    }
    
    int r=rows.get(rows.size()/2);
    int c=cols.get(cols.size()/2);
    
    int d1=0;
    for(int rt:rows){
        d1+=Math.abs(rt-r);
    }
    
    int d2=0;
    for(int rt:cols){
        d2+=Math.abs(rt-c);
    }
    
    return d1+d2;
}