// The beauty of a string is the difference in frequencies between the most frequent and least frequent characters.
// For example, the beauty of "abaacc" is 3 - 1 = 2.
// Given a string s, return the sum of beauty of all of its substrings.

// Example 1:
// Input: s = "aabcb"
// Output: 5
// Explanation: The substrings with non-zero beauty are ["aab","aabc","aabcb","abcb","bcb"], each with beauty equal to 1.

// Example 2:
// Input: s = "aabcbaa"
// Output: 17
 
// Constraints:
// 1 <= s.length <= 500
// s consists of only lowercase English letters.

class Solution {
    private static int leastFrequent(int []arr){
        int min = 501;

        for(int i: arr)
            if(i != 0) min = Math.min(min, i);   
        
        return min;
    }
    public int beautySum(String s) {
        int sum = 0;
        char[] str = s.toCharArray();

        for(int i=0; i<str.length; i++){
            int []map = new int[26];
            int max = 0;

            for(int j=i; j<str.length; j++){
                ++map[str[j] - 'a'];
                max = Math.max(max, map[str[j] - 'a']);
                sum += (max - leastFrequent(map));
            }
        }

        return sum;
    }
}