// Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.

// Example 1:
// Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
// Output: [[1,6],[8,10],[15,18]]
// Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].

// Example 2:
// Input: intervals = [[1,4],[4,5]]
// Output: [[1,5]]
// Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 
// Constraints:
// 1 <= intervals.length <= 104
// intervals[i].length == 2
// 0 <= starti <= endi <= 104

import java.util.Arrays;
import java.util.LinkedList;

class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> (a[0] == b[0])? Integer.compare(a[1], b[1]):Integer.compare(a[0], b[0]));
        LinkedList<int[]> res = new LinkedList<>();

        for(int[] pair: intervals){
            if(res.size() == 0 || res.getLast()[1] < pair[0]){
                res.add(pair);
            }
            else{
                res.getLast()[1] = Math.max(res.getLast()[1], pair[1]);
            }
        }

        return res.toArray(new int[res.size()][2]);
    }
}