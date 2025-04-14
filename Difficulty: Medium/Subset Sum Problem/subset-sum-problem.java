//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {

            String input_line[] = read.readLine().trim().split("\\s+");
            int N = input_line.length;
            int arr[] = new int[N];
            for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(input_line[i]);
            int sum = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            if (ob.isSubsetSum(arr, sum))
                System.out.println("true");
            else
                System.out.println("false");

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    public boolean isSubsetSum(int[] arr, int sum) {
        int n = arr.length;
        // Initialize memo with null values
        Boolean[][] memo = new Boolean[n][sum + 1];
        return helper(arr, n - 1, sum, memo);
    }

    private boolean helper(int[] arr, int index, int sum, Boolean[][] memo) {
        if (sum == 0) return true;
        if (index < 0 || sum < 0) return false;

        // Check if already computed
        if (memo[index][sum] != null) return memo[index][sum];

        // Include current element
        boolean include = helper(arr, index - 1, sum - arr[index], memo);
        // Exclude current element
        boolean exclude = helper(arr, index - 1, sum, memo);

        // Store result and return
        memo[index][sum] = include || exclude;
        return memo[index][sum];
    }
}
