package LinkedList;

public class ReverseLinkedList {

    private static ListNode reverseList(ListNode list){

        if(list == null)
            return null;

        ListNode prev = null;
        ListNode node = list;
        ListNode nextNode = null;
        while(node != null){
            nextNode = node.next;
            node.next = prev;
            prev = node;
            node = nextNode;
        }
        return prev;
    }
    public static void main(String[] args) {
        ListNode list = new ListNode(4);
        list.next = new ListNode(5);
        list.next.next = new ListNode(6);
        list.next.next.next = new ListNode(7);

        ListNode reversedList = reverseList(list);

        PrintLinkedList.printList(reversedList);

    }
}
