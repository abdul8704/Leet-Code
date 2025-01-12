// You are given an m x n 2D array grid of positive integers.
// Your task is to traverse grid in a zigzag pattern while skipping every alternate cell.

// Zigzag pattern traversal is defined as following the below actions:

// Start at the top-left cell (0, 0).
// Move right within a row until the end of the row is reached.
// Drop down to the next row, then traverse left until the beginning of the row is reached.
// Continue alternating between right and left traversal until every row has been traversed.
// Note that you must skip every alternate cell during the traversal.

// Return an array of integers result containing, in order, the value of the cells visited during the zigzag traversal with skips.

// Example 1:
// Input: grid = [[1,2],[3,4]]
// Output: [1,4]


// Example 2:
// Input: grid = [[2,1],[2,1],[2,1]]
// Output: [2,1,2]

// Example 3:
// Input: grid = [[1,2,3],[4,5,6],[7,8,9]]
// Output: [1,3,5,7,9]

// Constraints:

// 2 <= n == grid.length <= 50
// 2 <= m == grid[i].length <= 50
// 1 <= grid[i][j] <= 2500

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> zigzagTraversal(int[][] grid) {
        List<Integer> res = new ArrayList<>();
        int i = 0, j = 0;
        // int row = grid.length, col = grid[0].length;
        
        while(i < grid.length){
            j = 0;
            while(j < grid[0].length){
                // System.out.println(grid[i][j]);
                res.add(grid[i][j]);
                j += 2;
            }
            i++;
            
            if(i >= grid.length){
                break;
            }
            
            if((grid[0].length) % 2 == 0){
                j = grid[0].length - 1;
            }else{
                j = grid[0].length - 2;
            }
        
            while (j >= 0){
                // System.out.println(grid[i][j]);
                res.add(grid[i][j]);
                j -= 2;
            }
            
            i++;
        }
        return res;
    }
}