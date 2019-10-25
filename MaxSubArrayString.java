package ArraysAndStrings;

import java.util.HashMap;
/**
 * Given an array nums and a target value k, find the maximum length of a subarray that sums to k. If there isn't one, return 0 instead.

Note:
The sum of the entire nums array is guaranteed to fit within the 32-bit signed integer range.

Example 1:

Input: nums = [1, -1, 5, -2, 3], k = 3
Output: 4 
Explanation: The subarray [1, -1, 5, -2] sums to 3 and is the longest.
Example 2:

Input: nums = [-2, -1, 2, 1], k = 1
Output: 2 
Explanation: The subarray [-1, 2] sums to 1 and is the longest.
Follow Up:
Can you do it in O(n) time?
 * @author SA044034
 *
 */
public class MaxSubArrayString {
	public static int maxSubArrayLen(int[] nums, int k) {
	    int sum = 0, max = 0;
	    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
	    for (int i = 0; i < nums.length; i++) {
	        sum = sum + nums[i];
	        if (sum == k){
	        	max = i + 1;
	        }
	        else if (map.containsKey(sum - k)){
	        	max = Math.max(max, i - map.get(sum - k));
	        }
	        if (!map.containsKey(sum)) {
	        	map.put(sum, i);
	        }
	    }
	    return max;
	}
	  public static int maxSubArray(int[] nums) {
	      int maxSum = nums[0];
	      int maxSumHere = nums[0];
	        
	        for(int i = 1; i < nums.length; i++){
	            maxSumHere = Math.max(maxSumHere + nums[i], nums[i]);
	            maxSum = Math.max(maxSum, maxSumHere);
	        }
	        return maxSum;
	    } 
	public static void main(String[] args) {
		int [] nums = new int[] {-2, 1, -3, 4, -1, 2, 1, -5, 4};
		int k = 6;
		System.out.println(maxSubArrayLen(nums, k));
	}

}
