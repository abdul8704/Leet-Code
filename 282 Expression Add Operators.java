// Given a string num that contains only digits and an integer target, return all possibilities to insert the binary operators '+', '-', and/or '*' between the digits of num so that the resultant expression evaluates to the target value.
// Note that operands in the returned expressions should not contain leading zeros.
// Note that a number can contain multiple digits.

// Example 1
// Input: num = "123", target = 6
// Output: ["1*2*3","1+2+3"]
// Explanation: Both "1*2*3" and "1+2+3" evaluate to 6.

// Example 2:
// Input: num = "232", target = 8
// Output: ["2*3+2","2+3*2"]
// Explanation: Both "2*3+2" and "2+3*2" evaluate to 8.

// Example 3:
// Input: num = "3456237490", target = 9191
// Output: []
// Explanation: There are no expressions that can be created from "3456237490" to evaluate to 9191.
 
// Constraints:
// 1 <= num.length <= 10
// num consists of only digits.
// -231 <= target <= 231 - 1

class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> ans = new ArrayList<>();

        helper(num, ans, target, 0, 0, 0, 0, new StringBuilder());
        return ans;
    }
    private static void helper(String nums, List<String> ans, int target, int idx, long prev, long sum, long currentVal, StringBuilder exp){
        if(idx == nums.length()){
            if(target == sum && currentVal == 0){
                ans.add(exp.toString());
            }
            return;
        }

        long digit = (currentVal*10) +  (long)(nums.charAt(idx) - '0');

        //addition 
        StringBuilder add = new StringBuilder(String.valueOf(exp));
        helper(nums, ans, target, idx+1, digit, sum + digit, 0, 
        exp.length() == 0 ? new StringBuilder(String.valueOf(digit)): add.append('+').append(digit) );

        //subraction
        if(exp.length() > 0){
            StringBuilder sub = new StringBuilder(String.valueOf(exp));
            helper(nums, ans, target, idx+1, -digit, sum - digit, 0, 
            sub.append('-').append(digit) );

            StringBuilder mul = new StringBuilder(String.valueOf(exp));
            helper(nums, ans, target, idx+1, prev * digit, (sum - prev) + (digit * prev), 0,
            mul.append('*').append(digit));
        }

        boolean isLeadingZero = currentVal == 0 && nums.charAt(idx) == '0';

        if (!isLeadingZero) {
            helper(nums, ans, target, idx + 1, prev, sum, digit, exp);
        }
        
    }
}