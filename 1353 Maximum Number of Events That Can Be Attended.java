// You are given an array of events where events[i] = [startDayi, endDayi]. Every event i starts at startDayi and ends at endDayi.
// You can attend an event i at any day d where startTimei <= d <= endTimei. You can only attend one event at any time d.
// Return the maximum number of events you can attend.

// Example 1:
// Input: events = [[1,2],[2,3],[3,4]]
// Output: 3
// Explanation: You can attend all the three events.
// One way to attend them all is as shown.
// Attend the first event on day 1.
// Attend the second event on day 2.
// Attend the third event on day 3.

// Example 2:
// Input: events= [[1,2],[2,3],[3,4],[1,2]]
// Output: 4
 
// Constraints:
// 1 <= events.length <= 105
// events[i].length == 2
// 1 <= startDayi <= endDayi <= 105


import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    public int maxEvents(int[][] events) {
        Arrays.sort(events, (a, b) -> (a[0] == b[0]) ? Integer.compare(a[1], b[1]): Integer.compare(a[0], b[0]));
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        int attended = 0;
        int day = events[0][0];
        int i = 0, N = events.length;

        while(i < N || !minHeap.isEmpty()){
            if(minHeap.isEmpty())
                day = events[i][0];

            while(i < N && events[i][0] == day){
                minHeap.offer(events[i][1]);
                i++;
            }    

            while(!minHeap.isEmpty() && day > minHeap.peek()){
                minHeap.poll();
            }

            if(!minHeap.isEmpty()){
                attended++;
                minHeap.poll();
                day++;
            }
        }

        return attended;
    }
}