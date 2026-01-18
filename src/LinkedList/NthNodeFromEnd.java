package LinkedList;

import static LinkedList.PrintLinkedList.init;

public class NthNodeFromEnd {

    private static int nthFromEnd(ListNode list, int n){
        ListNode leftPtr = list;
        ListNode rightPtr = list;

        while(n-- > 0 && rightPtr != null)
            rightPtr = rightPtr.next;

        while(rightPtr != null){
            rightPtr = rightPtr.next;
            leftPtr = leftPtr.next;
        }

        if(n > 0)
            return -1;

        return leftPtr.val;
    }

    public static void main(String[] args) {
        ListNode list = init();
        int n = 6;
        System.out.println(nthFromEnd(list, n));
    }
}
