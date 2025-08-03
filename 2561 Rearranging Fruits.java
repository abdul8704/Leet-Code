// You have two fruit baskets containing n fruits each. You are given two 0-indexed integer arrays basket1 and basket2 representing the cost of fruit in each basket. You want to make both baskets equal. To do so, you can use the following operation as many times as you want:
// Choose two indices i and j, and swap the ith fruit of basket1 with the jth fruit of basket2.
// The cost of the swap is min(basket1[i], basket2[j]).
// Two baskets are considered equal if sorting them according to the fruit cost makes them exactly the same baskets.
// Return the minimum cost to make both the baskets equal or -1 if impossible.

// Example 1:
// Input: basket1 = [4,2,2,2], basket2 = [1,4,1,2]
// Output: 1
// Explanation: Swap index 1 of basket1 with index 0 of basket2, which has cost 1. Now basket1 = [4,1,2,2] and basket2 = [2,4,1,2]. Rearranging both the arrays makes them equal.
// Example 2:

// Input: basket1 = [2,3,4,1], basket2 = [3,2,5,1]
// Output: -1
// Explanation: It can be shown that it is impossible to make both the baskets equal.
 
// Constraints:
// basket1.length == basket2.length
// 1 <= basket1.length <= 105
// 1 <= basket1[i], basket2[i] <= 109


class Solution {
    public long minCost(int[] basket1, int[] basket2) {
        Map<Integer, Integer> map = new HashMap<>();
        long count = 0; int m = Integer.MAX_VALUE;

        for(int fruit: basket1){
            map.put(fruit, map.getOrDefault(fruit, 0) + 1);
            m = Math.min(m, fruit);
        }

        for(int fruit: basket2){
            map.put(fruit, map.getOrDefault(fruit, 0) - 1); 
            m = Math.min(m, fruit);
        }

        List<Integer> toSwap = new ArrayList<>();    

        for(var entry: map.entrySet()){
            int key = entry.getKey();

            int freq = map.get(key);

            if((freq & 1) == 1)
                return -1;

            int swaps = Math.abs(map.get(key)) / 2; 
            
            for(int i=0; i<swaps; i++)
                toSwap.add(key);
        }      

        Collections.sort(toSwap);

        for(int i=0; i<toSwap.size() / 2; i++){
            count += Math.min((long)toSwap.get(i), m*2); // refer to note below
        }

        return count;
    }
}

/*
imagine we have basket1 = [1, 10, 10]
                basket2 = [1, 20, 20]

    now in line 35, if we just swapped it directly, i.e, swap 10 and 20, the cost would be 10.
    instead we swap twice with 1.
    i.e, 

    first swap = (swap 1 and 10) = b1 = [1, 1, 10]  
                                   b2 = [10, 20, 20] 

    second swap = (swap 1 and 20) = b1 = [1, 20, 10]
                                    b2 = [10, 1, 20]

    now cost was just 2.               

    hence, instead of making a direct swap, we can swap twice with min element, inorder to achieve the same goal.
 */