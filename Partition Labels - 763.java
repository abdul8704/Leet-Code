// You are given a string s. We want to partition the string into as many parts as possible so that each letter appears in at most one part.
// For example, the string "ababcc" can be partitioned into ["abab", "cc"], but partitions such as ["aba", "bcc"] or ["ab", "ab", "cc"] are invalid.
// Note that the partition is done so that after concatenating all the parts in order, the resultant string should be s.

// Return a list of integers representing the size of these parts.

// Example 1:
// Input: s = "ababcbacadefegdehijhklij"
// Output: [9,7,8]
// Explanation:
// The partition is "ababcbaca", "defegde", "hijhklij".
// This is a partition so that each letter appears in at most one part.
// A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits s into less parts.

// Example 2:
// Input: s = "eccbbbbdec"
// Output: [10]
 
// Constraints:
// 1 <= s.length <= 500
// s consists of lowercase English letters.

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

class Solution {
    public List<Integer> partitionLabels(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int N = s.length();

        for(int i= N-1; i>= 0; i--){
            if(!map.containsKey(s.charAt(i)))
                map.put(s.charAt(i), i);
        }

        int start = 0, end = 0;
        List<Integer> res = new ArrayList<>();

        for(int i=0; i<N; i++){
            end = Math.max(end, map.get(s.charAt(i)));

            if(end == i){
                res.add(end - start + 1);
                start = i+1;
            }
        }

        return res;
    }

}

class Solution2 {
    public List<Integer> partitionLabels(String s) {
        HashMap<Character, int[]> map = new HashMap<>();
        int[] set = new int[26];
        int N = s.length();

        for(int i=0; i<N; i++){
            if(set[s.charAt(i) - 'a']++ == 0){
                map.put(s.charAt(i), new int[]{i, -1});
            }
        }

        set = new int[26];

        for(int i= N-1; i>= 0; i--){
            if(set[s.charAt(i) - 'a']++ == 0){
                map.get(s.charAt(i))[1] = i;
            }
        }

        List<int[]> intervals = new ArrayList<>(map.values());

        Collections.sort(intervals, (a, b) -> (a[0] == b[0]) ? Integer.compare(a[1], b[1]): Integer.compare(a[0], b[0]) );

        return merge(intervals);

    }
    public List<Integer> merge(List<int[]> intervals) {
        ArrayList<int[]> list = new ArrayList<>();

        list.add(intervals.get(0));

        for(int i=1; i<intervals.size(); i++){
            if(intervals.get(i)[0] <= list.get(list.size() - 1)[1]){
                int[] top = list.get(list.size() - 1);
                top[1] = Math.max(top[1], intervals.get(i)[1]);

                list.set(list.size() - 1, top);
            }
            else{
                list.add(intervals.get(i));
            }
        }

        List<Integer> res = new ArrayList<>();
        for(int i=0; i<list.size(); i++){
            res.add(list.get(i)[1] - list.get(i)[0] + 1);
        }

        return res;
    }
}