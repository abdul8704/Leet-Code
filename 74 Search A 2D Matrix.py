"""
You are given an m x n integer matrix matrix with the following two properties:

Each row is sorted in non-decreasing order.
The first integer of each row is greater than the last integer of the previous row.
Given an integer target, return true if target is in matrix or false otherwise.

You must write a solution in O(log(m * n)) time complexity.

 

Example 1:


Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
Output: true
Example 2:


Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
Output: false
 

Constraints:

m == matrix.length
n == matrix[i].length
1 <= m, n <= 100
-104 <= matrix[i][j], target <= 10^4
"""

class Solution(object):
    def searchMatrix(self, matrix, target):     
          
        high = len(matrix) - 1
        low = 0
        
        row = 0
        
        while high >= low :            
            mid = (high + low) // 2
            
            if matrix[mid][0] <= target and matrix[mid][-1] >= target:
                row = mid
                break
            
            else:
                if matrix[mid][0] > target:
                    high = mid - 1
                else:
                    low = mid + 1

        high = len(matrix[0]) - 1
        low = 0
        
        while high >= low :
            mid = (high+low) // 2
            
            if matrix[row][mid] == target :
                return True
            
            else:
                if matrix[row][mid] > target:
                    high = mid - 1
                    
                else:
                    low = mid + 1
                    
        return False 