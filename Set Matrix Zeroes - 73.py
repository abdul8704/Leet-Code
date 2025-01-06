"""
Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.

You must do it in place.

 

Example 1:


Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
Output: [[1,0,1],[0,0,0],[1,0,1]]
Example 2:


Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]
 

Constraints:

m == matrix.length
n == matrix[0].length
1 <= m, n <= 200
-231 <= matrix[i][j] <= 231 - 1
 

Follow up:

A straightforward solution using O(mn) space is probably a bad idea.
A simple improvement uses O(m + n) space, but still not the best solution.
Could you devise a constant space solution?
"""

class Solution(object):
    def setZeroes(self, matrix):
        
        
        #algorithm
        # 1.read through the matrix first
        #2. if element is zero, set its first row as zero. ex, ip= [[1,2,3],[4,5,0],[7,8,9]] set the matrix as [[1,2,0],[0,5,0],[7,8,9]]
        
        #3. after first iteration, iterate through the matrix one more time to make change
        #4. if first element of the row or the column is zero, set all of the elements of that ro to zero
        #5. since we are changing the first element of the row, what if the original value of that element was zero to begin with? in that case we
        #   need to set the entire first row/col to zero. 
        
        #6. To fix thi issue we use two flags to track whether first row/col has zero
        #7. after all iterations, we check the flags.
        #8. if they are true, we set all the elements of first row/col as zero.
        
        
        
        m = len(matrix)
        n = len(matrix[0])

        first_row_0 = False      
        first_col_0 = False

        for col in range(n):
            if matrix[0][col] == 0:
                first_row_0 = True

        for row in range(m):
            if matrix[row][0] == 0:
                first_col_0 = True        

        for row in range(m):
            for col in range(n):
                if matrix[row][col] == 0:
                    matrix[0][col] = 0
                    matrix[row][0] = 0
                    
        for row in range(1,m):
            for col in range(1,n):
                if matrix[0][col] == 0 or matrix[row][0] == 0:
                    matrix[row][col] = 0

        if first_row_0 :
            for col in range(n):
                matrix[0][col] = 0

        if first_col_0 :
            for row in range(m):
                matrix[row][0] = 0                    
        