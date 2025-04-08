//{ Driver Code Starts
import java.util.*;
import java.util.Scanner;
import java.util.Stack;

class SortedStack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            Stack<Integer> s = new Stack<>();
            int n = sc.nextInt();
            while (n-- > 0) s.push(sc.nextInt());
            GfG g = new GfG();
            Stack<Integer> a = g.sort(s);
            while (!a.empty()) {
                System.out.print(a.peek() + " ");
                a.pop();
            }
            System.out.println();
        
System.out.println("~");
}
    }
}
// } Driver Code Ends

class GfG {
    public Stack<Integer> sort(Stack<Integer> s) {
        if (!s.isEmpty()) {
            int temp = s.pop();
            sort(s);                  // Recursively sort remaining stack
            insertSorted(s, temp);    // Insert popped element in sorted order
        }
        return s;
    }

    private void insertSorted(Stack<Integer> s, int element) {
        if (s.isEmpty() || element > s.peek()) {
            s.push(element);
            return;
        }
        
        int temp = s.pop();
        insertSorted(s, element);    // Recursive call to place element
        s.push(temp);                // Push back the popped element
    }
}
