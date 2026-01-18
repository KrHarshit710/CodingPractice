package LinkedList;

public class FindIntersectionPointOfYList {

    // Edge Case : Check if it merges at all
    private static ListNode intersectionPoint(ListNode oneEnd, ListNode secondEnd){
        ListNode ptr = oneEnd;
        int firstListLength = 0;

        while(ptr != null){
            firstListLength++;
            ptr = ptr.next;
        }

        ptr = secondEnd;
        int secondListLength = 0;

        while(ptr != null){
            secondListLength++;
            ptr = ptr.next;
        }
        int diff ;
        if(firstListLength > secondListLength){
            diff = firstListLength - secondListLength;
            while(diff-- > 0)
                oneEnd = oneEnd.next;
        } else {
            diff = secondListLength - firstListLength ;
            while(diff-- > 0)
                secondEnd = secondEnd.next;
        }

        while(oneEnd != secondEnd){
            oneEnd = oneEnd.next;
            secondEnd = secondEnd.next;
        }

        return oneEnd;

    }

    public static void main(String[] args) {
        ListNode oneEnd = new ListNode(-1);
        oneEnd.next = new ListNode(-2);
        oneEnd.next.next = new ListNode(-3);

        ListNode secondEnd = new ListNode(4);
        secondEnd.next = new ListNode(5);
        secondEnd.next.next = new ListNode(6);
        secondEnd.next.next.next = new ListNode(7);
        secondEnd.next.next.next.next = new ListNode(8);
        secondEnd.next.next.next.next.next = new ListNode(9);
        secondEnd.next.next.next.next.next.next = new ListNode(10);
        secondEnd.next.next.next.next.next.next.next = new ListNode(11);
        secondEnd.next.next.next.next.next.next.next.next = new ListNode(12);
        secondEnd.next.next.next.next.next.next.next.next.next = new ListNode(13);

        oneEnd.next.next.next = secondEnd.next.next.next.next.next.next;

        ListNode intersection = intersectionPoint(oneEnd, secondEnd);

        System.out.println(intersection.val);
    }
}
