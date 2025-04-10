"""
Given an integer numRows, return the first numRows of Pascal's triangle.

In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:

.

Example 1:

Input: numRows = 5
Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
Example 2:

Input: numRows = 1
Output: [[1]]
 

Constraints:

1 <= numRows <= 30

"""

class Solution(object):
    def generate(self, numRows):
        
        if numRows == 0:            #handling edge cases
            return []
        
        pascal = [[1]]              #initialize first row

        for row in range(1,numRows):
            prev_row = pascal[row - 1]           #to access previous rows
            current_row = [1]                    #first and last element will always be 1.

            for term in range(1,row):                                 #we will not enter this loop at the very first iteration. i.e, 2nd row
                current_row.append(prev_row[term] + prev_row[term - 1])    # can access this directly like 
                                                                           # {pascal[row - 1][term] + pascal[row - 1][term - 1]} 
                                                                           # instead of using a separate variable for holding the previous row.
            
            current_row.append(1)
            pascal.append(current_row)
        return pascal    

