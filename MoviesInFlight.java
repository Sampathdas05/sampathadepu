package AmazonOnline;

import java.util.Arrays;

/**
 * 
 * Movies on Flight
You are on a flight and wanna watch two movies during this flight. 
You are given int[] movie_duration which includes all the movie durations. 
You are also given the duration of the flight which is d in minutes. 
Now, you need to pick two movies and the total duration of the two movies is less than or equal to (d - 30min). 
Find the pair of movies with the longest total duration. If multiple found, return the pair with the longest movie.

e.g. 
Input
movie_duration: [90, 85, 75, 60, 120, 150, 125]
d: 250

Output from aonecode.com
[90, 125]
90min + 125min = 215 is the maximum number within 220 (250min - 30min)
 * @author SA044034
 *
 */
public class MoviesInFlight {
	// O(nlogn), O(1)
	public static void main(String[] args) {
		MoviesInFlight mf = new MoviesInFlight();
		int[] result = mf.moviesInflight(new int[]{90, 85, 65, 60, 120, 150, 125, 200, 15}, 250);
		for(int res : result){ //60, 65, 85, 90, 120, 125, 150
			System.out.println(res);
		}
	}
	public int[] moviesInflight(int[] movies, int duration){
		int target = duration - 30;
		int lo = 0;
		int high = movies.length -1;
		Arrays.sort(movies);
		int[] result = new int[2];
	    int minDiff = Integer.MAX_VALUE;
	    
		while(lo <= high){
			int diff = target - (movies[lo] + movies[high]);
			if(diff > 0){
				if(diff < minDiff){
					minDiff = diff;
					result[0] = movies[lo];
					result[1] = movies[high];
				}
				lo++;
			}
			else if(diff < 0){
				high --;
			}
			else {
				result[0] = movies[lo];
				result[1] = movies[high];
				break;
			}
		}		
		return result;
	}
}
