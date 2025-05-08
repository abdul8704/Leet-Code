// A peak element in a 2D grid is an element that is strictly greater than all of its adjacent neighbors to the left, right, top, and bottom.
// Given a 0-indexed m x n matrix mat where no two adjacent cells are equal, find any peak element mat[i][j] and return the length 2 array [i,j].
// You may assume that the entire matrix is surrounded by an outer perimeter with the value -1 in each cell.
// You must write an algorithm that runs in O(m log(n)) or O(n log(m)) time.

// Example 1:
// Input: mat = [[1,4],[3,2]]
// Output: [0,1]
// Explanation: Both 3 and 4 are peak elements so [1,0] and [0,1] are both acceptable answers.

// Example 2:
// Input: mat = [[10,20,15],[21,30,14],[7,16,32]]
// Output: [1,1]
// Explanation: Both 30 and 32 are peak elements so [1,1] and [2,2] are both acceptable answers.
 
// Constraints:
// m == mat.length
// n == mat[i].length
// 1 <= m, n <= 500
// 1 <= mat[i][j] <= 105
// No two adjacent cells are equal.

class Solution { // kind of brute force solution with Time complexity: O(m*n), Space complexity: O(1)
    public int[] findPeakGrid(int[][] mat) {
        int R = mat.length, C = mat[0].length;
        int i=0, j=0;

        while(true){
            if(i-1 >=0 && mat[i-1][j] > mat[i][j])
                i--;
            else if(i+1 < R && mat[i+1][j] > mat[i][j])
                i++;
            else if(j-1 >= 0 && mat[i][j-1] > mat[i][j])
                j--;
            else if(j+1 < C && mat[i][j+1] > mat[i][j])
                j++;
            else
                return new int[]{i, j};   
        }
    }
}

class BinarySearchSolution { // Time complexity: O(m*log(n)), Space complexity: O(1)
    public int[] findPeakGrid(int[][] mat) {
        int R = mat.length, C = mat[0].length;
        int left = 0, right = R-1;

        while(left <= right){
            int mid = (left + right) / 2;
            int maxCol = findCol(mat, mid, R, C);

            int up = (mid-1 >= 0) ? mat[mid-1][maxCol]: -1;
            int down = (mid+1 < R) ? mat[mid+1][maxCol]: -1;

            if(mat[mid][maxCol] < up)
                right = mid-1;
            else if(mat[mid][maxCol] < down)
                left = mid+1;
            else
                return new int[]{mid, maxCol};    
        }
        return new int[]{-1, -1};
    }
    private static int findCol(int[][] mat, int row, int R, int C){
        int max = 0;
        for(int i=1; i<C; i++){
            if(mat[row][i] > mat[row][max])
                max = i;
        }

        return max;
    }
}