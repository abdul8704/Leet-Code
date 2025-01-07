// Given an input string s, reverse the order of the words.
// A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.
// Return a string of the words in reverse order concatenated by a single space.
// Note that s may contain leading or trailing spaces or multiple spaces between two words. The returned string should only have a single space separating the words. Do not include any extra spaces.

// Example 1:

// Input: s = "the sky is blue"
// Output: "blue is sky the"
// Example 2:

// Input: s = "  hello world  "
// Output: "world hello"
// Explanation: Your reversed string should not contain leading or trailing spaces.
// Example 3:

// Input: s = "a good   example"
// Output: "example good a"
// Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.
 

// Constraints:

// 1 <= s.length <= 104
// s contains English letters (upper-case and lower-case), digits, and spaces ' '.
// There is at least one word in s.
 
// Follow-up: If the string data type is mutable in your language, can you solve it in-place with O(1) extra space?

class Solution {
    public String reverseWords(String s) {
        int start = 0, end = s.length()-1;
        while(s.charAt(start) == ' '){
            start++;
        }
        while(s.charAt(end) == ' '){
            end--;
        }
        s = s.substring(start, end+1);

        StringBuilder sb = new StringBuilder();

        for(int i=s.length()-1; i >=0 ;i--){
            if(i > 0 && s.charAt(i) == ' ' && s.charAt(i-1) == ' '){
                continue;
            }
            sb.append(s.charAt(i));

        }
        s = new String(sb);
        return reverseSentence(s);
    }
    private static void reverse(char[] str, int i, int j){
        if (str == null || i < 0 || j >= str.length || i >= j) {
            return; // Do nothing if inputs are invalid
        }
        while(i < j){
            char temp = str[i];
            str[i] = str[j];
            str[j] = temp;
            i++;
            j--;
        }
    }
    public String reverseSentence(String s) {
        char[] str = s.toCharArray();
        int i=0;
        for(int j=0; j<str.length; j++){
            if(str[j] == ' '){
                reverse(str, i, j-1);
                i = j+1;
            }
        }
        reverse(str, i, s.length()-1);
        return new String(str);
    }
}