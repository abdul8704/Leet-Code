// A word is considered valid if:
// It contains a minimum of 3 characters.
// It contains only digits (0-9), and English letters (uppercase and lowercase).
// It includes at least one vowel.
// It includes at least one consonant.
// You are given a string word.
// Return true if word is valid, otherwise, return false.

// Notes:
// 'a', 'e', 'i', 'o', 'u', and their uppercases are vowels.
// A consonant is an English letter that is not a vowel.
 
// Example 1:
// Input: word = "234Adas"
// Output: true
// Explanation:
// This word satisfies the conditions.

// Example 2:
// Input: word = "b3"
// Output: false
// Explanation:
// The length of this word is fewer than 3, and does not have a vowel.

// Example 3:
// Input: word = "a3$e"
// Output: false
// Explanation:
// This word contains a '$' character and does not have a consonant.

// Constraints:
// 1 <= word.length <= 20
// word consists of English uppercase and lowercase letters, digits, '@', '#', and '$'.

class Solution {
    public boolean isValid(String word) {
        if(word.length() < 3) 
            return false;

        boolean valid = false, vowel = false, cons = false;
        
        for(int i=0; i<word.length(); i++){
            
            if(word.charAt(i) >= 'a' && word.charAt(i) <= 'z' || word.charAt(i) >= 'A' && word.charAt(i) <= 'Z'){
                valid = true;
                if(vowel(word.charAt(i)))
                    vowel = true;
                else
                    cons = true;    
            }
            else if(word.charAt(i) < '0' && word.charAt(i) > '9')
                return false;        
        }    

        return (valid && vowel && cons);
    }
    private static boolean vowel(char ch){
        ch = Character.toLowerCase(ch);
        return (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u');
    }
}