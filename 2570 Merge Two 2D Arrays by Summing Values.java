// You are given two 2D integer arrays nums1 and nums2.

// nums1[i] = [idi, vali] indicate that the number with the id idi has a value equal to vali.
// nums2[i] = [idi, vali] indicate that the number with the id idi has a value equal to vali.
// Each array contains unique ids and is sorted in ascending order by id.

// Merge the two arrays into one array that is sorted in ascending order by id, respecting the following conditions:

// Only ids that appear in at least one of the two arrays should be included in the resulting array.
// Each id should be included only once and its value should be the sum of the values of this id in the two arrays. If the id does not exist in one of the two arrays, then assume its value in that array to be 0.
// Return the resulting array. The returned array must be sorted in ascending order by id.

 

// Example 1:
// Input: nums1 = [[1,2],[2,3],[4,5]], nums2 = [[1,4],[3,2],[4,1]]
// Output: [[1,6],[2,3],[3,2],[4,6]]
// Explanation: The resulting array contains the following:
// - id = 1, the value of this id is 2 + 4 = 6.
// - id = 2, the value of this id is 3.
// - id = 3, the value of this id is 2.
// - id = 4, the value of this id is 5 + 1 = 6.

// Example 2:
// Input: nums1 = [[2,4],[3,6],[5,5]], nums2 = [[1,3],[4,3]]
// Output: [[1,3],[2,4],[3,6],[4,3],[5,5]]
// Explanation: There are no common ids, so we just include each id with its value in the resulting list.
 
// Constraints:

// 1 <= nums1.length, nums2.length <= 200
// nums1[i].length == nums2[j].length == 2
// 1 <= idi, vali <= 1000
// Both arrays contain unique ids.
// Both arrays are in strictly ascending order by id.

import java.util.ArrayList;
import java.util.Arrays;

class Solution {    // list approach
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        ArrayList<int[]> res = new ArrayList<>();
        int p1=0, p2=0;
        int N1 = nums1.length, N2= nums2.length;

        while(p1 < N1 && p2 < N2){

            if(nums1[p1][0] == nums2[p2][0])
                res.add(new int[]{ nums1[p1][0], nums1[p1++][1] + nums2[p2++][1] });
            
            else if(nums1[p1][0] < nums2[p2][0])
                res.add(new int[]{ nums1[p1][0], nums1[p1++][1] });
            
            else
                res.add(new int[]{ nums2[p2][0], nums2[p2++][1] });
            
        }
        while(p1 < N1)
            res.add(new int[]{ nums1[p1][0], nums1[p1++][1] });
        
        while(p2 < N2)
            res.add(new int[]{ nums2[p2][0], nums2[p2++][1] });
        

        return res.toArray(new int[res.size()][]);
    }
}

class Solution2 {  // int[][] approach
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        int N = nums1.length+ nums2.length;
        int res[][] = new int[N][2];
        int i=0, p1=0, p2=0;

        while(p1 < nums1.length && p2< nums2.length){
            if(nums1[p1][0] == nums2[p2][0]){
                res[i][0] = nums1[p1][0];
                res[i][1] = nums1[p1][1] + nums2[p2][1];
                p1++;
                p2++;
            }
            else if(nums1[p1][0] < nums2[p2][0]){
                res[i][0] = nums1[p1][0];
                res[i][1] = nums1[p1][1];
                p1++;
            }
            else{
                res[i][0] = nums2[p2][0];
                res[i][1] = nums2[p2][1];
                p2++;
            }
            i++;
        }
        while(p1 < nums1.length){
            res[i][0] = nums1[p1][0];
            res[i][1] = nums1[p1][1];
            p1++; i++;
        }
        while(p2< nums2.length){
            res[i][0] = nums2[p2][0];
            res[i][1] = nums2[p2][1];
            p2++; i++;
        }

        return Arrays.copyOfRange(res, 0, i);
    }
}