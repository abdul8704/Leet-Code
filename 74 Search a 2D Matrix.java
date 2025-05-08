// You are given an m x n integer matrix matrix with the following two properties:
// Each row is sorted in non-decreasing order.
// The first integer of each row is greater than the last integer of the previous row.
// Given an integer target, return true if target is in matrix or false otherwise.
// You must write a solution in O(log(m * n)) time complexity.

// Example 1:
// Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
// Output: true

// Example 2:
// Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
// Output: false
 
// Constraints:
// m == matrix.length
// n == matrix[i].length
// 1 <= m, n <= 100
// -104 <= matrix[i][j], target <= 104

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int R = matrix.length, C = matrix[0].length;

        int left = 0, right = (R*C) - 1;

        while(left <= right){
            int mid = (left + right) / 2;

            if(matrix[mid/C][mid%C] == target)
                return true;
            else if(matrix[mid/C][mid%C] < target) 
                left = mid + 1;
            else
                right = mid - 1;       
        }

        return false;
    }
}