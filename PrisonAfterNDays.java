package DP;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PrisonAfterNDays {
    public int[] prisonAfterNDays(int[] cells, int N) {
        Map<String, Integer> seen = new HashMap<>();
   while (N > 0) {
       int[] cells2 = new int[8];
       seen.put(Arrays.toString(cells), N--);
       for (int i = 1; i < 7; ++i){
           cells2[i] = cells[i - 1] == cells[i + 1] ? 1 : 0;
       }
       cells = cells2;
/*       if (seen.containsKey(Arrays.toString(cells))) {
           N %= seen.get(Arrays.toString(cells)) - N;
       }*/
   }
   return cells;
   //seen.get(Arrays.toString(cells)) is the last time when the same cells appear, seen.get(Arrays.toString(cells))-N is the cycle length. %= cuts down the loop times.
}
	public static void main(String[] args) {
		PrisonAfterNDays pr = new PrisonAfterNDays();
		System.out.println(Arrays.toString(pr.prisonAfterNDays(new int[]{0,1,0,1,1,0,0,1}, 1000)));
	}

}
