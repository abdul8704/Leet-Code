// A permutation of an array of integers is an arrangement of its members into a sequence or linear order.

// For example, for arr = [1,2,3], the following are all the permutations of arr: [1,2,3], [1,3,2], [2, 1, 3], [2, 3, 1], [3,1,2], [3,2,1].
// The next permutation of an array of integers is the next lexicographically greater permutation of its integer. More formally, if all the permutations of the array are sorted in one container according to their lexicographical order, then the next permutation of that array is the permutation that follows it in the sorted container. If such arrangement is not possible, the array must be rearranged as the lowest possible order (i.e., sorted in ascending order).

// For example, the next permutation of arr = [1,2,3] is [1,3,2].
// Similarly, the next permutation of arr = [2,3,1] is [3,1,2].
// While the next permutation of arr = [3,2,1] is [1,2,3] because [3,2,1] does not have a lexicographical larger rearrangement.
// Given an array of integers nums, find the next permutation of nums.

// The replacement must be in place and use only constant extra memory.

// Example 1:

// Input: nums = [1,2,3]
// Output: [1,3,2]
// Example 2:

// Input: nums = [3,2,1]
// Output: [1,2,3]
// Example 3:

// Input: nums = [1,1,5]
// Output: [1,5,1]
 

// Constraints:

// 1 <= nums.length <= 100
// 0 <= nums[i] <= 100

class Solution {
    void nextPermutation(int[] arr) {
        int idx = -1, i = 0, j = 0;   //STEP 1: Find the break point

        for(i = arr.length - 2; i>=0; i--){     //always traverse from last to find the breakpoint.
            if (arr[i] < arr[i+1]){
                idx = i;
                break;
            }
        }

        if(idx == -1){        //if breakpoint doesnt exist, it means given permutation is the last.
            i = 0;
            j = arr.length - 1;
            while(i < j){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
            return;
        }
        
        for(i = arr.length - 1; i>idx ;i--){    //STEP 2: find the element thats just greater than arr[i]. Swap once u find it.
            if(arr[i] > arr[idx]){
                int temp = arr[i];
                arr[i] = arr[idx];
                arr[idx] = temp;
                break;
            }
        }

        int temp[] = new int[arr.length - 1 - idx]; //temp array to sort the remaining array.
        j = 0;

        for(i = idx + 1; i < arr.length; i++){
            temp[j++] = arr[i];
        }

        Arrays.sort(temp);

        j = 0;
        for(i = idx + 1; i<arr.length; i++){    //replace remaining array with sorted array.
            arr[i] = temp[j++]; 
        }
        return;
    }
}