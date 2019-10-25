package ArraysAndStrings;

public class FlippingAnImage {
	public void invert(int[] a){
	    for (int i = 0; i < a.length; i++) {
	        a[i] = a[i] == 0 ? 1:0;
	    }
	}

	public void reverse(int[] a) {
	    int len = a.length-1;
	    int mid = len/2;

	    for (int i = 0; i <= mid; i++) {
	        int temp = a[i];
	        a[i] = a[len-i];
	        a[len-i] = temp;

	    }

	}
	public int[][] flipAndInvertImage(int[][] a) {


	    for (int i = 0; i < a.length; i++) {
	        reverse(a[i]);
	        invert(a[i]);

	    }
	    return a;

	}
	public static void main(String[] args) {
		FlippingAnImage fl = new FlippingAnImage();
		int[][] A = new int[][]{{1,0,0},{0,1,0},{1,1,1}};
		System.out.println(fl.flipAndInvertImage(A));
	}

}
