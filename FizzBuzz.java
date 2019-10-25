package ArraysAndStrings;

public class FizzBuzz {

	public void printFizzBuzz(int n){
		for(int i=1; i<n; i++){
			if(i%10 == 3){
				System.out.println("fizz");
			}
			else if(i%10 ==5){
				System.out.println("buzz");
			}
			else{
				System.out.println(i);
			}
		}
	}
	public static void main(String[] args) {
		FizzBuzz fz = new FizzBuzz();
		//fz.printFizzBuzz(30);
		System.out.println(true|false);
	}

}
