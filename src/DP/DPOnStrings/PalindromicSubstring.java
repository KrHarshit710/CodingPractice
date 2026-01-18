package DP.DPOnStrings;

// https://leetcode.com/problems/palindromic-substrings/description/
public class PalindromicSubstring {

    /* Brute Force TC O(n^3), SC O(1)
        public boolean isPalindrome(String s, int left, int right) {
        while(left < right) {
            if(s.charAt(left++) != s.charAt(right--)) return false;
        }
        return true;
    }

    public int countSubstrings(String s) {
        int ans = 0;
        int n = s.length();
        for(int i=0;i<n;i++) {
            for(int j=i;j<n;j++) {
                if(isPalindrome(s, i, j)) ans++;
            }
        }
        return ans;
    }
     */

    /*
        Optimization - DP - TC O(n^2) , SC O(n^2)
        Intuition : Let's say I have one string f(a, b) = "nitin"
                    And I know that f(a+1, b-1) is palindrome, then if the boundary characters are same
                    I can say that this is palindrome.
     */
    private static int countSubstrings(String s) {
        int n = s.length();
        boolean[][] palindrome = new boolean[n][n];
        int subStrings = 0;

        for(int i=0;i<n;i++) {
            palindrome[i][i] = true;
            subStrings++;
        }

        for(int i=0;i<n-1;i++) {
            if(s.charAt(i) == s.charAt(i+1)) {
                palindrome[i][i+1] = true;
                subStrings++;
            }
        }

        for(int len=3;len<=n;len++) {
            for(int i=0;i<n-len+1;i++) {
                if(s.charAt(i) == s.charAt(i+len-1) && palindrome[i+1][i+len-2]) {
                    palindrome[i][i+len-1] = true;
                    subStrings++;
                }
            }
        }

        return subStrings;
    }

    public static void main(String[] args) {
        System.out.println(countSubstrings("aaa"));
    }
}
