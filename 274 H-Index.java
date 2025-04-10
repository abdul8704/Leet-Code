// Given an array of integers citations where citations[i] is the number of citations a researcher received for their ith paper, return the researcher's h-index.
// According to the definition of h-index on Wikipedia: The h-index is defined as the maximum value of h such that the given researcher has published at least h papers that have each been cited at least h times.

// Example 1:

// Input: citations = [3,0,6,1,5]
// Output: 3
// Explanation: [3,0,6,1,5] means the researcher has 5 papers in total and each of them had received 3, 0, 6, 1, 5 citations respectively.
// Since the researcher has 3 papers with at least 3 citations each and the remaining two with no more than 3 citations each, their h-index is 3.

// Example 2:
// Input: citations = [1,3,1]
// Output: 1
 

// Constraints:

// n == citations.length
// 1 <= n <= 5000
// 0 <= citations[i] <= 1000

class Solution {
    public int hIndex(int[] citations) {    //impplement count sort
        int n = citations.length;
        int[] paper_count = new int[n+1];
        
        for(int i=0; i<n; i++){
            if(citations[i] > n)
                paper_count[n]++;
            else
                paper_count[citations[i]]++;
        }
        
        int papers = 0;
        for(int i=n; i>=0 ;i--){
            papers += paper_count[i];
            if(i <= papers){
                return i;
            }
        }
        return 0;
    }
    public int hIndex(int[] citations) { //sort the array and then binary search
        Arrays.sort(citations);
        int h = 0, n = citations.length;
        int left = 0, right = n-1, mid = 0;

        while(left <= right){
            mid = left + (right - left)/2;

            if(citations[mid] == n-mid){
                return citations[mid];
            }
            else if(citations[mid] < n-mid){
                left = mid +1;
            }
            else{
                right = mid - 1;
            }
        }
        return n-left;
    }
}