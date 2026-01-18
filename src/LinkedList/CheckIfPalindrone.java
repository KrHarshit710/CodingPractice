package LinkedList;

public class CheckIfPalindrone {

    private static ListNode findMiddleNode(ListNode list){
        ListNode slowPtr = list;
        ListNode fastPtr = list.next;

        while(fastPtr != null && fastPtr.next != null){
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }

        return slowPtr;
    }
    private static ListNode reverseList(ListNode list){
        ListNode prev = null;
        ListNode curr = list;
        ListNode next = null;

        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
    private static boolean isPalindrome(ListNode list){
        ListNode middleNode = findMiddleNode(list);
        System.out.println("Middle Node : " + middleNode.val);

        ListNode endNode = reverseList(middleNode.next);

        middleNode.next = null; // break list into two lists

        ListNode leftPtr = list;
        ListNode rightPtr = endNode;

        while(leftPtr != null && rightPtr != null){
            if(leftPtr.val != rightPtr.val){
                return false;
            } else {
                leftPtr = leftPtr.next;
                rightPtr = rightPtr.next;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        ListNode list = new ListNode(4);
        list.next = new ListNode(5);
        list.next.next = new ListNode(6);
        list.next.next.next = new ListNode(7);
        list.next.next.next.next = new ListNode(6);
        list.next.next.next.next.next = new ListNode(6);
        list.next.next.next.next.next.next = new ListNode(5);
        list.next.next.next.next.next.next.next = new ListNode(4);

        boolean isPalindrome = isPalindrome(list);

        System.out.println(isPalindrome);
    }
}
