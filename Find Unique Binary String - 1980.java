// Given an array of strings nums containing n unique binary strings each of length n, return a binary string of length n that does not 
// appear in nums. If there are multiple answers, you may return any of them.

// Example 1:
// Input: nums = ["01","10"]
// Output: "11"
// Explanation: "11" does not appear in nums. "00" would also be correct.

// Example 2:
// Input: nums = ["00","01"]
// Output: "11"
// Explanation: "11" does not appear in nums. "10" would also be correct.

// Example 3:
// Input: nums = ["111","011","001"]
// Output: "101"
// Explanation: "101" does not appear in nums. "000", "010", "100", and "110" would also be correct.
 
// Constraints:

// n == nums.length
// 1 <= n <= 16
// nums[i].length == n
// nums[i] is either '0' or '1'.
// All the strings of nums are unique.

import java.util.Arrays;
import java.util.HashSet;

class Solution {
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public String findDifferentBinaryString(String[] nums) {
        HashSet<String> set = new HashSet(Arrays.asList(nums)); 
        int N = nums[0].length();

        StringBuilder sb = new StringBuilder("");

        return generateBinary(sb, set, N);
        
    }
    private static String generateBinary(StringBuilder sb, HashSet<String> set, int N){
        if(sb.length() == N){
            if(!set.contains(sb.toString())){
                return sb.toString();
            }
            else{
                return "";
            }
        }

        //try 0
        sb.append(0);
        String res = generateBinary(sb, set, N);
        if(res != ""){
            return res;
        }
        sb.deleteCharAt(sb.length() - 1); // backtrack;

        // try 1
        sb.append(1);
        res = generateBinary(sb, set, N);
        if(res != ""){
            return res;
        }
        sb.deleteCharAt(sb.length() - 1);   // backtrack


        return "";
    }
}

class BruteForceSolution {
    public String findDifferentBinaryString(String[] nums) {
        int N = nums[0].length();
        int map[] = new int[(int)Math.pow(2,N)];

        for(String str: nums){
            map[binary(str)]++;
        }

        for(int i=0; i<map.length; i++){
            if(map[i] == 0){
                // System.out.println(i);
                String bin = Integer.toBinaryString(i);
                bin = ("0".repeat(N) + bin).substring(bin.length());
                return bin;
            }
        }
        // System.out.println(binary("0"));
        return "";
    }
    private static int binary(String str){
        int pow = 1;
        int res=0;
        for(int i=str.length()-1; i>=0; i--){
            if(((str.charAt(i) - '0') & 1) == 1){
                res += pow;
            }
            pow += pow;
        }

        return res;
        

    }
}