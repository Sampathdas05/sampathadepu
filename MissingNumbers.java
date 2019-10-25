package ArraysAndStrings;

import java.util.Arrays;

public class MissingNumbers {
    public int missingNumber(int[] nums) {
        int[] find = new int[nums.length + 1];
        Arrays.fill(find, -1);
        for(int i =0; i<nums.length; i++){
            find[nums[i]] = nums[i];
        }
        if(find[0] != 0){
            return 0;
        }
        if(find[find.length - 1] != find.length - 1){
            return find.length - 1;
        }
        
        for(int i=1; i<find.length -1; i++){
            if(find[i] != i){
                return i;
            }
        }
        return -1;
    }
    // 1 ^ 1 = 0; 1 ^ 0 = 0; 
    public int missingNumber2(int[] nums) {
        int missing = nums.length;
        for (int i = 0; i < nums.length; i++) {
            missing ^= i ^ nums[i];
        }
        return missing;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
