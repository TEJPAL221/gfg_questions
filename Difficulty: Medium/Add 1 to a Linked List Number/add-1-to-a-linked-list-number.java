//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}

class GfG {
    public static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data);
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String str[] = read.readLine().trim().split(" ");
            int n = str.length;
            Node head = new Node(Integer.parseInt(str[0]));
            Node tail = head;
            for (int i = 1; i < n; i++) {
                tail.next = new Node(Integer.parseInt(str[i]));
                tail = tail.next;
            }
            Solution obj = new Solution();
            head = obj.addOne(head);
            printList(head);
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


class Solution {
    public Node addOne(Node head) {
        head = reverse(head); // Step 1: Reverse the list
        
        Node temp = head;
        int carry = 1;  // We need to add 1
        Node prev = null;
        
        // Step 2: Traverse and add 1
        while (temp != null) {
            int sum = temp.data + carry;
            temp.data = sum % 10;
            carry = sum / 10; // Update carry
            prev = temp;
            temp = temp.next;
        }

        // If carry is still left, add a new node
        if (carry > 0) {
            prev.next = new Node(carry);
        }
        
        return reverse(head); // Step 3: Reverse again to get the final result
    }

    private Node reverse(Node head) {
        Node prev = null, curr = head, next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
