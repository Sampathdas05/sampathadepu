package ArraysAndStrings;

public class Add2BinaryNumbers {
    public String addBinary(String a, String b) {
    	
    	if(a.startsWith(b)){
    		System.out.println("yay");
    	}
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1, j = b.length() -1, carry = 0;
        while (i >= 0 || j >= 0) {
            int sum = carry;
            if (j >= 0) sum += b.charAt(j--) - '0';
            if (i >= 0) sum += a.charAt(i--) - '0';
            sb.append(sum % 2);
            carry = sum / 2;
        }
        if (carry != 0) sb.append(carry);
        return sb.reverse().toString();
    }
    // a = 1001, b = 101
	public static void main(String[] args) {
		Add2BinaryNumbers add = new Add2BinaryNumbers();
		add.addBinary("/persons/147421/photo", "/persons");

	}

}
