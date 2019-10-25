package AmazonOnline;

import java.util.Arrays;

/**
 * Amazon’s Sort Center
In Amazon’s sort center, a computer system decides what packages are to be loaded on what trucks. All rooms and spaces are abstracted into space units which is represented as an integer. For each type of truck, they have different space units. For each package, they will be occupying different space units. As a software development engineer in sort centers, you will need to write a method: 

Given truck space units and a list of product space units, find out exactly TWO products that fit into the truck. You will also implement an internal rule that the truck has to reserve exactly 30 space units for safety purposes. Each package is assigned a unique ID, numbered from 0 to N-1.

Assumptions:
You will pick up exactly 2 packages.
You cannot pick up one package twice.
If you have multiple pairs, select the pair with the largest package.

Input:
The input to the function/method consists of two arguments :
truckSpace , an integer representing the truck space.
packagesSpace , a list of integers representing the space units occupying by packages.

Output:
Return a list of integers representing the IDs of two packages whose combined space will leave exactly 30 space units on the truck.

Example 
Input :
truckSpace = 90
packagesSpace = [1, 10, 25, 35, 60]
Output :
[2, 3]
Explanation : Given a truck of 90 space units, a list of packages space units [1, 10, 25, 35, 60], Your method should select the third(ID-2) and fourth(ID-3) package since you have to reserve exactly 30 space units.
 * @author SA044034
 *
 */
public class AmazonSortCenter {
	public int[] twoSum_n2(int[] nums, int target) {
		target -= 30;
        if(nums == null)
            return null;
        int[] nums2 = Arrays.copyOf(nums, nums.length);
        Arrays.sort(nums2);
        int a = 0, b = 0;
        int start = 0, end = nums2.length-1;
        //find two nums
        while(start<end){
            int sum = nums2[start] + nums2[end];
            if(sum < target)
                start++;
            else if(sum > target)
                end--;
            else{
                a = nums2[start]; b = nums2[end];
                break;
            }
        }
        //find the index of two numbers
        int[] res = new int[2];
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == a){
                res[0] = i;
                break;
            }
        }
        if(a != b){
            for(int i = 0; i < nums.length; i++){
                if(nums[i] == b){
                    res[1] = i;
                    break;
                }
            }
        } else{
            for(int i = 0; i < nums.length; i++){
                if(nums[i] == b && i != res[0]){
                    res[1] = i;
                    break;
                }
            }
        }

        return res;
    }
	public static void main(String[] args) {
		int truckSpace = 90;
		int[] packagesSpace = {1, 10, 25, 35, 60};
		AmazonSortCenter sort = new AmazonSortCenter();
		int[] res = sort.twoSum_n2(packagesSpace, truckSpace);
		for(int i : res){
			System.out.println(i);
		}
	}

}
