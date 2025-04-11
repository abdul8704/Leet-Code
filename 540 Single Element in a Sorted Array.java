// You are given a sorted array consisting of only integers where every element appears exactly twice,
// except for one element which appears exactly once.

// Return the single element that appears only once.
// Your solution must run in O(log n) time and O(1) space.

// Example 1:
// Input: nums = [1,1,2,3,3,4,4,8,8]
// Output: 2

// Example 2:
// Input: nums = [3,3,7,7,10,11,11]
// Output: 10
 
// Constraints:
// 1 <= nums.length <= 105
// 0 <= nums[i] <= 105

class Solution {
    public int singleNonDuplicate(int[] nums) {
        int N = nums.length;
        if(N == 1) return nums[0];
        if(nums[0] != nums[1]) return nums[0];
        if(nums[N-1] != nums[N-2]) return nums[N-1];

        int left = 1, right = N - 2;

        while(left <= right){
            int mid = (right - left)/2 + left;

            if(nums[mid] != nums[mid-1] && nums[mid] != nums[mid+1])
                return nums[mid];
            else if(mid %2 == 0){
                if(nums[mid] != nums[mid+1]) 
                    right = mid-1;
                else
                    left = mid+1;    
            }
            else{
                if(nums[mid] != nums[mid-1]) 
                    right = mid-1;
                else
                    left = mid+1; 
            }    

        }
        return -1;
    }
}

class OptimisedSolution {
    public int singleNonDuplicate(int[] nums) {
        int N = nums.length;
        
        if(N == 1) return nums[0];
        if(nums[0] != nums[1]) return nums[0];
        if(nums[N-1] != nums[N-2]) return nums[N-1];

        int left = 1, right = N - 2;

        while(left <= right){
            int mid = (right - left)/2 + left;

            if(nums[mid] != nums[mid-1] && nums[mid] != nums[mid+1])
                return nums[mid];
            else if((mid %2 == 0 && nums[mid] != nums[mid+1]) || (mid%2==1 && nums[mid] != nums[mid-1])) 
                right = mid-1;
            else
                left = mid+1;     

        }
        return -1;
    }
}