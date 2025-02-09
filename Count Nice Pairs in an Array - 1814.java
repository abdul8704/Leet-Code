import java.util.HashMap;

class Solution {
    private static int rev(int n){
        int rev = 0;
        while(n != 0){
            rev = (rev*10) + (n%10);
            n /= 10;
        }
        return rev;
    }
    public int countNicePairs(int[] nums) {
        int N = nums.length;
        int totalPairs = (N*(N-1)) / 2;
        int nicePairs = 0;

        HashMap<Integer, Integer> hash = new HashMap<>();
        int MOD = (1000000000 + 7);

        for(int i=0; i<N; i++){
            int num = nums[i] - rev(nums[i]);

            // if(hash.containsKey(num)){
            //     int pairs = hash.get(num) % MOD;
            //     nicePairs = (nicePairs + pairs) % MOD;
            //     hash.put(num, (pairs + 1)%MOD);
            // }
            // else{
            //     hash.put(num,  1);
            // }
            int freq = hash.getOrDefault(num, 0);
            nicePairs = (nicePairs + freq) % MOD;
            hash.put(num, (freq + 1)% MOD);
        }
        return (nicePairs%MOD);

    }
}