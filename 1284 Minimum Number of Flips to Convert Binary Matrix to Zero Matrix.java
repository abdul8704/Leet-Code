// Given a m x n binary matrix mat. In one step, you can choose one cell and flip it and all the four neighbors of it if they exist (Flip is changing 1 to 0 and 0 to 1). A pair of cells are called neighbors if they share one edge.
// Return the minimum number of steps required to convert mat to a zero matrix or -1 if you cannot.
// A binary matrix is a matrix with all cells equal to 0 or 1 only.
// A zero matrix is a matrix with all cells equal to 0.

// Example 1:
// Input: mat = [[0,0],[0,1]]
// Output: 3
// Explanation: One possible solution is to flip (1, 0) then (0, 1) and finally (1, 1) as shown.

// Example 2:
// Input: mat = [[0]]
// Output: 0
// Explanation: Given matrix is a zero matrix. We do not need to change it.

// Example 3:
// Input: mat = [[1,0,0],[1,0,0]]
// Output: -1
// Explanation: Given matrix cannot be a zero matrix.
 
// Constraints:
// m == mat.length
// n == mat[i].length
// 1 <= m, n <= 3
// mat[i][j] is either 0 or 1.

import java.utils.Set;
import java.utils.HashSet;
import java.utils.LinkedList;
import java.utils.Queue;

class Solution {
    private static int dirs[][] = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}, {0, 0}};

    private static boolean isWithinBounds(int row, int col, int R, int C){
        return (row >= 0 && row < R && col >=0 && col < C);
    }

    private static int toInd(int row, int col, int C){
        return (row * C) + col;
    }
    public int minFlips(int[][] mat) {
        int R = mat.length;
        int C = mat[0].length;

        int state = 0;

        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                if(mat[i][j] == 1)
                    state = state | (1 << toInd(i, j, C));
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> set = new HashSet<>(); 
        int steps = 0;

        queue.offer(state);
        set.add(state);

        while(!queue.isEmpty()){
            int size = queue.size();

            for(int ctr = 0; ctr < size; ctr++){
                int current = queue.poll();
                
                if(current == 0) return steps;

                for(int row=0; row<R; row++){
                    for(int col=0; col<C; col++){
                        int newState = current;

                        for(int i=0; i< dirs.length; i++){
                            int nextR = row + dirs[i][0];
                            int nextC = col + dirs[i][1]; 

                            if(!isWithinBounds(nextR, nextC, R, C))
                                continue;
                            
                            newState ^= (1 << toInd(nextR, nextC, C));
                        }

                        if(set.contains(newState))
                            continue;

                        set.add(newState);
                        queue.offer(newState);    
                    }
                }
            }
            steps++;    
        }
        return -1;
        
    }
}