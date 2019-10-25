package ArraysAndStrings;

public class DailyTemps {
    public int[] dailyTemperatures(int[] T) {
    int[] results = new int[T.length];
    int highestPos = T.length - 1;
    
    for (int i = T.length - 2; i >= 0; i--) {
        if (T[i] >= T[highestPos]) {
            highestPos = i;
            continue;
        }
        int j = i + 1;
        while (T[i] >= T[j]) {
            j = j + results[j];
        }
        results[i] = j - i;
    }
    
    return results;
}
	public static void main(String[] args) {
		DailyTemps dt = new DailyTemps();
		int[] T = {73, 74, 75, 71, 69, 72, 74, 73};
		dt.dailyTemperatures(T);

	}

}
