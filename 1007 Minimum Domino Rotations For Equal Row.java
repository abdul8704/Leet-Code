// In a row of dominoes, tops[i] and bottoms[i] represent the top and bottom halves of the ith domino. (A domino is a tile with two numbers from 1 to 6 - one on each half of the tile.)
// We may rotate the ith domino, so that tops[i] and bottoms[i] swap values.
// Return the minimum number of rotations so that all the values in tops are the same, or all the values in bottoms are the same.
// If it cannot be done, return -1.

// Example 1:
// Input: tops = [2,1,2,4,2,2], bottoms = [5,2,6,2,3,2]
// Output: 2
// Explanation: 
// The first figure represents the dominoes as given by tops and bottoms: before we do any rotations.
// If we rotate the second and fourth dominoes, we can make every value in the top row equal to 2, as indicated by the second figure.

// Example 2:
// Input: tops = [3,5,1,2,3], bottoms = [3,6,3,3,4]
// Output: -1
// Explanation: 
// In this case, it is not possible to rotate the dominoes to make one row of values equal.
 
// Constraints:
// 2 <= tops.length <= 2 * 104
// bottoms.length == tops.length
// 1 <= tops[i], bottoms[i] <= 6

class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int minSwap = Integer.MAX_VALUE;

        int try1 = swapify(tops, bottoms, majority(tops));
        int try2 = swapify(bottoms, tops, majority(bottoms));
        return (try1 == 20001 && try2 == 20001) ? -1: Math.min(try1, try2);
    }
    private static int majority(int[] arr){
        int res = arr[0], count = 1;

        for(int num: arr){
            if(num == res) count++;
            else{
                count--;
                if(count == 0){
                    count = 1;
                    res= num;
                }
            }
        }
        return res;
    }
    private static int swapify(int[] arr1, int[] arr2, int major){
        int swap = 0;

        for(int i=0, n=arr1.length; i<n; i++){
            if(arr1[i] == major)
                continue;
            else{
                if(arr2[i] == major)
                    swap++;
                else
                    return 20001;    
            }
        }
        return swap;
    }
}