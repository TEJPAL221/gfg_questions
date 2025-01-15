//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            List<Integer> arr = new ArrayList<>();
            String input1 = sc.nextLine();
            Scanner ss1 = new Scanner(input1);
            while (ss1.hasNextInt()) {
                arr.add(ss1.nextInt());
            }
            Solution ob = new Solution();
            int res = ob.findKRotation(arr);
            System.out.println(res);
        
System.out.println("~");
}
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int findKRotation(List<Integer> arr) {
        int start = 0;
        int end = arr.size() - 1;

        while (start <= end) {
            // If the array is already sorted, the number of rotations is 0
            if (arr.get(start) <= arr.get(end)) {
                return start;
            }

            int mid = start + (end - start) / 2;

            // Check if mid element is the smallest
            if (mid > 0 && arr.get(mid) < arr.get(mid - 1)) {
                return mid;
            }

            // Check if the right half is sorted, search in the left half
            if (arr.get(mid) >= arr.get(start)) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return 0;
    }
}