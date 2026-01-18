package LinkedList;

public class ReverseKAlternateElements {

    private static ListNode reverseListInKAlternateGroup(ListNode list, int K){

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
        k = K-1;
        list.next = nextNode;
        while(nextNode!=null && k-- > 0) {
            nextNode = nextNode.next;
        }
        if(nextNode != null)
            nextNode.next = reverseListInKAlternateGroup(nextNode.next, K);
        return prev;
    }
    public static void main(String[] args) {
        ListNode list = PrintLinkedList.init();

        ListNode reversedList = reverseListInKAlternateGroup(list, 2);

        PrintLinkedList.printList(reversedList);

    }
}
