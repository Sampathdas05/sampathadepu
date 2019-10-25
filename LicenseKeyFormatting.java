package ArraysAndStrings;

public class LicenseKeyFormatting {
    public String licenseKeyFormatting(String S, int K) {
        // Replacing all - and converting all letters to uppercase
        String S1 = S.replace("-","");
        S1 = S1.toUpperCase();
        
        // Making stringBuilder 
        StringBuilder sb = new StringBuilder();
         for(int i=0; i<S1.length();i++) {
            sb.append(S1.charAt(i));
        }
        int len = sb.toString().length();
        // Inserting '-' from back at every K position
        for(int i=K; i<len; i+=K) {
                sb.insert(i,'-');
            }
        return sb.toString();   
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
