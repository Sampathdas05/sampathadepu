package ArraysAndStrings;

public class ProductExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        
        left[0] = 1;
        right[nums.length - 1] = 1;
        int[] result = new int[nums.length];
        
        for(int i=1; i<nums.length; i++){
            left[i] = left[i-1] * nums[i-1];
        }
        for(int i=nums.length-2; i>=0; i--){
            right[i] = right[i+1] * nums[i+1];
        }
        
        for(int i=0; i< nums.length; i++){
            result[i] = left[i] * right[i];
        }
        return result;
    }
    // O(n+m+Y) space.
    public int[] productExceptSelf2(int[] nums) {
        int[] result = new int[nums.length];
        result[0] = 1;
        for(int i=1; i<nums.length; i++){
            result[i] = result[i-1] * nums[i-1];
        }
        
        int right = 1;
        for(int i=nums.length-1; i>=0; i--){
            result[i] *= right;
            right *= nums[i];
        }
        return result;
    }//O(n)
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
