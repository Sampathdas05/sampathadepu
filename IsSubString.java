package ArraysAndStrings;

import java.util.Arrays;
import java.util.Collections;

public class IsSubString {

	private static boolean isSubString(String s1, String s2){
		char[] c1 = s1.toCharArray();
		char[] c2 = s2.toCharArray();
		s1.charAt(0);
		Arrays.sort(c1);
		String s11 = String.valueOf(c1);
		Arrays.sort(c2);
		String s22 = String.valueOf(c2);
		
		if(s11.equals(s22)){
			return true;
		}
		//It is more than O(n) time and requires more than O(1) space. Arrays.sort(int[] a) in recent JDK is implemented with Dual-pivot Quicksort algorithm which has O(n log n) average complexity and is performed in-place (e.g. requires no extra space).
		return false;
	}
	private static boolean isSubString1(String s1, String s2){

		String s11 = s1 + s1;
		if(s11.contains(s2)){
			return true;
		}
		
		return false;
	}
	public static void main(String[] args) {
		System.out.println(isSubString("hiea", "eiah"));
		System.out.println(isSubString1("hiea", "ahie"));

	}

}
