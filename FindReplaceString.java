package ArraysAndStrings;

import java.util.Arrays;

public class FindReplaceString {
	 public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
	        int N = S.length();
	        int[] match = new int[N];
	        Arrays.fill(match, -1);

	        for (int i = 0; i < indexes.length; ++i) {
	            int ix = indexes[i];
	            if (S.substring(ix, ix + sources[i].length()).equals(sources[i]))
	                match[ix] = i;
	        }

	        StringBuilder ans = new StringBuilder();
	        int ix = 0;
	        while (ix < N) {
	            if (match[ix] >= 0) {
	                ans.append(targets[match[ix]]);
	                ix += sources[match[ix]].length();
	            } else {
	                ans.append(S.charAt(ix++));
	            }
	        }
	        return ans.toString();
	    }
	public static void main(String[] args) {
		FindReplaceString fr = new FindReplaceString();
		fr.findReplaceString("abcd", new int[]{0,2}, new String[]{"a","cd"}, new String[]{"eee", "fff"});
	}

}
