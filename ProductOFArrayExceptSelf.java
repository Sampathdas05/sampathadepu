package ArraysAndStrings;

import java.util.Arrays;
/**
 * Given an array nums of n integers where n > 1,  return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].

Example:

Input:  [1,2,3,4]
Output: [24,12,8,6]
Note: Please solve it without division and in O(n).

Follow up:
Could you solve it with constant space complexity? (The output array does not count as extra space for the purpose of space complexity analysis.)


 * @author SA044034
 *
 */
public class ProductOFArrayExceptSelf {

	public int[] productExceptSelfoptimal(int[] nums) {
	    int n = nums.length;
	    int[] res = new int[n];
	    res[0] = 1;
	    for (int i = 1; i < n; i++) {
	        res[i] = res[i - 1] * nums[i - 1];
	    }
	    int right = 1;
	    for (int i = n - 1; i >= 0; i--) {
	        res[i] *= right;
	        right *= nums[i];
	    }
	    return res;
	}
	
    public static int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        Arrays.fill(res,1);
        int n = nums.length;
        for(int i=0; i<n; i++){
            int j=i-1; int k = i+1;
            
            while(k<n || j>=0){
                if(j>=0 && k<n){
                res[i] = nums[k]*res[i]*nums[j];
                j--;
                k++;
                }else if(j>=0 && k>=n){
                	res[i] = res[i]*nums[j];
                	j--;
                }
                else{
                res[i] = nums[k]*res[i];
                k++;
                }     
            }
        }
        return res;
        
    }
    /*
     *    while(k<n){
                if(j>=0 && k<n){
                res[i] = nums[k]*res[i]*nums[j];
                j--;
                }else if(k>n && j>=0){
                res[i] = res[i]*nums[j];
                 j--; 	
                }
                else if(k<n && j<0){
                res[i] = nums[k]*res[i];
                k++;
                }
            }
     */
	public static void main(String[] args) {
		int[] nums = new int[] {4,3,2,1,2};
		int[] x = productExceptSelf(nums);
		System.out.println(x);
	}

}
