package Array;

import java.util.ArrayDeque;
import java.util.Deque;

// Question asked :
// 1. Stock Prices: The input is an array of stock prices, i.e. [4,4,6,12,5,8],
// calculate at least how many days it has to wait till a high price appears,
// [2,1,1,0,1,0], ideally solve it using O(n) time complexity.
public class NextGreaterElement {

    public static void main(String[] args) {
        int[] elements = new int[]{11, 7, 1, 4, 8}; // NGE : {-1, 8, 4, 8, -1}
        int n = elements.length;
        int[] NGE = new int[n];

        Deque<Integer> stack = new ArrayDeque<>();
        for(int i=0;i<n;i++){
            if(stack.isEmpty())
                stack.push(i);
            else {
                if(elements[i] <= elements[stack.peek()])
                    stack.push(i);
                else {
                    while(!stack.isEmpty() && elements[i] > elements[stack.peek()]){
                        NGE[stack.pop()] = elements[i];
                    }
                    stack.push(i);
                }
            }
        }
        while(!stack.isEmpty()){
            NGE[stack.pop()] = -1;
        }

        for(int i=0;i<n;i++){
            System.out.print(NGE[i] + " ");
        }
        System.out.println();

        /*
            Stack : 0 4
            NGE : {-1, 8, 4, 8, -1}
         */
    }
}
