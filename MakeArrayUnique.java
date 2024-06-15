import java.util.Arrays;
//❌ https://leetcode.com/problems/minimum-increment-to-make-array-unique/?envType=daily-question&envId=2024-06-14
import java.util.HashMap;


public class MakeArrayUnique {
    // Brute force approach : Gives TLE
    public int minIncrementForUnique2(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        int cnt = 0;

        for (int i = 0; i < nums.length; i++) {
            while (map.get(nums[i]) > 1) {
                int nextNum = nums[i] + 1;

                // Find the next available number that is not already used
                while (map.containsKey(nextNum)) {
                    nextNum++;
                }

                // Add the new number to the map with a frequency of 1
                map.put(nextNum, 1);
                // Update the count of increments needed
                cnt += nextNum - nums[i];
                // Decrement the frequency of the current number
                map.put(nums[i], map.get(nums[i]) - 1);
            }
        }

        return cnt;
    }
    public int minIncrementForUnique(int[] nums) {
        //Sorting so that all the same elements come adjacent to each other and it would be easier to manage the elements.
        Arrays.sort(nums);
        
        int cnt = 0;

        for(int i=1;i<nums.length;i++){
            // if current value is less than or equal to prev value, then
            // find that, how much it is less than, ad update current value;
            if(nums[i] <= nums[i-1]){
                cnt += nums[i-1] - nums[i] +1;
                nums[i] = nums[i-1] + 1;
            }
        }

        return cnt;

    }
}
