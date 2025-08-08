// Given a triangle array, return the minimum path sum from top to bottom.
// For each step, you may move to an adjacent number of the row below. More formally, if you are on index i on the current row, you may move to either index i or index i + 1 on the next row.

// Example 1:
// Input: triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
// Output: 11
// Explanation: The triangle looks like:
//    2
//   3 4
//  6 5 7
// 4 1 8 3
// The minimum path sum from top to bottom is 2 + 3 + 5 + 1 = 11 (underlined above).

// Example 2:
// Input: triangle = [[-10]]
// Output: -10

// Constraints:
// 1 <= triangle.length <= 200
// triangle[0].length == 1
// triangle[i].length == triangle[i - 1].length + 1
// -104 <= triangle[i][j] <= 104
 
// Follow up: Could you do this using only O(n) extra space, where n is the total number of rows in the triangle?

class Solution { // O(N^2) space
    public int minimumTotal(List<List<Integer>> triangle) {
        int N = triangle.size();

        List<List<Integer>> dp = new ArrayList<>();
        dp.add(triangle.get(0));

        for(int i=1; i<N; i++){
            int size = triangle.get(i).size();
            dp.add(new ArrayList<>());

            for(int col=0; col<size; col++){
                int case1 = (col-1 >= 0) ? dp.get(i-1).get(col-1): Integer.MAX_VALUE;
                int case2 = (col < size-1)  ? dp.get(i-1).get(col): Integer.MAX_VALUE;

                dp.get(i).add(triangle.get(i).get(col) + Math.min(case1, case2));
            }
        }

        return mini(dp.get(N-1));
    }

    private static int mini(List<Integer> list){
        int res = Integer.MAX_VALUE;

        for(Integer num: list)
            res = Math.min(res, num);

        return res;    
    }
}

class OptimisedSolution { // O(N) space
    public int minimumTotal(List<List<Integer>> tri) {
        int N = tri.size();

        Integer[] dp = new Integer[N];

        for(int i=0; i<N; i++)
            dp[i] = tri.get(N-1).get(i);

        for(int row=N-2; row>=0; row--)
            for(int col=0; col<row+1; col++)
                dp[col] = tri.get(row).get(col) + Math.min(dp[col], dp[col+1]);

        return dp[0];
    }
}