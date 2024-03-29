public class Multiplication {
    static class Node {
        int data;
        Node next;
        Node(int data){
            this.data = data;
            next = null;
        }
    }

    static long multiplyTwoLists(Node first, Node second) {
        long N = 1000000007;
        long num1 = 0, num2 = 0;

        while (first != null || second != null){
            if(first != null){
                num1 = ((num1)*10)%N + first.data;
                first = first.next;
            }
            if(second != null) {
                num2 = ((num2)*10)%N + second.data;
                second = second.next;
            }
        }
        return ((num1%N)*(num2%N))%N;
    }

    static void printList(Node node){
        while(node != null) {
            System.out.print(node.data);
            if(node.next != null)
                System.out.print(" ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String args[]) {
        Node first = new Node(9);
        first.next = new Node(4);
        first.next.next = new Node(6);
        System.out.print("First List : ");
        printList(first);

        Node second = new Node(8);
        second.next = new Node(4);
        System.out.print("Second List : ");
        printList(second);

        System.out.print("Multiplied list : ");
        System.out.println(multiplyTwoLists(first, second));
    }
}
