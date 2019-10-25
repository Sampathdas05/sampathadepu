package Design;

import java.util.Random;

public class RouletteGame {

	public static void main(String[] args) {
		rouletteGame();
}
	public static void rouletteGame(){
		int numberOfTries = 100;
		int amountInHand = 50;
		while(numberOfTries > 0 || amountInHand > 0){
			int charsInRow = 0;
			char history = 0;
			while(charsInRow != 4){
				char c = roll();
				if(c == history){
					charsInRow++;
				}
				else{
					history = c;
					charsInRow = 0;
				}
			}
			if(placeBet(history == 'R' ? 'B' : 'R')){
				amountInHand += 10;
			}else{
				amountInHand -= 10;
			}
			numberOfTries--;
		}
		System.out.println("Amount in hand: " + amountInHand);
	}
	public static char roll(){	
		Random rand = new Random();
		String chars = "RB";
		char c = chars.charAt(rand.nextInt(chars.length()));
		return c;
	}
	public static boolean placeBet(char c){
		char newVal = roll();
		if(newVal == c){
			return true;
		}
		return false;
	}
}
