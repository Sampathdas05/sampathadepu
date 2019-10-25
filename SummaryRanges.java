package ArraysAndStrings;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<>();
        if(nums.length == 0){
            return list;
        }
            for(int i=0, j=0; i<nums.length; i++){
                j=i;
                    while(i+1<nums.length && nums[i]+1 == nums[i+1]){
                        ++i;
                }
                if(i==j){
                    list.add(nums[j] + "");
                }
                else{
                    list.add("" + nums[j] + "->" + nums[i] + "");
                }
            }
        return list;
    }
	public static void main(String[] args) {
		SummaryRanges sr = new SummaryRanges();
		System.out.println(sr.summaryRanges(new int[]{0,1,2,4,5,7}));
	}

}
