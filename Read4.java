package ArraysAndStrings;

public class Read4 {
    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return    The number of actual characters read
     */
       char[] tempBuf = new char[4];
        int tempBufLength = 0;
        int countToRead = 0;
    
    public int read(char[] buf, int n) {
        // read4 method takes the char[] buff and writes the read values in to it.
        //and also return the length of the chars written.
        // intution is to get a char[] to send to read4 so that we can read the values from it and write            to buf.        
        int index = 0;
        while(index<n){
            if(tempBufLength == countToRead){
                tempBufLength = 0;
                //countToRead = read4(tempBuf);
                if(countToRead == 0) {
                    break;
                }
            }
            buf[index++] = tempBuf[tempBufLength++];
        }
        return index;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//https://leetcode.com/problems/read-n-characters-given-read4-ii-call-multiple-times/
	}

}
