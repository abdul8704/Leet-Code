// Given two strings a and b, return the minimum number of times you should repeat string a so that string b is a substring of it. If it is impossible for b​​​​​​ to be a substring of a after repeating it, return -1.
// Notice: string "abc" repeated 0 times is "", repeated 1 time is "abc" and repeated 2 times is "abcabc".
 
// Example 1:
// Input: a = "abcd", b = "cdabcdab"
// Output: 3
// Explanation: We return 3 because by repeating a three times "abcdabcdabcd", b is a substring of it.

// Example 2:
// Input: a = "a", b = "aa"
// Output: 2
 
// Constraints:
// 1 <= a.length, b.length <= 104
// a and b consist of lowercase English letters.

class Solution {
    private static int[] lpsContruct(String pat){
        int[] lps = new int[pat.length()];
        lps[0] = 0;

        int i=1, j=0;

        while(i < pat.length()){
            if(pat.charAt(i) == pat.charAt(j)){
                j++;
                lps[i] = j;
                i++;
            }
            else if(j == 0)
                i++;
            else
                j = lps[j-1];
        }

        return lps;
    }
    private static boolean search(String txt, String pat){
        int[] lps = lpsContruct(pat);

        int i = 0, j =0;

        while(i < txt.length()){
            if(txt.charAt(i) == pat.charAt(j)){
                i++;
                j++;
                if(j == pat.length())
                    return true;
            }
            else if(j != 0)
                j = lps[j-1];
            else
                i++;       
        }
        return false;

    }
    public int repeatedStringMatch(String a, String b) {
        StringBuilder str = new StringBuilder();
        int ops = 0;

        while(str.length() < b.length()){
            str.append(a);
            ops++;
        }
        String strr = str.toString();

        if(search(strr, b))
            return ops;

        strr += a;
        ++ops;

        if(search(strr, b))
            return ops;

        return -1;

    }
}