//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t;
        t = sc.nextInt();
        sc.nextLine(); // Consume the newline character

        while (t-- > 0) {
            String line = sc.nextLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            // Convert ArrayList to array
            Integer[] arr = new Integer[array.size()];
            array.toArray(arr);

            Solution ob = new Solution();

            // Call totalFruits method and print result
            Integer ans = ob.totalElements(arr);
            System.out.println(ans);

            System.out.println("~");
        }
        sc.close();
    }
}
// } Driver Code Ends


class Solution {
    public static int totalElements(Integer[] arr) {
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        int maxLength = 0;
        int i = 0; // Left pointer

        for (int j = 0; j < arr.length; j++) {
            freqMap.put(arr[j], freqMap.getOrDefault(arr[j], 0) + 1);

            // Shrink the window if more than two distinct elements exist
            while (freqMap.size() > 2) {
                freqMap.put(arr[i], freqMap.get(arr[i]) - 1);
                if (freqMap.get(arr[i]) == 0) {
                    freqMap.remove(arr[i]); // Remove element if count becomes 0
                }
                i++; // Move left pointer forward
            }

            // Update the max length of a valid subarray
            maxLength = Math.max(maxLength, j - i + 1);
        }

        return maxLength;
    }}