package Array.BinarySearch;


import java.util.Arrays;

/*
    You have N books, each with A[i] number of pages. M students need to be allocated contiguous books,
    with each student getting at least one book.

    Out of all the permutations, the goal is to find the permutation where the sum of maximum number of
    pages in a book allotted to a student should be minimum, out of all possible permutations.

    Note: Return -1 if a valid assignment is not possible, and allotment should be in contiguous order
    (see the explanation for better understanding).

    Input:
        N = 4
        A[] = {12,34,67,90}
        M = 2

        Output:113

        Explanation:Allocation can be done in following ways:
        {12} and {34, 67, 90} Maximum Pages = 191
        {12, 34} and {67, 90} Maximum Pages = 157
        {12, 34, 67} and {90} Maximum Pages = 113.
 */
public class AllocateMinimumPages {

    private static boolean isPossibleAnswer(int[] pages, int minPage, int m, int n) {
        int student = 1;
        int currSum = 0;

        for(int i=0;i<n;i++){
            if(currSum + pages[i] > minPage){
                student++;
                if(student > m)
                    return false;

                currSum = pages[i];
            }else{
                currSum += pages[i];
            }
        }
        return true;
    }
    private static int allocateMinPages(int[] pages, int m, int n){
        // if m > n , there is no way each student will be allocated some book.
        if(m > n)
            return -1;

        // if m == n, each student need to be given one book . Hence, the answer would be max of all pages.
        if(m == n)
            return Arrays.stream(pages).max().orElse(1);

        // Range of valid answer , [max(pages), sum(pages)]
        int maxPages = Arrays.stream(pages).max().orElse(1);
        int sumPages = Arrays.stream(pages).reduce(0, Integer::sum);

        if(m == 1)
            return sumPages;

        int l = maxPages;
        int r = sumPages;
        int mid;
        int minPages = sumPages;
        while(l<=r){
            mid = (l+r)/2;
            if(isPossibleAnswer(pages, mid, m, n)){
                minPages = mid;
                r = mid - 1;
            }else{
                l = mid + 1;
            }
        }
        return minPages;
    }

    public static void main(String[] args) {
        int n = 4;
        int[] pages = new int[]{12,34,67,90};
        int m = 4;

        System.out.println(allocateMinPages(pages, m, n));
    }
}
