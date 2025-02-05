// You are given an m x n grid where each cell can have one of three values:

// 0 representing an empty cell,
// 1 representing a fresh orange, or
// 2 representing a rotten orange.
// Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.

// Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.


// Example 1:

// Input: grid = [[2,1,1],[1,1,0],[0,1,1]]
// Output: 4

// Example 2:
// Input: grid = [[2,1,1],[0,1,1],[1,0,1]]
// Output: -1
// Explanation: The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.

// Example 3:
// Input: grid = [[0,2]]
// Output: 0
// Explanation: Since there are already no fresh oranges at minute 0, the answer is just 0.
 
// Constraints:

// m == grid.length
// n == grid[i].length
// 1 <= m, n <= 10
// grid[i][j] is 0, 1, or 2.

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    private boolean boundaryCheck(int x,int y, int R, int C){
        return (x >= 0 && x < R && y >= 0 && y < C);
    }
    public int orangesRotting(int[][] grid) {
        Queue <Rott> rotten = new LinkedList<>();
        boolean visited[][] = new boolean[grid.length][grid[0].length];
        
        int orange = 0;
        int rottenOrange = 0;
        int C = grid[0].length;
        int R = grid.length;

        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] == 2){
                    visited[i][j] = true;
                    Rott pos = new Rott(i, j);
                    rotten.offer(pos);
                    rottenOrange++;
                }
                if(grid[i][j]!= 0){
                    orange++;
                }
            }
        }

        if(orange == 0 && rotten.isEmpty())
            return 0;

        int counter = -1;

        while(!rotten.isEmpty()){
            int qsize = rotten.size();
            counter++;

            for(int i=0; i<qsize; i++){
                Rott pos = rotten.poll();

                if(boundaryCheck(pos.x + 1, pos.y, R, C) && grid[pos.x + 1][pos.y] == 1 && !visited[pos.x + 1][pos.y]){
                    rotten.offer(new Rott(pos.x + 1, pos.y));
                    visited[pos.x + 1][pos.y] = true;
                    rottenOrange++;
                }
                    
                if(boundaryCheck(pos.x - 1, pos.y, R, C) && grid[pos.x - 1][pos.y] == 1 && !visited[pos.x - 1][pos.y]){
                    rotten.offer(new Rott(pos.x -1, pos.y));
                    visited[pos.x - 1][pos.y] = true;
                    rottenOrange++;
                }
                    
                if(boundaryCheck(pos.x, pos.y + 1, R, C) && grid[pos.x][pos.y + 1] == 1 && !visited[pos.x][pos.y + 1]){
                    rotten.offer(new Rott(pos.x, pos.y + 1));
                    visited[pos.x][pos.y + 1] = true;
                    rottenOrange++;
                }
                    
                if(boundaryCheck(pos.x, pos.y - 1, R, C) && grid[pos.x][pos.y - 1] == 1 && !visited[pos.x][pos.y - 1]){
                    rotten.offer(new Rott(pos.x,pos.y - 1));
                    visited[pos.x][pos.y - 1] = true;
                    rottenOrange++;
                }    
            }
            
        }

        if(rottenOrange == orange) 
            return counter;
        return -1;    

    }
}
class Rott{
    int x;
    int y;
    Rott(int a, int b){
        this.x = a;
        this.y = b;
    }
}