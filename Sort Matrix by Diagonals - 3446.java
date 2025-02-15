// You are given an n x n square matrix of integers grid. Return the matrix such that:
// The diagonals in the bottom-left triangle (including the middle diagonal) are sorted in non-increasing order.
// The diagonals in the top-right triangle are sorted in non-decreasing order.
 
// Example 1:
// Input: grid = [[1,7,3],[9,8,2],[4,5,6]]
// Output: [[8,2,3],[9,6,7],[4,5,1]]
// Explanation
// The diagonals with a black arrow (bottom-left triangle) should be sorted in non-increasing order:

// [1, 8, 6] becomes [8, 6, 1].
// [9, 5] and [4] remain unchanged.
// The diagonals with a blue arrow (top-right triangle) should be sorted in non-decreasing order:
// [7, 2] becomes [2, 7].
// [3] remains unchanged.

// Example 2:
// Input: grid = [[0,1],[1,2]]
// Output: [[2,1],[1,0]]
// Explanation:
// The diagonals with a black arrow must be non-increasing, so [0, 2] is changed to [2, 0]. The other diagonals are already in the correct order.

// Example 3:
// Input: grid = [[1]]
// Output: [[1]]
// Explanation:
// Diagonals with exactly one element are already in order, so no changes are needed.

// Constraints:
// grid.length == grid[i].length == n
// 1 <= n <= 10
// -105 <= grid[i][j] <= 105
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

class Solution {
    public int[][] sortMatrix(int[][] grid) {
        int N = grid.length;
        HashMap<Integer, List<Integer>> map = new HashMap<>();

        for(int row=0; row<N; row++){
            for(int col=0; col<N; col++){
                Integer key = row - col;
                if(!map.containsKey(key)){
                    map.put(key, new ArrayList<>(Arrays.asList(grid[row][col])));
                }
                else{
                    map.get(key).add(grid[row][col]);
                }
                     
            }
        }
        
        for(Integer key: map.keySet()){
            List<Integer> diag = map.get(key);
            if(key >= 0)
                Collections.sort(diag, Collections.reverseOrder());
            else
                Collections.sort(diag);    
            map.put(key, diag);
        }
        
        for(int row = N-1; row >=0; row--){
            for(int col = N-1; col >=0; col--){
                int key = row - col;
                List<Integer> diag = map.get(key);
                int top = diag.remove(diag.size() - 1);
                grid[row][col] = top;
            }
        }
        return grid;
    }
    
}