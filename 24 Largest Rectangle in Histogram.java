// Given an array of integers heights representing the histogram's bar height where the width of each bar is 1, return the area of the largest rectangle in the histogram.

// Example 1:
// Input: heights = [2,1,5,6,2,3]
// Output: 10
// Explanation: The above is a histogram where width of each bar is 1.
// The largest rectangle is shown in the red area, which has an area = 10 units.

// Example 2:
// Input: heights = [2,4]
// Output: 4
 
// Constraints:
// 1 <= heights.length <= 105
// 0 <= heights[i] <= 104

class Solution {
    public int largestRectangleArea(int[] heights) {
        int max = 0, N = heights.length;

        int[] left = monotonicLeft(heights, N);
        int[] right = monotonicRight(heights, N);

        for(int i=0; i<N; i++){
            int widthLeft = i - (left[i] + 1);
            int widthRight = (right[i] -1) - i;

            int width
             = 1 + widthLeft + widthRight;

            max = Math.max(max, width * heights[i]);
        }
        return max;
    }
    private static int[] monotonicLeft(int[] arr, int N){
        Stack<Integer> stack = new Stack<>();   
        int[] res = new int[N];

        for(int i=0; i<N; i++){
            while(!stack.isEmpty() && arr[stack.peek()] >= arr[i])
                stack.pop();

            if(stack.isEmpty())    
                res[i] = -1;
            else
                res[i] = stack.peek();

            stack.push(i);
        }

        return res;
    }
    private static int[] monotonicRight(int[] arr, int N){
        Stack<Integer> stack = new Stack<>();   
        int[] res = new int[N];

        for(int i=N-1; i >= 0; i--){
            while(!stack.isEmpty() && arr[stack.peek()] >= arr[i])
                stack.pop();

            if(stack.isEmpty())    
                res[i] = N;
            else
                res[i] = stack.peek();

            stack.push(i);
        }

        return res;
    }
}

class Solution {
    public int largestRectangleArea(int[] heights) {
        int max = 0, N = heights.length;

        Stack<Integer> stack = new Stack<>();

        for(int i=0; i<=N; i++){
            int tall = (i != N) ? heights[i]: 0;

            while(!stack.isEmpty() && heights[stack.peek()] >= tall){
                int tempHeight =  heights[stack.pop()] ;

                int width;

                if(stack.isEmpty())
                    width = i;     // no more elemts lesser than current tower
                else
                    width = i - stack.peek() - 1;   // left - right - 1 window length logic

                max = Math.max(max, width * tempHeight);
            }

            stack.push(i);
        }

        return max;
        
    }
}