package ArraysAndStrings;

public class PrintAllPrimeNoLessThan {

	public void printPrimeNums(int n){
		boolean[] isprime = new boolean[n];
		for(int i=2; i<n; i++){
			for(int j=2; i*j<n; j++){
				isprime[i*j] = true;
			}
		}
		printPrime(isprime);
	}
	public void printPrime(boolean[] isprime){
		for(int i=2; i<isprime.length; i++){
			if(isprime[i] == false)
				System.out.println(i + " "); 
		}
	}
	public static void main(String[] args) {
		
		PrintAllPrimeNoLessThan p = new PrintAllPrimeNoLessThan();
		p.printPrimeNums(50);
	}
//2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47
}
