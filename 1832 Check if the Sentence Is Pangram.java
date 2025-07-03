// A pangram is a sentence where every letter of the English alphabet appears at least once.
// Given a string sentence containing only lowercase English letters, return true if sentence is a pangram, or false otherwise.

// Example 1:
// Input: sentence = "thequickbrownfoxjumpsoverthelazydog"
// Output: true
// Explanation: sentence contains at least one of every letter of the English alphabet.

// Example 2:
// Input: sentence = "leetcode"
// Output: false
 
// Constraints:
// 1 <= sentence.length <= 1000
// sentence consists of lowercase English letters.

class Solution {
    public boolean checkIfPangram(String sentence) {
        if(sentence.length() < 26) return false;
        int map = 0, target = (1 << 26) - 1;

        for(char ch: sentence.toCharArray()){
            int val = ch - 'a';
            map |= (1 << val);   
        }


        return (map & target) == target;
    }
}
class ReferenceSolution {
    private static String decToBinary(int n) {
        StringBuilder bin = new StringBuilder();

        while (n > 0) {
            int bit = n % 2;
            bin.append((char) ('0' + bit));
            n /= 2;
        }
        
        // reverse the string
        bin.reverse();
        return bin.toString();
    }
    public boolean checkIfPangram(String sentence) {
        int map = 0, target = (1 << 26) - 1;

        for(char ch: sentence.toCharArray()){
            int val = ch - 'a';
            map |= (1 << val);   
        }
            System.out.println(decToBinary(map));
            System.out.println(decToBinary(target));

        return (map & target) == target;
    }
}