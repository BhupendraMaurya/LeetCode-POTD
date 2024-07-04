import java.util.Arrays;

public class Frequency_Of_Most_Frequent_Element {
    
    // using sliding window approach
    public int maxFrequency(int[] nums, int k) {
        // sorting the array so that all the nearest elements could come closer.
        Arrays.sort(nums);

        // taking two pointers, 
        int left = 0;
        int right = 0;
        int n = nums.length;

        long ans = 0;
        long sum = 0;

        // go till last index
        while(right < n){
            // keep adding current value to sum
            sum += nums[right];

            // if not possible to make equal all elements of current window, then 
            // shrink your window: use pen and paper to understand this condtion
            while((right - left +1L) * nums[right] - sum > k){
                sum -= nums[left];
                left++;
            }

            // find the current maximum

            ans = Math.max(ans, right - left + 1L);
            right++;
        }

        return (int)ans;
    }
}
