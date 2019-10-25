package ArraysAndStrings;

public class StringCompression {

	public static String compress(String s){
		if(s == null || s.isEmpty()){
			return s;
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<s.length();){
			int count = 0;
			char c = s.charAt(i);
			while(i<s.length() && c == s.charAt(i)){
				i++;
				count++;
			}
			if(count > 0){
				sb = sb.append(c).append(count);
			}
		}
		return sb.toString();
	}
	
	public static String deCompress(String s){
		if(s == null || s.isEmpty()){
			return s;
		}
		StringBuilder sb = new StringBuilder();
		int count = 0;
		char prv = 0;
		for(int i=0; i<s.length(); i++){
			char c = s.charAt(i);
			if(!Character.isDigit(c)){
				while(count > 0){
					sb.append(prv);
					count--;
				}
				prv = c;
			}else{
				count = count * 10 + c - '0';
			}
		}
		if(prv!=0){
			sb.append(prv);
		}
		return sb.toString();
	}
	public static void main(String[] args) {
		String str = compress("SSSSSSSSSSSSSSSSSSSSSABC");
		System.out.println(str);
		String str1 = deCompress(str);
		System.out.println(str1);
	}

}
