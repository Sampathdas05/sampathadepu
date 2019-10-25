package AmazonOnline;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Your task is to write an algorithm to optimize the sets of forward/return shipping route pairs that allow the aircraft to be optimally utilized, given a list aof forward routes and a list of return shipping routes.

INPUT
The input to the function/method consisits of three arguments:
maxTravelDist, an integer representing the maximum operating travel distance of the given aircraft;
forwardRouteList, a list of pairs of integers where the first integer represents the unique identifier of a forward shipping
route and the second integer represents the amount of travel distance required bu this shipping route;
returnRouteList, a list of pairs of integers where the first integer represents the unique identifer of a return shipping route
and the second integer represents the amount of travel distance required by this shipping route.

OUTPUT
Return a list of pairs of integers representing the pairs of IDs of forward and return shipping routes that optimally utilize the given aircraft. If no route is possible, return a list with empty pair.

EXAMPLES
Example 1:
Input:
maxTravelDist = 7000
forwardRouteList = [[1,2000],[2,4000],[3,6000]]
returnRouteList = [[1,2000]]

Output:
[[2,1]]

Explanation:
There are only three combinations [1,1],[2,1],and [3,1], which have a total of 4000, 6000, and 8000 miles, respectively. 
Since 6000 is the largest use that does not exceed 7000, [2,1] is the optimal pair.

Example 2:
Input:
maxTravelDist = 10,000
forwardRouteList = [[1,3000],[2,5000],[3,7000],[4,10000]]
returnRouteList = [[1,2000],[2,3000],[3,4000],[4,5000]]

Output:
[[2,4],[3,2]]

Explanation:
There are two pairs of forward and return shipping routes possible that optimally utilizes the given
 aircraft. Shipping Route ID#2 from the forwardShippingRouteList, required 5000 miles travelled, and 
 Shipping Route ID#4 from returnShippingRouteList also required 5000 miles travelled. Combined, they
add up to 10000 miles travelled. Similarily, Shipping Route ID#3 from forwardShippingRouteList 
requires 7000 miles travelled, and Shippping Route ID#2 from returnShippingRouteList requires 
3000 miles travelled. These also add up to 10000 miles travelled. Therefore, the pairs of forward 
and return shipping routes that optimally utilize the aircraft are [2,4] and [3,2].
 * @author SA044034
 *
 */
public class OptimalDeviceUtilization {

	public static void main(String[] args) {
		// sample input
		System.out.println(findPairs(
				Arrays.asList(Arrays.asList(1, 3000), Arrays.asList(2, 5000), Arrays.asList(3, 7000),
						Arrays.asList(4, 10000)),
				Arrays.asList(Arrays.asList(1, 2000), Arrays.asList(2, 3000), Arrays.asList(3, 4000), Arrays.asList(4, 5000)), 10000));
	}

	public static List<List<Integer>> getIdPairsForOptimal(List<List<Integer>> forwardList,
			List<List<Integer>> backwardList, int maxDistance) {
		List<List<Integer>> result = new LinkedList<List<Integer>>();
		forwardList = forwardList.stream().sorted((x1, x2) -> Integer.compare(x2.get(1), x1.get(1)))
				.collect(Collectors.toList());
		backwardList = backwardList.stream().sorted((x1, x2) -> Integer.compare(x1.get(1), x2.get(1)))
				.collect(Collectors.toList());
		int maxDist = maxDistance;
		while (true) {
			for (List<Integer> l : forwardList) {
				for (List<Integer> b : backwardList) {
					int forward = l.get(1);
					int backward = b.get(1);
					int tot = (forward + backward);
					if (tot > maxDist) {
						break;
					}
					if (tot == maxDist) {
						// print the pair of Id and optimum distance
						result.add(Arrays.asList(l.get(0), b.get(0), maxDist));
						break;
					}

				}
			}
			if (result.size() > 0) {
				break;
			}
			maxDist--;
		}
		return result;
	}

	public static List<List<Integer>> getIdPairsForOptimalTwo(List<List<Integer>> forwardList,
			List<List<Integer>> backwardList, int maxDistance) {
		List<List<Integer>> result = new LinkedList<>();

		//List<List<Integer>> temp = new ArrayList<List<Integer>>();
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < forwardList.size(); i++) {
			for (int j = 0; j < backwardList.size(); j++) {
				int cmax = forwardList.get(i).get(1) + backwardList.get(j).get(1);
				if (cmax <= maxDistance) {
					if (cmax > max) {
						max = cmax;
						result = new ArrayList();
						result.add(Arrays.asList(forwardList.get(i).get(0), backwardList.get(j).get(0)));
					} else if (cmax == max) {
						result.add(Arrays.asList(forwardList.get(i).get(0), backwardList.get(j).get(0)));
					}

				}
			}

		}

		return result;
	}
	
	public static List<List<Integer>> findPairs(List<List<Integer>> foreground, List<List<Integer>> background
            , int k) {
        List<List<Integer>> result = new ArrayList<>();
        for (int f = 0; f < foreground.size(); f++) {
            for (int b = 0; b < background.size(); b++) {
                if (foreground.get(f).get(1) + background.get(b).get(1) <= k) {
                    List<Integer> tmp = new ArrayList<>();
                    tmp.add(f);
                    tmp.add(b);
                    result.add(tmp);
                }
            }
        }
        return result;
    }
}
