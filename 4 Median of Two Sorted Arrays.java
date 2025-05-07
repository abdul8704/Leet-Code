// Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
// The overall run time complexity should be O(log (m+n)).

// Example 1:
// Input: nums1 = [1,3], nums2 = [2]
// Output: 2.00000
// Explanation: merged array = [1,2,3] and median is 2.

// Example 2:
// Input: nums1 = [1,2], nums2 = [3,4]
// Output: 2.50000
// Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
 
// Constraints:
// nums1.length == m
// nums2.length == n
// 0 <= m <= 1000
// 0 <= n <= 1000
// 1 <= m + n <= 2000
// -106 <= nums1[i], nums2[i] <= 106

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length, total = n+m;
        if(n > m) return findMedianSortedArrays(nums2, nums1);

        int part_size = ( n+m+1 ) / 2;

        int left = 0, right = n;
        double res = 0, elem1 = -1, elem2 = -1;

        while(left <= right){
            int mid = (left + right) / 2;

            int l1 = -1_000_001, l2 = -1_000_001, r1 = 1_000_001, r2 = 1_000_001;

            if (mid - 1 >= 0) l1 = nums1[mid-1];
            if (mid < n) r1 = nums1[mid];
            if (part_size - mid - 1 >= 0) l2 = nums2[part_size - mid - 1];
            if (part_size - mid < m) r2 = nums2[part_size - mid];
            

            if(l1 > r2)
                right = mid - 1;
            else if(l2 > r1)
                left = mid + 1;
            else{
                elem1 = (double) Math.max(l1, l2);
                elem2 = (double) Math.min(r1, r2);
                break;
            }    
        }
        
        if((total & 1) == 1)
            return elem1;
        return (elem1 + elem2) / 2.0;    
    }
}