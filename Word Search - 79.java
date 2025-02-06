// Given an m x n grid of characters board and a string word, return true if word exists in the grid.
// The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.

// Example 1:
// Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
// Output: true

// Example 2:
// Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
// Output: true

// Example 3:
// Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
// Output: false
 

// Constraints:

// m == board.length
// n = board[i].length
// 1 <= m, n <= 6
// 1 <= word.length <= 15
// board and word consists of only lowercase and uppercase English letters.

class Solution {
    private static int[][] offset = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
                                   // left     right    up      down

    private static boolean isOutOfBounds(int i, int j, int R, int C){   //return true if index is out of bounds.
        return !(i >=0 && i < R && j>=0 && j< C);                    
    }

    private static boolean dfs(char[][] board, int row, int col, int R, int C, int ind, String word, boolean[][] visited){
        visited[row][col] = true;           //mark current index as visited

        if(ind == word.length()){       // base condition.
            return true;                // when we have found the last letter
        }

        for(int i=0; i<4; i++){
            int nextRow = row + offset[i][0];       //setting the next index
            int nextCol = col + offset[i][1];

            if(isOutOfBounds(nextRow, nextCol, R, C)){  // to prevent Index out of bounds
                continue;
            }

            if(board[nextRow][nextCol] == word.charAt(ind) && !visited[nextRow][nextCol]){
                boolean found = dfs(board, nextRow, nextCol, R, C, ind + 1, word, visited);  //look for next char
                if(found) return true;              //receive the output of the recursive calls and check if match is found
            }
        }
        visited[row][col] = false;      //backtrack, if this we havent found a match in this part of the tree
        return false;
    }
    public boolean exist(char[][] board, String word) {
        int R = board.length;
        int C = board[0].length;

        for(int row=0; row < R; row++){
            for(int col=0; col < C; col++){
                if(board[row][col] == word.charAt(0)){
                    boolean visited[][] = new boolean[R][C];
                    boolean found = dfs(board, row, col, R, C, 1, word, visited);

                    if(found) return true;

                }
            }
        }

        return false;
    }   
}