// Given an m x n matrix mat, return an array of all the elements of the array in a diagonal order.

// Example 1:
// Input: mat = [[1,2,3],[4,5,6],[7,8,9]]
// Output: [1,2,4,7,5,3,6,8,9]

// Example 2:
// Input: mat = [[1,2],[3,4]]
// Output: [1,2,3,4]
 
// Constraints:
// m == mat.length
// n == mat[i].length
// 1 <= m, n <= 104
// 1 <= m * n <= 104
// -105 <= mat[i][j] <= 105

class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int R = mat.length, C = mat[0].length, ptr = 0, N = R*C;
        int res[] = new int[N];
        boolean flag = true;
        int row = 0, col = 0;

        while(ptr < N){
            res[ptr++] = mat[row][col];
            if(flag){       // to sky
                if(row-1 >= 0 && col+1 < C){
                    row--;
                    col++;
                }
                else if(col+1 < C){
                    flag = !flag;
                    col++;
                }
                else{
                    flag = !flag;
                    row++;
                }
            }
            else{   // to earth
                if(row+1 < R && col-1 >= 0){
                    row++;
                    col--;
                }  
                else if(row+1 < R){
                    row++;
                    flag = !flag;
                }
                else{
                    flag = !flag;
                    col++;
                }
            }
        }
        
        return res;
    }
}