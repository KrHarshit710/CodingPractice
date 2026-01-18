package LinkedList;

public class MergeSortedList {

    private static ListNode mergeSortedList(ListNode list1, ListNode list2){
        ListNode mergedList = new ListNode(-1);
        ListNode ptr = mergedList;

        while(list1 != null && list2 != null){
            if(list1.val <= list2.val){
                ptr.next = list1;
                ptr = ptr.next;
                list1 = list1.next;
            } else {
              ptr.next = list2;
              ptr = ptr.next;
              list2 = list2.next;
            }
            ptr.next = null;
        }
        if(list1 != null)
            ptr.next = list1;
        else
            ptr.next = list2;

        return mergedList.next;
    }
    public static void main(String[] args) {

        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(5);
        list1.next.next = new ListNode(6);
        list1.next.next.next = new ListNode(17);
        list1.next.next.next.next = new ListNode(28);
        list1.next.next.next.next.next = new ListNode(39);
        list1.next.next.next.next.next.next = new ListNode(50);
        list1.next.next.next.next.next.next.next = new ListNode(61);
        list1.next.next.next.next.next.next.next.next = new ListNode(82);
        list1.next.next.next.next.next.next.next.next.next = new ListNode(103);

        ListNode list2 = new ListNode(11);
        list2.next = new ListNode(15);
        list2.next.next = new ListNode(16);
        list2.next.next.next = new ListNode(47);
        list2.next.next.next.next = new ListNode(88);

        ListNode mergedList = mergeSortedList(list1, list2);

        PrintLinkedList.printListII(mergedList);

    }
}
