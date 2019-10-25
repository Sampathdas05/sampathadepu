package ArraysAndStrings;

public class ValidParanthesis {
    public boolean isValid(String s) {
        if(s == null || s.length() ==0){
            return true;
        }
        char[] stack = new char[s.length()];
        int head  = 0;
            for(char c : s.toCharArray()){
                switch(c){
                    case '{':
                    case '[':
                    case '(':
                        stack[head++] = c;
                        break;
                    case '}':
                        if(head == 0 || stack[--head]!='{') return false;
                        break;
                    case ']':
                        if(head == 0 || stack[--head]!='[') return false;
                        break;
                    case ')':
                        if(head == 0 || stack[--head]!='(') return false;
                        break;                        
                }
            }
        return head == 0;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
