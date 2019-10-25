package BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Combination {
	public int combinationSum(int[] nums, int target) {
	    List<List<Integer>> list = new ArrayList<>();
	    backtrack(list, new ArrayList<>(), nums, target, 0);
	    return list.size();
	}

	private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums, int remain, int start){
	    if(remain < 0) 
	    	return;
	    else if(remain == 0) 
	    	list.add(new ArrayList<>(tempList));
	    else{ 
	        for(int i = start; i < nums.length; i++){
	            tempList.add(nums[i]);
	            backtrack(list, tempList, nums, remain - nums[i], i); // not i + 1 because we can reuse same elements
	            tempList.remove(tempList.size() - 1);
	        }
	    }
	}
	public static void main(String[] args) {
Combination com = new Combination();
int[] nums = new int[]{1,2};

int target = 3;
int list = com.combinationSum(nums, target);
System.out.println(list);
	}

}
