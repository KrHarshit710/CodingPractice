package LinkedList;

public class PrintLinkedList {

    public static void printList(ListNode head){
        ListNode ptr = head;
        while(ptr != null){
            System.out.println(ptr.getVal());
            ptr = ptr.getNext();
        }
    }
    public static void printListII(ListNode head){
        ListNode ptr = head;
        while(ptr != null){
            System.out.print(ptr.val + " ");
            ptr = ptr.next;
        }
        System.out.println();
    }
    public static ListNode init() {
        ListNode list = new ListNode(14);
        list.next = new ListNode(15);
        list.next.next = new ListNode(16);
        list.next.next.next = new ListNode(17);
        list.next.next.next.next = new ListNode(8);
        list.next.next.next.next.next = new ListNode(9);
        list.next.next.next.next.next.next = new ListNode(-1);
        list.next.next.next.next.next.next.next = new ListNode(11);
        list.next.next.next.next.next.next.next.next = new ListNode(12);
        list.next.next.next.next.next.next.next.next.next = new ListNode(13);

        return list;
    }

    public static void main(String[] args) {
        ListNode list = new ListNode(4);
        list.setNext(new ListNode(5));
        list.getNext().setNext(new ListNode(6));
        list.getNext().getNext().setNext(new ListNode(7));

        printList(list);

        ListNode anotherList = new ListNode(4);
        anotherList.next = new ListNode(5);
        anotherList.next.next = new ListNode(6);
        anotherList.next.next.next = new ListNode(7);

        printListII(anotherList);
    }
}

