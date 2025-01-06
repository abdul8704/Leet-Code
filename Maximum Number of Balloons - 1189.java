// Given a string text, you want to use the characters of text to form as many instances of the word "balloon" as possible.

// You can use each character in text at most once. Return the maximum number of instances that can be formed.

 

// Example 1:



// Input: text = "nlaebolko"
// Output: 1
// Example 2:



// Input: text = "loonbalxballpoon"
// Output: 2
// Example 3:

// Input: text = "leetcode"
// Output: 0


class Solution {
    public int maxNumberOfBalloons(String text) {
        HashMap<Character,Integer> hash = new HashMap<>();
        for(int i =0;i < text.length(); i++){
            hash.put(text.charAt(i), hash.getOrDefault(text.charAt(i),0) + 1);
        }
        System.out.print(hash);
        
        int res = hash.getOrDefault('b' , 0);
        res = Math.min(res, hash.getOrDefault('a' , 0));
        res = Math.min(res, hash.getOrDefault('n' , 0));
        res = Math.min(res, hash.getOrDefault('l' , 0)/2);
        res = Math.min(res, hash.getOrDefault('o' , 0)/2);

        return res;
    }
}

class Solution {        //constant space complexity code ->
    public int maxNumberOfBalloons(String text) {
        int map[] = new int[26];
        for(int i =0;i<text.length(); i++){
            map[text.charAt(i) - 'a']++;
        }
        int res = map['b' - 'a'];
        res = Math.min(res, map[0]);
        res = Math.min(res, map['l' - 'a']/2);
        res = Math.min(res, map['o' - 'a']/2);
        res = Math.min(res, map['n' - 'a']);

        return res;
    }
}