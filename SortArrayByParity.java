package ArraysAndStrings;

public class SortArrayByParity {
	
    public int[] sortArrayByParity(int[] A) {
        int n = A.length;
        int[] sort = new int[n];
        int j = n-1;
        int k = 0;
        for(int i = 0; i<n;i++){
            if(A[i] % 2 == 0){
                sort[k] = A[i];
                k++; 
            }
            else{
                sort[j] = A[i];
                j--;
            }
        }
        return sort;
    }
	public static void main(String[] args) {
		SortArrayByParity s = new SortArrayByParity();
		System.out.println(s.sortArrayByParity(new int[]{3,1,2,4}).toString());
	}

}
