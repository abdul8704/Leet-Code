// Alice is attempting to type a specific string on her computer. However, she tends to be clumsy and may press a key for too long, resulting in a character being typed multiple times.
// Although Alice tried to focus on her typing, she is aware that she may still have done this at most once.
// You are given a string word, which represents the final output displayed on Alice's screen.
// Return the total number of possible original strings that Alice might have intended to type.

// Example 1:
// Input: word = "abbcccc"
// Output: 5
// Explanation:
// The possible strings are: "abbcccc", "abbccc", "abbcc", "abbc", and "abcccc".

// Example 2:
// Input: word = "abcd"
// Output: 1
// Explanation:
// The only possible string is "abcd".

// Example 3:
// Input: word = "aaaa"
// Output: 4

// Constraints:
// 1 <= word.length <= 100
// word consists only of lowercase English letters.

class Solution {
    public int possibleStringCount(String word) {
        int res = 1, N = word.length(), i=0;

        while(i < N){
            int j = i+1;
            while(j < N && word.charAt(i) == word.charAt(j)){
                j++;
            }

            if(j - i > 1){
                res += (j-i)-1;
                i = j; 
            }
            else{
                i++;
            }
        }

        return res;
    }
}

class Solution {
    public int possibleStringCount(String word) {
        int stack = 0, res = 1, N = word.length();
        char top = word.charAt(0);

        for(int i=1; i<N; i++){
            if(top == word.charAt(i)){
                stack++;
            }
            else{
                res += stack;
                stack = 0;
                top = word.charAt(i);
            }
        }
        res += stack;
        return res;
    }
}