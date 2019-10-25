package ArraysAndStrings;

public class AddBoldTag {
	   public String addBoldTag(String s, String[] dict) {
	        boolean[] visited = new boolean[s.length()];
	        for (int i = 0, end = 0; i < s.length(); i++) {
	            for(String st : dict){
	                if(s.startsWith(st, i)){
	                   end = Math.max(end, i + st.length()); 
	                }    
	            }
	            visited[i] = end > i;
	        }
	        StringBuilder sb = new StringBuilder();
	        
	        for(int i=0; i<s.length(); i++){
	            if(!visited[i]){
	                sb.append(s.charAt(i));
	                continue;
	            }
	            int j = i;
	            while(j<s.length() && visited[j]){
	                j++;
	            }
	            sb.append("<b>").append(s.substring(i,j)).append("</b>");
	            i=j-1;
	        }
	        return sb.toString();
	    }
	public static void main(String[] args) {
		AddBoldTag ad = new AddBoldTag();
		String s = "abcxyz123";
		String[] dict = new String[]{"abc","123"};
		System.out.println(ad.addBoldTag(s, dict));

	}

}
