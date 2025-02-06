// Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.

// Example 1:
// Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
// Output: 6
// Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.

// Example 2:
// Input: height = [4,2,0,3,2,5]
// Output: 9
 
// Constraints:

// n == height.length
// 1 <= n <= 2 * 104
// 0 <= height[i] <= 105

class Solution {
    public int trap(int[] height) {
        int res = 0, water = 0; 
        int N = height.length;

        int left[] = new int[N]; int leftMax = height[0];
        int right[] = new int[N]; int rightMax = height[N-1];

        for(int i=0; i<height.length; i++){
            leftMax = Math.max(height[i], leftMax);
            rightMax = Math.max(height[N-i-1], rightMax);

            left[i] = leftMax;
            right[N-i-1] = rightMax;
        }

        for(int tower=0; tower < N; tower++){
            water += (Math.min(left[tower], right[tower]) - height[tower]);
        }
        return water;

    }
}

class OptimisedSolution {
    public int trap(int[] height) {
        int water = 0;
        int N = height.length;

        int leftPtr = 0, rightPtr = N-1;        // 
        int leftMax = 0, rightMax = 0;

        while(leftPtr < rightPtr){
            leftMax = Math.max(leftMax, height[leftPtr]);
            rightMax = Math.max(rightMax, height[rightPtr]);

            if(leftMax < rightMax){                 //not bothered about how tall the your right tower is.
                water += leftMax - height[leftPtr];     // water stags only from your tower TILL the tower just taller than you.
                leftPtr++;                          //move pointer
            }
            else{
                water += rightMax - height[rightPtr];
                rightPtr--;
            }
        }

        return water;
    }
}