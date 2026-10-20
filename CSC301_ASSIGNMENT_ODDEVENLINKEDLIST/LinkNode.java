import java.util.Scanner; // Import the Scanner class


class LinkNode {
    int val;
    LinkNode next;
    LinkNode() {}
    LinkNode(int val) { this.val = val; this.next = next; }
}

 class OddEvenLinkedList {
    public LinkNode oddEvenList(LinkNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        LinkNode odd = head;
        LinkNode even = head.next;
        LinkNode evenHead = even;

        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;

            even.next = odd.next;
            even = even.next;
        }


        odd.next = evenHead;

        return head;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the numbers for the linked list separated by spaces (e.g., 1 2 3 4 5):");
        String inputLine = scanner.nextLine();


        if (inputLine.trim().isEmpty()) {
            System.out.println("No input provided.");
            scanner.close();
            return;
        }


        String[] values = inputLine.trim().split("\\s+");

        LinkNode head = null;
        LinkNode tail = null;


        for (String valStr : values) {
            int val = Integer.parseInt(valStr);
            LinkNode newNode = new LinkNode(val);

            if (head == null) {
                head = newNode;
                tail = head;
            } else {
                tail.next = newNode;
                tail = tail.next;
            }
        }

        scanner.close();


        OddEvenLinkedList solver = new OddEvenLinkedList();
        LinkNode result = solver.oddEvenList(head);


        System.out.println("\nReordered Odd-Even List:");
        LinkNode current = result;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
    }
}