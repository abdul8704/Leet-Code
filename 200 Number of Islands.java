// Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.
// An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

// Example 1:

// Input: grid = [
//   ["1","1","1","1","0"],
//   ["1","1","0","1","0"],
//   ["1","1","0","0","0"],
//   ["0","0","0","0","0"]
// ]
// Output: 1

// Example 2:
// Input: grid = [
//   ["1","1","0","0","0"],
//   ["1","1","0","0","0"],
//   ["0","0","1","0","0"],
//   ["0","0","0","1","1"]
// ]
// Output: 3
 
// Constraints:

// m == grid.length
// n == grid[i].length
// 1 <= m, n <= 300
// grid[i][j] is '0' or '1'.

class Solution {
    private static void dfs(char[][] grid, int R, int C, int row, int col){
        int offset[][] = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        grid[row][col] = '0';

        for(int i=0; i<4; i++){
            int adjRow = row + offset[i][0];
            int adjCol = col + offset[i][1];

            if(adjRow >= 0 && adjRow < R && adjCol >= 0 && adjCol < C){
                if(grid[adjRow][adjCol]== '1')
                    dfs(grid, R, C, adjRow, adjCol);
            }
        }
        return;
    }
    public int numIslands(char[][] grid) {
        int R = grid.length;
        int C = grid[0].length;

        int islands = 0;

        for(int row=0; row<R; row++){
            for(int col=0; col<C; col++){
                if(grid[row][col] == '1'){
                    islands++;
                    dfs(grid, R, C, row, col);
                }
            }
        }

        return islands;
    }
}