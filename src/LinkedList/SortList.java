package LinkedList;

import static LinkedList.PrintLinkedList.init;

public class SortList {

    private static ListNode middleNode(ListNode list){

        ListNode slowPtr = list;
        ListNode fastPtr = list.next;

        while(fastPtr != null && fastPtr.next != null){
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }
        return slowPtr;
    }
    private static ListNode mergeList(ListNode list1, ListNode list2){
        ListNode mergedList = new ListNode(-1);
        ListNode ptr = mergedList;
        while(list1 != null && list2 != null){
            if(list1.val < list2.val){
                ptr.next = list1;
                list1 = list1.next;
            }else {
                ptr.next = list2;
                list2 = list2.next;
            }
            ptr = ptr.next;
        }
        if(list1 != null)
            ptr.next = list1;
        else if(list2 != null)
            ptr.next = list2;

        return mergedList.next;
    }
    private static ListNode mergeSort(ListNode list){

        if(list == null || list.next == null)
            return list;

        ListNode middleNode = middleNode(list);
        ListNode secondHalfList = middleNode.next;
        middleNode.next = null;

        list = mergeSort(list);
        secondHalfList = mergeSort(secondHalfList);
        return mergeList(list, secondHalfList);

    }
    public static void main(String[] args) {
        ListNode list = init();
        PrintLinkedList.printListII(list);

        list = mergeSort(list);
        PrintLinkedList.printListII(list);

    }
}
