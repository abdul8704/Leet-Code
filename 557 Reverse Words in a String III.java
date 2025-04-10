// Given a string s, reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.

// Example 1:

// Input: s = "Let's take LeetCode contest"
// Output: "s'teL ekat edoCteeL tsetnoc"
// Example 2:

// Input: s = "Mr Ding"
// Output: "rM gniD"
 
// Constraints:

// 1 <= s.length <= 5 * 104
// s contains printable ASCII characters.
// s does not contain any leading or trailing spaces.
// There is at least one word in s.
// All the words in s are separated by a single space.

class Solution {
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
    public String reverseWords(String s) {
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