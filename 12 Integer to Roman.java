// Seven different symbols represent Roman numerals with the following values:

// Symbol	Value
// I	1
// V	5
// X	10
// L	50
// C	100
// D	500
// M	1000

// Roman numerals are formed by appending the conversions of decimal place values from highest to lowest. Converting a decimal place value into a Roman numeral has the following rules:
// If the value does not start with 4 or 9, select the symbol of the maximal value that can be subtracted from the input, append that symbol to the result, subtract its value, and convert the remainder to a Roman numeral.
// If the value starts with 4 or 9 use the subtractive form representing one symbol subtracted from the following symbol, for example, 4 is 1 (I) less than 5 (V): IV and 9 is 1 (I) less than 10 (X): IX. Only the following subtractive forms are used: 4 (IV), 9 (IX), 40 (XL), 90 (XC), 400 (CD) and 900 (CM).
// Only powers of 10 (I, X, C, M) can be appended consecutively at most 3 times to represent multiples of 10. You cannot append 5 (V), 50 (L), or 500 (D) multiple times. If you need to append a symbol 4 times use the subtractive form.
// Given an integer, convert it to a Roman numeral.

// Example 1:
// Input: num = 3749
// Output: "MMMDCCXLIX"
// Explanation:
// 3000 = MMM as 1000 (M) + 1000 (M) + 1000 (M)
//  700 = DCC as 500 (D) + 100 (C) + 100 (C)
//   40 = XL as 10 (X) less of 50 (L)
//    9 = IX as 1 (I) less of 10 (X)
// Note: 49 is not 1 (I) less of 50 (L) because the conversion is based on decimal places

// Example 2:
// Input: num = 58
// Output: "LVIII"
// Explanation:
// 50 = L
//  8 = VIII

// Example 3:
// Input: num = 1994
// Output: "MCMXCIV"
// Explanation:
// 1000 = M
//  900 = CM
//   90 = XC
//    4 = IV
 
// Constraints:
// 1 <= num <= 3999

import java.util.HashMap;

class Solution {
    private static StringBuilder convert(HashMap<Integer, Character> map, int num, int multiple) {
        if (num == 0)
            return new StringBuilder();

        StringBuilder ans = new StringBuilder();

        if (num == 9) {
            ans.append(map.get(multiple));
            ans.append(map.get(multiple * 10));
        } else if (num >= 5) {
            ans.append(map.get(5 * multiple));
            ans.append(convert(map, num - 5, multiple));
        } else if (num <= 3) {
            for (int i = 0; i < num; i++)
                ans.append(map.get(multiple));
        } else {
            ans.append(map.get(multiple));
            ans.append(map.get(5 * multiple));
        }

        return ans;
    }

    public String intToRoman(int num) {
        StringBuilder res = new StringBuilder();
        HashMap<Integer, Character> map = new HashMap<>();
        map.put(1000, 'M');
        map.put(500, 'D');
        map.put(100, 'C');
        map.put(50, 'L');
        map.put(10, 'X');
        map.put(5, 'V');
        map.put(1, 'I');

        int digits = (int) Math.log10(num) + 1;
        int multiple = 1;

        for (int i = 0; i < digits - 1; i++)
            multiple *= 10;

        for (int i = 0; i < digits; i++) {
            int di = num / multiple;
            res.append(convert(map, di % 10, multiple));
            multiple /= 10;
        }

        return res.toString();
    }
}
