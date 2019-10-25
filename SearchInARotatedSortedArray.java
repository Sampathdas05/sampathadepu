package SortAndSearch;

public class SearchInARotatedSortedArray {
    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        
        while(left <= right){
            int mid = left + (right-left)/2;
            
            if(nums[mid] == target){
                return mid;
            }
            if(nums[left] <= nums[mid]){
                //this means left array is sorted. try to find the target is in the range of sorted left array.
                if(target>= nums[left] && target <= nums[mid]){
                    right = mid - 1;
                }
                else{
                    left = mid + 1;
                }
            }
            else{
                if(target >= nums[mid] && target <= nums[right]){
                    left = mid + 1;
                }
                else{
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
public static void main(String[] args) {
		System.out.println(search(new int[]{5,1,3}, 5));
	}

}
