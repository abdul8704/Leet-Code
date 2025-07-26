// Given a list of non-negative integers nums, arrange them such that they form the largest number and return it.
// Since the result may be very large, so you need to return a string instead of an integer.

// Example 1:
// Input: nums = [10,2]
// Output: "210"

// Example 2:
// Input: nums = [3,30,34,5,9]
// Output: "9534330"
 
// Constraints:
// 1 <= nums.length <= 100
// 0 <= nums[i] <= 109

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Solution {
    public String largestNumber(int[] nums) {
        List<String> arr = new ArrayList<>();

        for(int num: nums)
            arr.add(String.valueOf(num));

        Collections.sort(arr, new NumberCompare());

        if(arr.get(0).equals("0"))
            return "0";

        StringBuilder res = new StringBuilder();
        
        for(String num: arr)
            res.append(num);

        return res.toString();    
    }
}

class NumberCompare implements Comparator<String> {
    @Override
    public int compare(String num1, String num2){
        int len1 = num1.length(), len2 = num2.length();
        int i = 0;

        while(i < len1 + len2){
            char c1 = (i < len1) ? num1.charAt(i): num2.charAt(i - len1);
            char c2 = (i < len2) ? num2.charAt(i): num1.charAt(i - len2);   

            if(c1 > c2)
                return -1;
            else if(c2 > c1)
                return 1;

            i++;
        }

        return 0;   
    }
}

class Solution2 {
    public String largestNumber(int[] nums) {
        List<Integer> arr = new ArrayList<>();

        for(int num: nums)
            arr.add(num);

        Collections.sort(arr, new NumberCompare());
        if(arr.get(0) == 0)
            return "0";
        StringBuilder res = new StringBuilder();

        for(Integer num: arr)
            res.append(String.valueOf(num));

        return res.toString();    
    }
}

class NumberCompare implements Comparator<Integer> {
    @Override
    public int compare(Integer num1, Integer num2){
        if(num1 == 0)
            return 1;
        if(num2 == 0)
            return -1;    

        int len1 = (int) Math.log10(num1) + 1;  
        int len2 = (int) Math.log10(num2) + 1;

        long comb1 = (long) num1 * (int)Math.pow(10, len2) + (long)num2;
        long comb2 = (long) num2 * (int)Math.pow(10, len1) + (long)num1;

        return Long.compare(comb2, comb1);
    }
}