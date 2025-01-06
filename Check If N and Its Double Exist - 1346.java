// Given an array arr of integers, check if there exist two indices i and j such that :

// i != j
// 0 <= i, j < arr.length
// arr[i] == 2 * arr[j]
 

// Example 1:

// Input: arr = [10,2,5,3]
// Output: true
// Explanation: For i = 0 and j = 2, arr[i] == 10 == 2 * 5 == 2 * arr[j]
// Example 2:

// Input: arr = [3,1,7,11]
// Output: false
// Explanation: There is no i and j that satisfy the conditions.
 

// Constraints:

// 2 <= arr.length <= 500
// -103 <= arr[i] <= 103

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

class Solution {
    public boolean checkIfExist(int[] arr) {    //Using Hashset, linear time and linear space complexity.
        HashSet<Integer> seen = new HashSet<>();
        
        for(int num: arr){
            if(seen.contains(num * 2)) 
                return true;
            if(num % 2 == 0 && seen.contains(num / 2))
                return true; 
            seen.add(num);
        }
        return false;
    }
}

class Solution2 {
    public boolean checkIfExist(int[] arr) {    //Using sorting & Binary Search. O(nlogn) time and O(1) space 
        Arrays.sort(arr);
        
        for(int i = 0; i < arr.length; i++){
            int left = 0, right = arr.length - 1, mid = (left + right) / 2;
            while(left <= right){
                mid = (left + right) / 2;
                if (arr[mid] == arr[i] * 2 && mid != i)
                    return true;
                else if(arr[mid] > arr[i] * 2)
                    right = mid - 1;   
                else
                    left = mid + 1; 
            }

        }
        return false;
    }
}

class Solution3 {
    public boolean checkIfExist(int[] arr) { //Using HashMap. O(N) time and O(N) space.
        Map<Integer, Integer> hash = new HashMap<>();

        for(int num: arr){
                hash.put(num, hash.getOrDefault(num, 0) + 1);
        }
        for(int num: arr){
            if(num == 0 && hash.get(0) > 1)
                return true;
            if(num != 0 && hash.get(num * 2) != null)    
                return true;    
        }
        return false;
    }
}