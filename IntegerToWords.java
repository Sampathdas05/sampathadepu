package ArraysAndStrings;

public class IntegerToWords {

    public String numberToWords(int num) {
        if(num == 0){
            return getNumber(num);
        }
        StringBuilder sb = new StringBuilder();
        
        if(num >= 1000000000){
            int temp = num/1000000000;
            sb.append(getNumberAboveHundered(temp) + " " + "Billion");
            num %= 1000000000;
        }
        if(num >= 1000000){
            int temp = num/1000000;
            sb.append(getNumberAboveHundered(temp) + " Million");
            num %= 1000000;
        }
        if(num >= 1000){
            int temp = num/1000;
            sb.append(getNumberAboveHundered(temp) + " Thousand");
            num %= 1000;
        }
        if(num > 0){
            sb.append(getNumberAboveHundered(num));
        }
        return sb.toString().trim();
    }
    
    public String getNumberAboveHundered(int num){
        StringBuilder sb = new StringBuilder();
        if(num >= 100){
            int temp = num/100;
            sb.append(" " + getNumber(temp) + " Hundred");
             num %= 100;
        }
        if(num > 0) {
        if(num > 0 && num <= 20){
            sb.append(" " + getNumber(num));
        }
        else{
            if(num> 0){
                int temp = num / 10;
                sb.append(" " + getNumber(temp * 10));
                num %= 10;
            }
                if(num>0){
                    sb.append(" " + getNumber(num));
                }
            }
        }
        return sb.toString();
    }
    public String getNumber(int num){
        switch(num){
            case 0 : return "Zero";
            case 1: return "One";
            case 2: return "Two";
            case 3: return "Three";
            case 4: return "Four";
            case 5: return "Five";
            case 6: return "Six";
            case 7: return "Seven";
            case 8: return "Eight";
            case 9: return "Nine";
            case 10: return "Ten";
            case 11: return "Eleven";
            case 12: return "Twelve";
            case 13: return "Thirteen";
            case 14: return "Fourteen";
            case 15: return "Fifteen";
            case 16: return "Sixteen";
            case 17: return "Seventeen";
            case 18: return "Eighteen";
            case 19: return "Nineteen";
            case 20: return "Twenty";
            case 30: return "Thirty";
            case 40: return "Forty";
            case 50: return "Fifty";
            case 60: return "Sixty";
            case 70: return "Seventy";
            case 80: return "Eighty";
            case 90: return "Ninety";
            default: return "";
        }	}
	public static void main(String[] args) {
		IntegerToWords in = new IntegerToWords();
		System.out.println(in.numberToWords(1234567));
	}

}
