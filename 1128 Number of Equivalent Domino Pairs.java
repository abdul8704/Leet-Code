// Given a list of dominoes, dominoes[i] = [a, b] is equivalent to dominoes[j] = [c, d] if and only if either (a == c and b == d), or (a == d and b == c) - that is, one domino can be rotated to be equal to another domino.
// Return the number of pairs (i, j) for which 0 <= i < j < dominoes.length, and dominoes[i] is equivalent to dominoes[j].

// Example 1:
// Input: dominoes = [[1,2],[2,1],[3,4],[5,6]]
// Output: 1

// Example 2:
// Input: dominoes = [[1,2],[1,2],[1,1],[1,2],[2,2]]
// Output: 3
 
// Constraints:
// 1 <= dominoes.length <= 4 * 104
// dominoes[i].length == 2
// 1 <= dominoes[i][j] <= 9

import java.util.HashMap;

class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;

        for(int[] arr: dominoes){
            int piece = (arr[0] > arr[1]) ? arr[0]*10 + arr[1] : arr[1]*10 + arr[0];

            if(map.containsKey(piece)){
                count += map.get(piece);
                map.put(piece, map.get(piece) + 1);
            }
            else{
                map.put(piece, 1);
            }
        }
        return count;
    }
}