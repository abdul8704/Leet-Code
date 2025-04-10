// Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:

// Each row must contain the digits 1-9 without repetition.
// Each column must contain the digits 1-9 without repetition.
// Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
// Note:

// A Sudoku board (partially filled) could be valid but is not necessarily solvable.
// Only the filled cells need to be validated according to the mentioned rules.
 

// Example 1:


// Input: board = 
// [["5","3",".",".","7",".",".",".","."]
// ,["6",".",".","1","9","5",".",".","."]
// ,[".","9","8",".",".",".",".","6","."]
// ,["8",".",".",".","6",".",".",".","3"]
// ,["4",".",".","8",".","3",".",".","1"]
// ,["7",".",".",".","2",".",".",".","6"]
// ,[".","6",".",".",".",".","2","8","."]
// ,[".",".",".","4","1","9",".",".","5"]
// ,[".",".",".",".","8",".",".","7","9"]]
// Output: true
// Example 2:

// Input: board = 
// [["8","3",".",".","7",".",".",".","."]
// ,["6",".",".","1","9","5",".",".","."]
// ,[".","9","8",".",".",".",".","6","."]
// ,["8",".",".",".","6",".",".",".","3"]
// ,["4",".",".","8",".","3",".",".","1"]
// ,["7",".",".",".","2",".",".",".","6"]
// ,[".","6",".",".",".",".","2","8","."]
// ,[".",".",".","4","1","9",".",".","5"]
// ,[".",".",".",".","8",".",".","7","9"]]
// Output: false
// Explanation: Same as Example 1, except with the 5 in the top left corner being modified to 8. Since there are two 8's in the top left 3x3 sub-box, it is invalid.
 

// Constraints:

// board.length == 9
// board[i].length == 9
// board[i][j] is a digit 1-9 or '.'.

class Solution {
    public boolean isValidSudoku(char[][] board) {
        int col_freq[] = new int[10];
        int row_freq[]  = new int[10];

        int mat1[] = new int[10];
        int mat2[] = new int[10];
        int mat3[] = new int[10];

        for(int i=0; i<9; i++){     
            row_freq  = new int[10];
            col_freq = new int[10];

            for(int j=0; j<9; j++){         //check row wise
                if(board[i][j] != '.'){
                    if(row_freq[board[i][j] - '0'] != 0)
                        return false;
                    row_freq[board[i][j] - '0']++;
                }
                
                if(board[j][i] != '.'){        //check col wise
                    if(col_freq[board[j][i] - '0'] != 0)
                        return false;
                    col_freq[board[j][i] - '0']++;
                }
                    
            }
            if(i%3 == 0) 
                mat1 = new int[10];
            for(int j=0; j<3; j++){         //check leftmost matrix
                if(board[i][j] != '.'){
                    if(mat1[board[i][j] - '0'] != 0)
                        return false;
                    mat1[board[i][j] - '0']++;    
                }
            }

            if(i%3 == 0) 
                mat2 = new int[10];
            for(int j=3; j<6; j++){         //check middle matrix
                if(board[i][j] != '.'){
                    if(mat2[board[i][j] - '0'] != 0)
                        return false;
                    mat2[board[i][j] - '0']++;    
                }
            }

            if(i%3 == 0) 
                mat3 = new int[10];
            for(int j=6; j<9; j++){     //check rightmost matrix
                if(board[i][j] != '.'){
                    if(mat3[board[i][j] - '0'] != 0)
                        return false;
                    mat3[board[i][j] - '0']++;    
                }
            }

        }
        return true;
    }
}