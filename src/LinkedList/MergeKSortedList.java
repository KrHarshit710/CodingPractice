package LinkedList;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class MergeKSortedList {

    // TC : O(K * N * log(K))
    // SC : O(K)
    private static ListNode mergeKSortedLists(List<ListNode> lists){
        ListNode mergedList = new ListNode(-1);
        ListNode ptr = mergedList;
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a,b) -> {
            if(a.val < b.val)
                return -1;
            else
                return 1;
        });

        for(ListNode head : lists)
            minHeap.offer(head);

        while(!minHeap.isEmpty()){
            ListNode node = minHeap.poll();
            ptr.next = node;
            ptr = ptr.next;

            if(node.next != null)
                minHeap.offer(node.next);
        }

        return mergedList.next;
    }

    public static void main(String[] args) {
        ListNode list1 = new ListNode(14);
        list1.next = new ListNode(15);
        list1.next.next = new ListNode(16);
        list1.next.next.next = new ListNode(17);
        list1.next.next.next.next = new ListNode(18);
        list1.next.next.next.next.next = new ListNode(19);
        list1.next.next.next.next.next.next = new ListNode(21);
        list1.next.next.next.next.next.next.next = new ListNode(31);

        ListNode list2 = new ListNode(4);
        list2.next = new ListNode(5);
        list2.next.next = new ListNode(6);
        list2.next.next.next = new ListNode(7);
        list2.next.next.next.next = new ListNode(8);
        list2.next.next.next.next.next = new ListNode(9);
        list2.next.next.next.next.next.next = new ListNode(10);
        list2.next.next.next.next.next.next.next = new ListNode(11);
        list2.next.next.next.next.next.next.next.next = new ListNode(12);
        list2.next.next.next.next.next.next.next.next.next = new ListNode(18);

        ListNode list3 = new ListNode(24);
        list3.next = new ListNode(25);
        list3.next.next = new ListNode(26);
        list3.next.next.next = new ListNode(27);
        list3.next.next.next.next = new ListNode(28);
        list3.next.next.next.next.next = new ListNode(29);

        ListNode list4 = new ListNode(34);
        list4.next = new ListNode(35);
        list4.next.next = new ListNode(36);

        List<ListNode> lists = new ArrayList<>();
        lists.add(list1);
        lists.add(list2);
        lists.add(list3);
        lists.add(list4);

        ListNode mergedList = mergeKSortedLists(lists);

        PrintLinkedList.printListII(mergedList);

    }
}
