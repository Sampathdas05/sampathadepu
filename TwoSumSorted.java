package SortAndSearch;

public class TwoSumSorted {
    public int[] twoSum(int[] numbers, int target) {
        int i = 0;
        int j = numbers.length - 1;
        
        if(numbers.length == 0 || numbers.length < 2){
            return new int[2];
        }
        while(i < j){
            int val = numbers[i] + numbers[j];
            
            if(val == target){
                return new int[]{i+1, j+1};
            }
            if(val > target){
                j--;
            }
            else{
                i++;
            }
        }
        return new int[0];
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
