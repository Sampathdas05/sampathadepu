package ArraysAndStrings;

public class TrappingRainWater {

	 public int trap(int[] height) {
	        
	        if (height.length == 0) return 0;
	        
	        int lo = 0;
	        int hi = height.length - 1;
	        int leftMax = Integer.MIN_VALUE;
	        int rightMax = Integer.MIN_VALUE;
	        
	        
	        int result = 0;
	        
	        while (lo <= hi) {
	            if (height[lo] < height[hi]) {
	                if (height[lo] > leftMax) {
	                    leftMax = height[lo];
	                } else {
	                    result = result + leftMax - height[lo];
	                }
	                lo++;
	            } else {
	                if (height[hi] > rightMax) {
	                    rightMax = height[hi];
	                } else {
	                    result = result + rightMax - height[hi];
	                }
	                hi--;
	            }
	        }
	        return result; 
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
