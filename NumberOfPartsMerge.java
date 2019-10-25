package AmazonOnline;

import java.util.PriorityQueue;

public class NumberOfPartsMerge {

    public int mergeStones(int[] stones, int K) {
        int n = stones.length;
        if ((n - 1) % (K - 1) > 0) return -1;

        int[] prefix = new int[n+1];
        for (int i = 0; i <  n; i++)
            prefix[i + 1] = prefix[i] + stones[i];

        int[][] dp = new int[n][n];
        for (int m = K; m <= n; ++m)
            for (int i = 0; i + m <= n; ++i) {
                int j = i + m - 1;
                dp[i][j] = Integer.MAX_VALUE;
                for (int mid = i; mid < j; mid += K - 1)
                    dp[i][j] = Math.min(dp[i][j], dp[i][mid] + dp[mid + 1][j]);
                if ((j - i) % (K - 1) == 0)
                    dp[i][j] += prefix[j + 1] - prefix[i];
            }
        return dp[0][n - 1];
    }
    
    public int merge(int[] arr, int n){
    	
            // Create a priority queue 
            PriorityQueue<Integer> pq = new PriorityQueue<Integer>(); 

            // Adding items to the pQueue 
            for (int i = 0; i < arr.length; i++) { 
                pq.add(arr[i]); 
            } 

            // Initialize result 
            int res = 0; 

            // While size of priority queue 
            // is more than 1 
            while (pq.size() > 1) { 
                // Extract shortest two ropes from pq 
                int first = pq.poll(); 
                int second = pq.poll(); 

                // Connect the ropes: update result 
                // and insert the new rope to pq 
                res += first + second; 
                pq.add(first + second); 
            } 

            return res; 
        }
   
	public static void main(String[] args) {
			NumberOfPartsMerge merge = new NumberOfPartsMerge();
			
			System.out.println(merge.merge(new int[]{3,2,4,1} , 2));
	}

}
