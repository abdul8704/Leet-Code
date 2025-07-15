// The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.
// Given an integer n, return all distinct solutions to the n-queens puzzle. You may return the answer in any order.
// Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space, respectively.

// Example 1:
// Input: n = 4
// Output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
// Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above

// Example 2:
// Input: n = 1
// Output: [["Q"]]
 
// Constraints:
// 1 <= n <= 9

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();

        char[][] board = new char[n][n];

        for(int row=0; row<n; row++)
            for(int col=0; col<n; col++)
                board[row][col] = '.';
            
        for(int i=0; i<n; i++){
            board[0][i] = 'Q';
            dfs(board, n, 1, res);
            board[0][i] = '.';
        }

        return res;
    }
    private static void dfs(char[][] board, int N, int row,  List<List<String>> res){
        if(row == N){
            List<String> list = new ArrayList<>();

            for(char[] str: board)
                list.add(new String(str));

            res.add(list);
            return;    
        }

        for(int col = 0; col<N; col++){
            if(isSafe(board, N, row, col)){
                board[row][col] = 'Q';
                dfs(board, N, row+1, res);
                board[row][col] = '.';
            }
        }
    }
    private static boolean isSafe(char[][] board, int N, int row, int col){
        for(int i=0; i<N; i++){
            if(board[row][i] == 'Q' || board[i][col] == 'Q')
                return false;

            if( (inBounds(row+i, col+i, N, N) && board[row+i][col+i] == 'Q') ||
                (inBounds(row-i, col+i, N, N) && board[row-i][col+i] == 'Q') ||
                (inBounds(row+i, col-i, N, N) && board[row+i][col-i] == 'Q') ||
                (inBounds(row-i, col-i, N, N) && board[row-i][col-i] == 'Q')
            )
                return false;

        }

        return true;
    }
    private static boolean inBounds(int row, int col, int R, int C){
        return (row >= 0 && row < R && col >= 0 && col < C);
    }
}