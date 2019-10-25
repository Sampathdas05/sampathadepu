package ArraysAndStrings;

import java.util.ArrayList;
import java.util.List;

public class AddmissingRanges {
	public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new ArrayList<>();
        for (int n : nums) {
            if (n == Integer.MIN_VALUE) {
                lower = n + 1; 
                continue;
            }
            if (lower == n - 1) res.add("" + lower);
            else if (lower < n - 1)   res.add(lower + "->" + (n - 1)); 
            if (n == Integer.MAX_VALUE)     return res; // added
            lower = n + 1;
        }
        // if (lower == Integer.MIN_VALUE) return res;
        if (lower == upper) res.add("" + lower);
        else if (lower < upper)   res.add(lower + "->" + upper);
        return res;
    }
	
    public List<String> findMissingRanges1(int[] nums, int lower, int upper) {
        int next = lower;
        List<String> list = new ArrayList();
        for(int num : nums){
            if(lower == Integer.MAX_VALUE){
                return list;
            }
            if(num < next){
                continue;
            }
            if(num == next){
                next++;
                continue;
            }
            list.add(getRange(next, num -1));
            if(num == Integer.MAX_VALUE){
                return list;
            }
            next = num + 1;
        }
        if(next <= upper){
            list.add(getRange(next, upper));
        }
        return list;
    }
        public String getRange(int n1, int n2) {
        return n1 == n2 ? String.valueOf(n1) : String.format("%d->%d" , n1, n2);
    }
}
