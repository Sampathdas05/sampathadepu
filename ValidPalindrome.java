package ArraysAndStrings;
/**
 *   Valid Palindrome
  Go to Discuss
Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

Note: For the purpose of this problem, we define empty string as valid palindrome.

Example 1:

Input: "A man, a plan, a canal: Panama"
Output: true
Example 2:

Input: "race a car"
Output: false
 * @author SA044034
 *
 */
public class ValidPalindrome {
	   public static boolean isPalindrome(String s) {
		   if(s == null || s.length() == 0) return true;
	        s = s.toLowerCase();
	        for(int i = 0, j = s.length()-1;i<j;i++,j--){
	            while(i<j && !Character.isLetterOrDigit(s.charAt(i)))
	                i++;
	            while(i<j && !Character.isLetterOrDigit(s.charAt(j)))
	                j--;
	            if(i>=j || s.charAt(i) != s.charAt(j)) return false;
	        }
	        return true;
	        }
	    public static boolean isPalindrome1(String s) {
	        if(s.isEmpty() || s == null){
	            return true;
	        }
	        int i=0;
	        int j=s.length()-1;
	        s = s.toLowerCase();
	        while(i<j){
	            while(i<j && !Character.isLetterOrDigit(s.charAt(i))){
	                i++;
	            }
	            while(i<j && !Character.isLetterOrDigit(s.charAt(j))){
	                j--;
	            }
	            if( s.charAt(i)!=s.charAt(j)){
	                return false;
	            }
	            i++;
	            j--;
	        }
	        return true;
	    }
			public static boolean isValidPalindrome(String s){
				if(s==null||s.length()==0) return false;
		 
				s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
				System.out.println(s);
		 
				for(int i = 0; i < s.length() ; i++){
					if(s.charAt(i) != s.charAt(s.length() - 1 - i)){
						return false;
					}
				}
		 
				return true;
			}
	public static void main(String[] args) {
		String s = ",.";
		System.out.println(isPalindrome1("A man, a plan, a canal: Panama"));

	}

}
