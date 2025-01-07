// Given a string s, reverse only all the vowels in the string and return it.
// The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both lower and upper cases, more than once.

 // Example 1:

// Input: s = "IceCreAm"
// Output: "AceCreIm"

// Explanation:
// The vowels in s are ['I', 'e', 'e', 'A']. On reversing the vowels, s becomes "AceCreIm".

// Example 2:
// Input: s = "leetcode"
// Output: "leotcede"

// Constraints:

// 1 <= s.length <= 3 * 105
// s consist of printable ASCII characters.

class Solution {
    private static boolean isVowel(char c){
        c = Character.toLowerCase(c);
        if(c == 'a' || c == 'e' || c=='i' || c == 'o' || c=='u'){
            return true;
        }
        return false;
    }
    public String reverseVowels(String s) {
        int i=0, j=s.length() - 1;
        char[] str = s.toCharArray();
        while(i < j){
            if(!isVowel(str[i]))
                i++;
            if(!isVowel(str[j]))
                j--;

            if(isVowel(str[i]) && isVowel(str[j])){
                char temp = str[i];
                str[i] = str[j];
                str[j] = temp;
                i++;
                j--;
            }        
            
        }
        return new String(str);
    }
}