package ArraysAndStrings;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:

Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
 * @author SA044034
 *
 */
public class TwoSum {
	 public static int[] twoSum(int[] nums, int target) {

	        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	        for(int i=0; i<nums.length; i++){
	            int diff = target - nums[i];
	            if(map.containsKey(diff)){
	                return new int[]{map.get(diff), i};
	            }
	            map.put(nums[i], i);
	        }
	        return new int[0];
	    }
	 
	   public static int[] twoSum1(int[] numbers, int target) {
	        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
	        for(int i=0; i<numbers.length; i++){
	            map.put(numbers[i], i);
	            int diff = target - numbers[i];
	            if(map.containsKey(diff)){
	                return new int[]{map.get(diff)+1,i+1};
	            }
	        }
	        return new int[2];
	    }
	public static void main(String[] args) {
		int[] nums = new int[]{2,3};
		twoSum1(nums, 9);

	}

}
