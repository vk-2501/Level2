class Solution
{
    public void shortest_distance(int[][] matrix)
    {
        // Code here 
        for(int k=0;k<matrix.length;k++){
            for(int i=0;i<matrix.length;i++){
                for(int j=0;j<matrix.length;j++){
                    if(matrix[i][k]==-1) continue;
                    else if(matrix[k][j]==-1) continue;
                    else if(matrix[i][j]==-1){
                        matrix[i][j]=matrix[i][k]+matrix[k][j];
                    }
                    else{
                         matrix[i][j]=Math.min(matrix[i][j],matrix[i][k]+matrix[k][j]);
                    }
                }
            }
        }
    }
}