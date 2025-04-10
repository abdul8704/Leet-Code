// Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.

// Assume the environment does not allow you to store 64-bit integers (signed or unsigned).

 

// Example 1:

// Input: x = 123
// Output: 321
// Example 2:

// Input: x = -123
// Output: -321
// Example 3:

// Input: x = 120
// Output: 21
 

// Constraints:

// -231 <= x <= 231 - 1

class Solution {
    public int reverse(int x) {
        long rev = 0;

        while (x != 0){
            rev = (rev * 10) + (x%10);
            x /= 10;
        }
        if(rev > Integer.MAX_VALUE || rev < Integer.MIN_VALUE){
                return 0;
        }
        return (int) rev;
    }
}

//a better solution i found....

class Solution {
    public int reverse(int x) {
        int rev = 0;  // To store the reversed number
        while (x != 0) {  // Process each digit until x becomes 0
            int temp = x % 10;  // Extract the last digit of x
            x = x / 10;  // Remove the last digit from x

            // Check for overflow conditions before multiplying rev by 10 and adding temp
            // If rev is positive, check if rev > (Integer.MAX_VALUE - temp) / 10
            // If rev is negative, check if rev < (Integer.MIN_VALUE - temp) / 10
            if (rev > 0 && rev > (Integer.MAX_VALUE - temp) / 10 || 
                rev < 0 && rev < (Integer.MIN_VALUE - temp) / 10)  
                return 0;  // Return 0 in case of overflow
            
            rev = rev * 10 + temp;  // Update rev by appending the extracted digit
        }
        return rev;  // Return the reversed integer
    }
}
