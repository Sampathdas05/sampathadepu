package ArraysAndStrings;

/*AC check this out too
 * public String longestPalindrome(String s) {
    int start = 0;
    int end = 0;
    for (int i = 0; i < s.length(); i++) {
        //StringBuffer sb = new StringBuffer();
        //sb.append(s.charAt[i]);
        char c = s.charAt(i);
        int left = i;
        int right = i;

        while (left >= 0 && s.charAt(left) == c) {
            left--;
        }

        while (right < s.length() && s.charAt(right) == c) {
            right++;
        }

        while (left >= 0 && right < s.length()) {
            if (s.charAt(left) != s.charAt(right)) {
                break;
            }
            left--;
            right++;
        }


       // left + 1 and right - 1 are actually the start and end index of the Palindromic string
        // we don't set "right" because String.substring function required end index exclusively
        left = left + 1;
        if (end - start < right - left) {
            start = left;
            end = right;
        }
    }

    return s.substring(start, end);
}*/
public class LongestPalindSubString {
	private static int lo;
	private static int maxLen;

	public static String longestPalindrome(String s) {
		int len = s.length();
		if (len < 2)
			return s;
		
	    for (int i = 0; i < len-1; i++) {
	     	extendPalindrome(s, i, i);  //assume odd length, try to extend Palindrome as possible
	     	extendPalindrome(s, i, i+1); //assume even length.
	    }
	    return s.substring(lo, lo + maxLen);
	}

	private static void extendPalindrome(String s, int j, int k) {
		while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) {
			j--;
			k++;
		}
		if (maxLen < k - j - 1) {
			lo = j + 1;
			maxLen = k - j - 1;
		}
	}
	
	public static String palindSubString(String str){
		int max = 0;
		String subStr = "";
		for(int i=0; i<str.length(); i++){
			for(int j=i; j<str.length(); j++){
				if(isPalindrome(str.substring(i, j+1))){
					if(max<str.substring(i, j+1).length()){
						max = str.substring(i, j+1).length();
						subStr = str.substring(i, j+1);
					}
				}
			}
		}
		return subStr;
	}
	public static boolean isPalindrome(String s){
		
		for(int i=0; i<s.length()/2; i++){
			if(!(s.charAt(i) == s.charAt(s.length()-i-1))){
				return false;
			}
		}
		return true;
	}
    public String longestPalindrome2(String s) {
        int[] end = new int[2];
        for(int i=0; i<s.length(); i++){
            extendPalindrome2(s, i, i, end);
             extendPalindrome2(s, i, i+1, end);           
        }
        return s.substring(end[0], end[0]+end[1]);
    }
    public void extendPalindrome2(String s, int j, int k, int[] end) {
		while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) {
			j--;
			k++;
		}
		if (end[1] < k - j - 1) {
			end[0] = j + 1;
			end[1] = k - j - 1;
		}
    }
	public static int removeDuplicates(int[] nums) {
	    if (nums.length == 0) return 0;
	    int i = 0;
	    for (int j = 1; j < nums.length; j++) {
	        if (nums[j] != nums[i]) {
	            i++;
	            nums[i] = nums[j];
	        }
	    }
	    return i + 1;
	}
	public static void main(String[] args) {
		int[] nums = new int[]{0,0,1,1,1,2,2,3,3,4};
		//System.out.println(removeDuplicates(nums));
		String str = "forgeeksskeegfor";
		LongestPalindSubString lps = new LongestPalindSubString();
		System.out.println(lps.longestPalindrome2(str));

	}

}
