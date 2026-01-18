package DP.DPOnStrings;

//https://workat.tech/problem-solving/practice/longest-palindromic-substring
public class LongestPalindromicSubstring {
    private static String lps(String str) {
        int n = str.length();
        int longestPalindromicSubstring = -1;
        int L = 0, R = n-1;
        for(int i=0;i<n;i++){
            int l = i-1;
            int r = i+1;

            while(l>=0 && r<n){
                if(str.charAt(l) == str.charAt(r)){
                    l--;
                    r++;

                }
                else
                    break;
            }

            l = l+1;
            r = r-1;

            if(longestPalindromicSubstring < r - l + 1){
                longestPalindromicSubstring = r - l + 1;
                L = l;
                R = r;
            }
        }

        for(int i=0;i<n;i++){
            int l = i;
            int r = i+1;

            while(l>=0 && r<n){
                if(str.charAt(l) == str.charAt(r)){
                    l--;
                    r++;

                }
                else
                    break;
            }

            l = l+1;
            r = r-1;

            if(longestPalindromicSubstring < r - l + 1){
                longestPalindromicSubstring = r - l + 1;
                L = l;
                R = r;
            }
        }

        return str.substring(L,R+1);

    }

    public static void main(String[] args) {
        System.out.println(lps("abaadcd")); // aba
        System.out.println(lps("abcdcba")); // abcdcba
    }
}
