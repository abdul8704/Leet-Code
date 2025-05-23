// Given a string s, sort it in decreasing order based on the frequency of the characters. The frequency of a character is the number of times it appears in the string.
// Return the sorted string. If there are multiple answers, return any of them.

// Example 1:
// Input: s = "tree"
// Output: "eert"
// Explanation: 'e' appears twice while 'r' and 't' both appear once.
// So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.

// Example 2:
// Input: s = "cccaaa"
// Output: "aaaccc"
// Explanation: Both 'c' and 'a' appear three times, so both "cccaaa" and "aaaccc" are valid answers.
// Note that "cacaca" is incorrect, as the same characters must be together.

// Example 3:
// Input: s = "Aabb"
// Output: "bbAa"
// Explanation: "bbaA" is also a valid answer, but "Aabb" is incorrect.
// Note that 'A' and 'a' are treated as two different characters.
 
// Constraints:
// 1 <= s.length <= 5 * 105
// s consists of uppercase and lowercase English letters and digits.

class Solution {
    public String frequencySort(String s) {
        int[] map = new int[75];
        int N = s.length();
        PriorityQueue<Node> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b.freq, a.freq));

        for(int i=0; i<N; i++){
            map[s.charAt(i) - 48]++;
        }

        for(int i=0; i<75; i++){
            if(map[i] != 0)
                maxHeap.offer(new Node((char)(i+48), map[i]));
        }

        StringBuilder res = new StringBuilder();
        while(!maxHeap.isEmpty()){
            Node top = maxHeap.poll();
            int n = top.freq;
            char letter = top.ch;

            for(int i=0; i<n; i++)
                res.append(letter);
        }
        
        String op = res.toString();
        return op;
    }
}
class Node{
    char ch;
    int freq;
    Node(char ch, int freq){
        this.ch = ch;
        this.freq = freq;
    }
}