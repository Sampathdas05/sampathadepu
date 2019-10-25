package ArraysAndStrings;

public class ExcelColumn {
    public String convertToTitle(int n) {
        StringBuilder result = new StringBuilder();

        while(n>0){
            n--;
            result.insert(0, (char)('A' + n % 26));
            n /= 26;
        }

        return result.toString();
    }
	public static void main(String[] args) {
		ExcelColumn ex = new ExcelColumn();
		System.out.println(ex.convertToTitle(1));
	}

}
