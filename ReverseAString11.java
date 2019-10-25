package ArraysAndStrings;

import TreesNGraphs.ValidateBST;
import TreesNGraphs.ValidateBST.TreeNode;

/**
 * Given an input string , reverse the string word by word. 

Example:

Input:  ['t','h','e',' ','s','k','y',' ','i','s',' ','b','l','u','e']
Output: ['b','l','u','e',' ','i','s',' ','s','k','y',' ','t','h','e']
Note: 

A word is defined as a sequence of non-space characters.
The input string does not contain leading or trailing spaces.
The words are always separated by a single space.
Follow up: Could you do it in-place without allocating extra space?
 * @author SA044034
 *
 */
public class ReverseAString11 {
    public void reverseWords(char[] str) {
    reverseString(str, 0, str.length-1);
        int x =0;
        for(int i =0; i<str.length; i++){
            if(str[i] == ' '){
                reverseString(str, x,i-1);
                x = i+1;
            }
        }
        reverseString(str,x,str.length-1);
        
    }
    public char[] reverseString(char[] str, int min, int max){
        
        for(int i=min, j=max; i<j; i++,j--){
            char temp = str[i];
            str[i] = str[j];
            str[j] = temp;
        }
        return str;
    }
    
    public static void reverseWords1(char[] str) {
        int x = 0;
      //reverse the entire string
      //reverse the words
      
      reverseString1(str, 0, str.length-1);
      
      for(int i=0; i<str.length; i++){
           if(str[i] == ' '){
             reverseString1(str, x, i-1);
             x = i+1;
           }
       }
      
      //reverse leftout word
      reverseString1(str, x, str.length-1);
      
  }
  
  static void reverseString1(char[] c, int start, int end){
      for(int i=0, j=c.length-1; i<j; i++,j--){
          char temp = c[i];
          c[i] = c[j];
          c[j] = temp;
      }
  }
	public static void  main(String args[]) {
		char[] c = new char[]{'t','h','e',' ','s','k','y',' ','i','s',' ','b','l','u','e'};
		reverseWords1(c);

		
	}
}
