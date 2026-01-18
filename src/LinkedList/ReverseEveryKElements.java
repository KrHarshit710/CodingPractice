package LinkedList;

public class ReverseEveryKElements {


    private static ListNode reverseListInKGroup(ListNode list, int K){

        if(list == null)
            return null;

        ListNode prev = null;
        ListNode node = list;
        ListNode nextNode = null;
        int k = K;
        while(node != null && k-- > 0){
            nextNode = node.next;
            node.next = prev;
            prev = node;
            node = nextNode;
        }
        list.next = reverseListInKGroup(nextNode, K);
        return prev;
    }
    public static void main(String[] args) {
        ListNode list = new ListNode(4);
        list.next = new ListNode(5);
        list.next.next = new ListNode(6);
        list.next.next.next = new ListNode(7);
        list.next.next.next.next = new ListNode(8);
        list.next.next.next.next.next = new ListNode(9);
        list.next.next.next.next.next.next = new ListNode(10);

        ListNode reversedList = reverseListInKGroup(list, 1);

        PrintLinkedList.printList(reversedList);

    }
}
