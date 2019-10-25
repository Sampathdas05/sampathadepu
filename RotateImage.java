package ArraysAndStrings;

import java.awt.DisplayMode;

public class RotateImage {

	private static int[][] rotateImageClock(int[][] matrix){
		if(matrix.length == 0){
			return matrix;
		}
		int n = matrix.length;
		//anti clock wise reverse/transpose.
		//clock wise transpose/reverse
		
		//transpose
		for(int i =0; i< n; i++){
			for(int j =i; j<n; j++){
				int temp = matrix[j][i];
				matrix[j][i] = matrix[i][j];
				matrix[i][j] = temp;
			}
		}
		
		//reverse
		for(int i =0; i<n; i++){
			for(int j=0; j<n/2; j++){
				int temp = matrix[i][j];
				matrix[i][j] = matrix[i][n-j-1];
				matrix[i][n-j-1] = temp;
			}
		}
		return matrix;
	}
	// Function to print the matrix 
	static void displayMatrix(int mat[][]) 
	{ 
		int N = mat.length;
	    for (int i = 0; i < N; i++) 
        { 
            for (int j = 0; j < N; j++) 
                System.out.print(" " + mat[i][j]); 
       
            System.out.print("\n"); 
        } 
        System.out.print("\n"); 
	} 
	public static void main(String[] args) {
		String s = " hi sampath ";
		String[] sa = s.split(" ");
		
		  StringBuilder sb = new StringBuilder();
	        for (int i = sa.length -1; i >= 0; i--){
	                sb.append(sa[i]);
	                if(i!=0){
	                    sb.append(" ");
	                }
	                }
	            
		System.out.println(sb.toString().trim());
		 int N = 4; 
         
	        // Test Case 1 
	        int mat[][] = 
	        { 
	            {1, 2, 3, 4}, 
	            {5, 6, 7, 8}, 
	            {9, 10, 11, 12}, 
	            {13, 14, 15, 16} 
	        }; 
	        displayMatrix(rotateImageClock(mat));
	}

}
