// Given two binary strings a and b, return their sum as a binary string.

// Example 1:

// Input: a = "11", b = "1"
// Output: "100"
// Example 2:

// Input: a = "1010", b = "1011"
// Output: "10101"
 

// Constraints:

// 1 <= a.length, b.length <= 104
// a and b consist only of '0' or '1' characters.
// Each string does not contain leading zeros except for the zero itself.

class Solution {
    public String addBinary(String s1, String s2) {
    // Ensure s1 is always the longer string
    if (s2.length() > s1.length()) {
        return addBinary(s2, s1);
    }

    // Remove leading zeros
    int i = 0, j = 0;
    
    int firstOne = s1.indexOf('1');
    s1 = (firstOne == -1) ? "0" : s1.substring(firstOne);
    
    firstOne = s2.indexOf('1');
    s2 = (firstOne == -1) ? "0": s2.substring(firstOne);

    int carry = 0, bit1 = 0, bit2 = 0;
    StringBuilder res = new StringBuilder();

    // Start from the end of both strings
    i = s1.length() - 1;
    j = s2.length() - 1;

    while (i >= 0 || j >= 0 || carry != 0) {
        bit1 = (i >= 0) ? s1.charAt(i) - '0' : 0;
        bit2 = (j >= 0) ? s2.charAt(j) - '0' : 0;

        int sum = bit1 + bit2 + carry;
        res.append(sum % 2); // Append the result bit
        carry = sum / 2;     // Calculate the carry

        i--;
        j--;
    }

    // Reverse the result as it was constructed backward
    return res.reverse().toString();
}

}