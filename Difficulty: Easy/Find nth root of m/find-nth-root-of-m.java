//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int m = Integer.parseInt(br.readLine().trim());
            Solution ob = new Solution();
            int ans = ob.nthRoot(n, m);
            System.out.println(ans);

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int nthRoot(int n, int m) {
        if (m == 1) return 1; // Special case: nth root of 1 is always 1

        int low = 1, high = Math.min(m, 1000000); // Optimized upper bound
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            int powerResult = checkPower(mid, n, m);
            
            if (powerResult == 0) {
                return mid; // Found exact root
            } else if (powerResult == -1) {
                low = mid + 1; // mid^n is too small
            } else {
                high = mid - 1; // mid^n is too large
            }
        }
        return -1; // No exact integer root found
    }

    private int checkPower(int base, int exp, int limit) {
        long result = 1;
        for (int i = 0; i < exp; i++) {
            result *= base;
            if (result > limit) return 1; // Overflow case, too large
        }
        if (result == limit) return 0; // Exact match
        return -1; // Too small
    }
}
