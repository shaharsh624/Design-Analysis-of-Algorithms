public class Main {
    static Node head1, head2;

    static class Node {
        int data;
        Node next;
        Node(int d) {
            data = d;
            next = null;
        }
    }

    void addTwoLists (Node head1, Node head2) {
        Node start1 = new Node(0);
        start1.next = head1;
        Node start2 = new Node(0);
        start2.next = head2;
        
        Node result = new Node(0);
        int carry = 0, sum = 0;

        while(start1!=null || start2!=null) {
            sum = 0;
            if (start1!=null) {
                sum += start1.data;
            }
            if (start2!=null) {
                sum += start2.data;
            }
            sum += carry;
            carry = sum/10;
            sum = sum%10;

            result = push(result, sum);
            if (start1!=null) {
                start1 = start1.next;
            }
            if (start2!=null) {
                start2 = start2.next;
            }
        }
        if (carry != 0) {
            result = push(result, carry);
        }
        printList(result.next);
    }

    static Node push (Node head, int val) {
        Node newP = new Node(val);
        newP.data = val;
        newP.next = head;
        head = newP;
        return head;
    }
    
    // Function to print linked list
    void printList(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println("");
    }
    
    public static void main(String[] args) {
        Main list = new Main();

        // creating first list
        head1 = new Node(7);
        head1.next = new Node(4);
        head1.next.next = new Node(1);
        head1.next.next.next = new Node(6);
        head1.next.next.next.next = new Node(7);
        System.out.print("First list :");
        list.printList(head1);

        // creating second list
        head2 = new Node(4);
        head2.next = new Node(3);
        System.out.print("Second list : ");
        list.printList(head2);
        
        System.out.print("Added list : ");
        list.addTwoLists(head1, head2);
    }


}