package ArraysAndStrings;

public class SmallestSumContiguousSubarray {
	public static int minSubArraySum(int[] arr){
		int min = arr[0];
		int curr = arr[0];
		
		for(int i=1; i<arr.length; i++){
			curr = Math.min(curr + arr[i], arr[i]);
			min = Math.min(curr, min);
		}
		return min;
	}
	public static void main(String[] args) {
		int[] arr = new int[]{3, -4, 2, -3, -1, 7, -5};
		System.out.println(minSubArraySum(arr));
	}

}
