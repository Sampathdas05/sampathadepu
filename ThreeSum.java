package ArraysAndStrings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> threeSum = new ArrayList<List<Integer>>();
        if(nums.length == 0){
            return threeSum;
        }
        Arrays.sort(nums);
        for(int i=0; i<nums.length-1;i++){
            int j = i+1, k=nums.length -1;
            while(j<k){
                if(nums[i] + nums[j] + nums[k]  == 0){
                    threeSum.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                }
                else if(nums[i] + nums[j] + nums[k] < 0){
                    j++;
                }
                else{
                    k--;
                }
            }
        }
        return threeSum;
    }
	public static void main(String[] args) {
		ThreeSum threeSum = new ThreeSum();
		int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
		System.out.println(threeSum.threeSum(nums));
	}

}
