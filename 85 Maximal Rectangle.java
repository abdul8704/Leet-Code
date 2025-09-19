// Given a rows x cols binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.

// Example 1:
// Input: matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
// Output: 6
// Explanation: The maximal rectangle is shown in the above picture.

// Example 2:
// Input: matrix = [["0"]]
// Output: 0

// Example 3:
// Input: matrix = [["1"]]
// Output: 1
 
// Constraints:
// rows == matrix.length
// cols == matrix[i].length
// 1 <= row, cols <= 200
// matrix[i][j] is '0' or '1'.

class Solution {
    public int maximalRectangle(char[][] mat) {
        int max = 0;
        int R = mat.length, C = mat[0].length;
        int[] arr = new int[C];

        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                arr[j] = (mat[i][j] - '0' == 0) ? 0: arr[j] + (mat[i][j] - '0');
            }

            max = Math.max(max, largestRectangleArea(arr));
        }
        return max;
    }
        private static int largestRectangleArea(int[] heights) {
        int max = 0, N = heights.length;

        Stack<Integer> stack = new Stack<>();

        for(int i=0; i<=N; i++){
            int tall = (i != N) ? heights[i]: 0;

            while(!stack.isEmpty() && heights[stack.peek()] >= tall){
                int tempHeight =  heights[stack.pop()] ;

                int width;

                if(stack.isEmpty())
                    width = i;     // no more elemts lesser than current tower
                else
                    width = i - stack.peek() - 1;   // left - right - 1 window length logic

                max = Math.max(max, width * tempHeight);
            }

            stack.push(i);
        }

        return max;
        
    }
}