// You are given an n x n integer matrix grid where each value grid[i][j] represents the elevation at that point (i, j).
// The rain starts to fall. At time t, the depth of the water everywhere is t. You can swim from a square to another 4-directionally adjacent square if and only if the elevation of both squares individually are at most t. You can swim infinite distances in zero time. Of course, you must stay within the boundaries of the grid during your swim.
// Return the least time until you can reach the bottom right square (n - 1, n - 1) if you start at the top left square (0, 0).

// Example 1:
// Input: grid = [[0,2],[1,3]]
// Output: 3
// Explanation:
// At time 0, you are in grid location (0, 0).
// You cannot go anywhere else because 4-directionally adjacent neighbors have a higher elevation than t = 0.
// You cannot reach point (1, 1) until time 3.
// When the depth of water is 3, we can swim anywhere inside the grid.

// Example 2:
// Input: grid = [[0,1,2,3,4],[24,23,22,21,5],[12,13,14,15,16],[11,17,18,19,20],[10,9,8,7,6]]
// Output: 16
// Explanation: The final route is shown.
// We need to wait until time 16 so that (0, 0) and (4, 4) are connected.

// Constraints:
// n == grid.length
// n == grid[i].length
// 1 <= n <= 50
// 0 <= grid[i][j] < n2
// Each value grid[i][j] is unique.

import java.utils.PriorityQueue;

class Solution {
    private static int offset[][] = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

    private static boolean withinBoundary(int R, int C, int row, int col){
        return (row >= 0 && row < R && col >= 0 && col < C);
    }
    public int swimInWater(int[][] grid) {
        PriorityQueue<Unit> minHeap = new PriorityQueue<>((a, b) -> a.height - b.height);
        int R = grid.length, C = grid[0].length;
        
        boolean[][] visited = new boolean[R][C];
        int row = 0, col = 0, time = grid[0][0];
        minHeap.offer(new Unit(0, 0, grid[0][0]));

        while(!minHeap.isEmpty()){
            visited[row][col] = true;
            if(row == R-1 && col == C-1) break;

            for(int i=0; i<offset.length; i++){
                int nextR = row + offset[i][0];
                int nextC = col + offset[i][1];

                if(withinBoundary(R, C, nextR, nextC) && !visited[nextR][nextC]){
                    minHeap.offer(new Unit(nextR, nextC, grid[nextR][nextC]));    
                    visited[nextR][nextC] = true;
                }
            }

            Unit best = minHeap.poll();
            row = best.row;
            col = best.col;
            
            time = Math.max(time, best.height);
        }
        return time;
    }
}

class Unit{
    int row;
    int col;
    int height;
    Unit(int a, int b, int c){
        this.row = a;
        this.col = b;
        this.height = c;
    }
}