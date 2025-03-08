// Given two positive integers left and right, find the two integers num1 and num2 such that:
// left <= num1 < num2 <= right .
// Both num1 and num2 are prime numbers.
// num2 - num1 is the minimum amongst all other pairs satisfying the above conditions.
// Return the positive integer array ans = [num1, num2]. If there are multiple pairs satisfying these conditions, return the one with the smallest num1 value. If no such numbers exist, return [-1, -1].

// Example 1:
// Input: left = 10, right = 19
// Output: [11,13]
// Explanation: The prime numbers between 10 and 19 are 11, 13, 17, and 19.
// The closest gap between any pair is 2, which can be achieved by [11,13] or [17,19].
// Since 11 is smaller than 17, we return the first pair.

// Example 2:
// Input: left = 4, right = 6
// Output: [-1,-1]
// Explanation: There exists only one prime number in the given range, so the conditions cannot be satisfied.
 
// Constraints:
// 1 <= left <= right <= 106

class Solution {
    public int[] closestPrimes(int left, int right) {
        boolean notPrime[] = new boolean[right + 1];
        notPrime[1] = true;

        for(int i=2; i<=right; i++){
            if(!notPrime[i]){
                for(int j=i+i; j<= right; j += i){
                    notPrime[j] = true;
                }
            }
        }

        int a = -1, b = -1, one = -1, two = -1;
        int i=left, len = Integer.MAX_VALUE;

        while(i <= right){
            if(!notPrime[i]){
                if(a != -1){
                    b = i;
                    if(b-a <= 2){
                        return new int[]{a, b};  
                    }
                    if(b-a < len){
                        one = a;
                        two = b;
                        len = b - a;
                    }
                    a=b;
                }
                a = i;
            }
            i++;
        }

        if(two == -1)
            return new int[]{-1, -1};

        return new int[]{one, two};    

    }
}

class Solution2 {
    public int[] closestPrimes(int left, int right) {
        int a = -1, b = -1, one = -1, two = -1;
        int i=left, len = Integer.MAX_VALUE;

        while(i <= right){
            if(isPrime(i)){
                if(a != -1){
                    b = i;
                    if(b-a <= 2)   return new int[]{a, b};  
                    
                    if(b-a < len){
                        one = a;
                        two = b;
                        len = b - a;
                    }
                    a = b;
                }
                a = i;
            }
            i++;
        }

        if(two == -1)
            return new int[]{-1, -1};

        return new int[]{one, two};    
    }
    private static boolean isPrime(int n){
        if (n == 1)   return false;
        if (n <= 3)   return true;
        if (n%2 == 0) return false;
        
        for(int i=3; i<=Math.sqrt(n); i++){
            if(n%i == 0)
                return false;
        }

        return true;

    }
}

