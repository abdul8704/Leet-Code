// You are given an n x n binary matrix grid. You are allowed to change at most one 0 to be 1.
// Return the size of the largest island in grid after applying this operation.
// An island is a 4-directionally connected group of 1s.

// Example 1:
// Input: grid = [[1,0],[0,1]]
// Output: 3
// Explanation: Change one 0 to 1 and connect two 1s, then we get an island with area = 3.

// Example 2:
// Input: grid = [[1,1],[1,0]]
// Output: 4
// Explanation: Change the 0 to 1 and make the island bigger, only one island with area = 4.

// Example 3:
// Input: grid = [[1,1],[1,1]]
// Output: 4
// Explanation: Can't change any 0 to 1, only one island with area = 4.
 
// Constraints:
// n == grid.length
// n == grid[i].length
// 1 <= n <= 500
// grid[i][j] is either 0 or 1.

class Solution {
    private static int[][] dirs = {{0,1}, {1, 0}, {-1, 0}, {0, -1}};

    private static boolean inBounds(int row, int col, int R, int C){
        return (row < R && col < C && row >= 0 && col >= 0);
    }

    public int largestIsland(int[][] grid) {
        int N = grid.length;
        int []island = new int[(N*N)/2+3];
        int count = 2;
        int res = 0;

        for(int row=0; row<N; row++){
           for(int col=0; col<N; col++){
                if(grid[row][col] == 1){
                    island[count] = dfs(grid, row, col, count, N, 1);
                    res = Math.max(res, island[count++]);
                }
           }
        }
        
        for(int row = 0; row<N; row++){
            for(int col=0; col<N; col++){

                if(grid[row][col] != 0)
                    continue;

                for(int i=0; i<dirs.length; i++){
                    Set<Integer> set = new HashSet<>();
                    int area = 1;
                    
                    for(int j=i; j<dirs.length; j++){

                        int nextR = row + dirs[j][0];
                        int nextC = col + dirs[j][1]; 

                        if(!inBounds(nextR, nextC, N, N) || set.contains(grid[nextR][nextC]))
                            continue;

                        set.add(grid[nextR][nextC]);
                        area += island[grid[nextR][nextC]];  
                            
                    }
                    res = Math.max(area, res);
                }    
            }
        }

        return res;
    }
    private static int dfs(int[][] grid, int row, int col, int mark, int N, int size){
        grid[row][col] = mark;

        for(int i=0; i<dirs.length; i++){
            int nextR = row + dirs[i][0];
            int nextC = col + dirs[i][1];

            if(inBounds(nextR, nextC, N, N) && grid[nextR][nextC] == 1)
                size = Math.max(size, dfs(grid, nextR, nextC, mark, N, size+1));

        }

        return size;
    }
}