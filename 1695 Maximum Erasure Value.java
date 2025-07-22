// You are given an array of positive integers nums and want to erase a subarray containing unique elements. The score you get by erasing the subarray is equal to the sum of its elements.
// Return the maximum score you can get by erasing exactly one subarray.
// An array b is called to be a subarray of a if it forms a contiguous subsequence of a, that is, if it is equal to a[l],a[l+1],...,a[r] for some (l,r).

// Example 1:
// Input: nums = [4,2,4,5,6]
// Output: 17
// Explanation: The optimal subarray here is [2,4,5,6].

// Example 2:
// Input: nums = [5,2,1,2,5,2,1,2,5]
// Output: 8
// Explanation: The optimal subarray here is [5,2,1] or [1,2,5].
 
// Constraints:
// 1 <= nums.length <= 105
// 1 <= nums[i] <= 104

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        int sum = 0, N = nums.length, maxSum = 0, res = 0, left = 0;

        int[] prefix = new int[N];
        
        for(int i=0; i<N; i++){
            sum += nums[i];
            prefix[i] = sum;

            if(map.containsKey(nums[i]) && map.get(nums[i]) >= left){
                left = map.get(nums[i]) + 1;
                maxSum = (sum - prefix[left-1]);
            }
            else{
                maxSum += nums[i]; 
            }

            map.put(nums[i], i);
            res = Math.max(res, maxSum);
        }

        return res;
    }
}

class Solution2 {
    public int maximumUniqueSubarray(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int sum = 0, res = 0;
        int left = 0;

        for(int right = 0; right<nums.length; right++){
            sum += nums[right];

            while(set.contains(nums[right])){
                set.remove(nums[left]);
                sum -= nums[left++];
            }

            set.add(nums[right]);
            res = Math.max(res, sum);
        }   

        return res;
    }
}