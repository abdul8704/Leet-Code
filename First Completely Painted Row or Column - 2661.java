// You are given a 0-indexed integer array arr, and an m x n integer matrix mat. arr and mat both contain
//   all the integers in the range [1, m * n].
// Go through each index i in arr starting from index 0 and paint the cell in mat containing the integer arr[i].
// Return the smallest index i at which either a row or a column will be completely painted in mat.

 

// Example 1:

// image explanation for example 1
// Input: arr = [1,3,4,2], mat = [[1,4],[2,3]]
// Output: 2

// Explanation: The moves are shown in order, and both the first row and second column of the matrix become fully painted at arr[2].

// Example 2:

// Input: arr = [2,8,7,4,1,3,5,6,9], mat = [[3,2,5],[1,4,6],[8,7,9]]
// Output: 3
// Explanation: The second column becomes fully painted at arr[3].
 

// Constraints:

// m == mat.length
// n = mat[i].length
// arr.length == m * n
// 1 <= m, n <= 105
// 1 <= m * n <= 105
// 1 <= arr[i], mat[r][c] <= m * n
// All the integers of arr are unique.
// All the integers of mat are unique.

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class Solution {                //brute force solution
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int row[] = new int[mat.length];
        int col[] = new int[mat[0].length];

        HashMap<Integer, List<Integer>> hash = new HashMap<>();
        
        for(int i=0; i<mat.length; i++){
            for(int j=0; j<mat[0].length; j++){
                List<Integer> index = Arrays.asList(i, j);
                hash.put(mat[i][j], index);
            }
        }

        for(int i=0; i<arr.length; i++){
            int r = hash.get(arr[i]).get(0);
            int c = hash.get(arr[i]).get(1);
            row[r]++;
            col[c]++;

            if(row[r] == mat[0].length || col[c] == mat.length){
                return i;
            }
        }
        return -1;

    }
}

class Solution1 {
    public int firstCompleteIndex(int[] arr, int[][] mat) {   //optimised solution
        int[] map = new int[arr.length + 1];
        int max = 0, res = Integer.MAX_VALUE;

        for(int i=0; i<arr.length; i++){
            map[arr[i]] = i;
        }

        for(int row=0; row<mat.length; row++){
            max = 0;
            for(int col=0; col<mat[0].length; col++){
                max = Math.max(max, map[mat[row][col]]);
            }
            res = Math.min(res, max);
        }

        for(int row=0; row<mat[0].length; row++){
            max = 0;
            for(int col=0; col<mat.length; col++){
                max = Math.max(max, map[mat[col][row]]);
            }
            res = Math.min(res, max);
        }

        return res;
        
    }
}