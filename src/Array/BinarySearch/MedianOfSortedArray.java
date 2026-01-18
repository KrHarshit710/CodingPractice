package Array.BinarySearch;

// https://leetcode.com/problems/median-of-two-sorted-arrays/description/
// TC O(log (m+n))
public class MedianOfSortedArray {

    private int findKthElement(int[] arr1, int[] arr2, int l1, int r1, int l2, int r2, int k)
    {
        if( l1 > r1)
        {
            return arr2[l2+k-1];
        }

        if( l2 > r2)
        {
            return arr1[l1+k-1];
        }

        int mid1 = (l1 + r1)/2;
        int mid2 = (l2 + r2)/2;


        if(arr1[mid1] < arr2[mid2])
        {
            if(mid1-l1+1+mid2-l2+1 <= k)
            {
                k = k - (mid1 - l1 + 1);
                l1 = mid1+1;
            }
            else
            {
                r2 = mid2 - 1;
            }
        }
        else
        {
            if(mid1-l1+1+mid2-l2+1 <= k)
            {
                k = k - (mid2 - l2 + 1);
                l2 = mid2+1;
            }
            else
            {
                r1 = mid1 - 1;
            }
        }
        return findKthElement(arr1,arr2,l1,r1,l2,r2,k);
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int m = nums1.length;
        int n = nums2.length;

        if((m+n)%2 == 1)
        {
            int k = (m+n)/2+1;
            return findKthElement(nums1,nums2,0,m-1,0,n-1,k);
        }
        else
        {
            int k = (m+n)/2;
            return (double)(findKthElement(nums1,nums2,0,m-1,0,n-1,k) + findKthElement(nums1,nums2,0,m-1,0,n-1,k+1))/2 ;
        }

    }

    public static void main(String[] args) {

    }
}
