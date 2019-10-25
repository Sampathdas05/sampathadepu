package SortAndSearch;

public class SearchInRotatedSortedDuplicates {
    public static boolean search(int[] nums, int target) {
        if(nums == null || nums.length == 0) {
    return false;
}
int left = 0;
int right = nums.length - 1;

while(left <= right){
    int mid = (left + right)/2;
    
    if(nums[mid] == target){
        return true;
    }
    if(nums[mid] > nums[left] || nums[mid] > nums[right]){

        if(target>= nums[left] && nums[mid] > target){
            right = mid - 1;
        }
        else{
            left = mid + 1;
        }
    }
    else if(nums[mid] < nums[right] || nums[mid] < nums[left]){
        if(target > nums[mid] && target <= nums[right]){
            left = mid + 1;
        }
        else{
            right = mid - 1;
        }
    }
    else{
        right--;
    }
}
return false;
}
    
    public boolean search1(int[] nums, int target) {
        int start = 0, end = nums.length - 1, mid = -1;
        while(start <= end) {
            mid = (start + end) / 2;
            if (nums[mid] == target) {
                return true;
            }
            //If we know for sure right side is sorted or left side is unsorted
            if (nums[mid] < nums[end] || nums[mid] < nums[start]) {
                if (target > nums[mid] && target <= nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            //If we know for sure left side is sorted or right side is unsorted
            } else if (nums[mid] > nums[start] || nums[mid] > nums[end]) {
                if (target < nums[mid] && target >= nums[start]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            //If we get here, that means nums[start] == nums[mid] == nums[end], then shifting out
            //any of the two sides won't change the result but can help remove duplicate from
            //consideration, here we just use end-- but left++ works too
            } else {
                end--;
            }
        }
        
        return false;
    }
    
	public static void main(String[] args) {
		System.out.println(search(new int[]{1,3}, 3));
	}

}
