// Write an efficient algorithm that searches for a value target in an m x n integer matrix matrix. 
// This matrix has the following properties:
// Integers in each row are sorted in ascending from left to right.
// Integers in each column are sorted in ascending from top to bottom.
 
// Example 1:
// Input: matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 5
// Output: true

// Example 2:
// Input: matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 20
// Output: false
 
// Constraints:
// m == matrix.length
// n == matrix[i].length
// 1 <= n, m <= 300
// -109 <= matrix[i][j] <= 109
// All the integers in each row are sorted in ascending order.
// All the integers in each column are sorted in ascending order.
// -109 <= target <= 109

class Solution {
    public boolean searchMatrix(int[][] mat, int target) {
        int R = mat.length, C= mat[0].length;
        int i = R-1, j = 0;
        while(i >= 0 && j < C){
            if(mat[i][j] == target)
                return true;
            else if(mat[i][j] > target)
                i--;
            else
                j++;         
        }
        return false;
    }
}

class Solution2 {
    public boolean searchMatrix(int[][] mat, int target) {
        int R = mat.length, C= mat[0].length;
        
        for(int i=0; i<R; i++){
            int left = 0, right = C-1; 

            while(left <= right){
                int mid = (left + right)/2;
                
                if(mat[i][mid] == target)
                    return true;
                else if(mat[i][mid] < target)
                    left = mid + 1;
                else
                    right = mid - 1;    
            }
                
        }
        return false;
    }
}