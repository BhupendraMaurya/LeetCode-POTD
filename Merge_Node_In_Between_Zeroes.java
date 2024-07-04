import java.util.ArrayList;

public class Merge_Node_In_Between_Zeroes {

    // Optimised code : TC: O(n), SC: O(n);

        public ListNode mergeNodes(ListNode head) {
            // Create a dummy node to simplify edge cases and return the new list easily
            ListNode dummyNode = new ListNode(0);
            
            // Initialize newCur to track the current position in the new list
            ListNode newCur = dummyNode;
            
            // Initialize cur to iterate through the original list starting from the head
            ListNode cur = head;
    
            // Start processing the nodes in the list
            while (true) {
                int sum = 0; // Initialize sum to store the sum of nodes between zeros
                
                // Traverse and sum up nodes until the next zero is encountered
                while (cur.next != null && cur.next.val != 0) {
                    cur = cur.next; // Move to the next node
                    sum += cur.val; // Add the current node's value to sum
                }
                
                // Create a new node with the sum and attach it to the new list
                newCur.next = new ListNode(sum);
                
                // Move newCur to the newly created node
                newCur = newCur.next;
                
                // Move cur to the next node (skipping the zero)
                cur = cur.next;
                
                // If cur is at the end of the list, break the loop
                if (cur.next == null) break;
            }
    
            // Return the head of the new list (skipping the dummy node)
            return dummyNode.next;
        }
    
    // Definition for singly-linked list.
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    // Brute Force Approach:

    public ListNode mergeNodes2(ListNode head) {

        if(head == null){
            return null;
        }
        

        int i=0;// pointer to traverse on array
        int n = 0;// to find the total size of list
        ListNode temp = head;

        // finding the size of linkedlist
        while(temp != null){
            n++;
            temp = temp.next;
        }



        temp = head;

        // making new array of size n
        int a[] = new int[n];

        // storing all the values of linkedlist in array
        while(temp != null){
            a[i] = temp.val;
            i++;
            temp = temp.next;
        }


        // reinitialize the index
        i=0;

        // taking arraylist to store the answer
        ArrayList<Integer> list = new ArrayList<>();

        // traversing till the last value
        while(i < n){
            
            int sum = 0;
            // if current value is 0, then just go ahead
            if(a[i] == 0){
                i++;
            }
            // if current value is not 0, then keep adding the non zero value till 0 is achieved. 
            else{
                while(a[i] != 0){
                    sum += a[i];
                    i++;
                }
                // after adding one interval of non zero elements, just add that sum in list.
                list.add(sum);
            }
        }

        // making a new list to sotre these sums in a list format
        ListNode head2 = new ListNode(list.get(0));
        ListNode temp2 = head2;

        // making a linkedlist from arraylist elements.
        for(int j=1;j<list.size();j++){
            ListNode newNode = new ListNode(list.get(j));
            temp2.next = newNode;
            temp2 =  temp2.next;                                      
        }

        // returning the head of newly created linkedlist.
        return head2;
    }
    
}
