package Array;

//https://leetcode.com/problems/is-subsequence/description/
//https://leetcode.com/problems/number-of-matching-subsequences/description/
public class IsSubsequence {
    public static boolean isSubsequence(String str, String word){
        int m = word.length();
        int n = str.length();

        int i=0, j=0;
        while(i<m && j<n){
            if(word.charAt(i) == str.charAt(j)){
                i++;
                j++;
            }else{
                j++;
            }
        }

        return i == m ;
    }
    public static void main(String[] args) {
        String str = "ahbgdc";
        String word = "abc";

        System.out.println(isSubsequence(str, word));

        System.out.println(isSubsequence("ahbgdc", "axc"));
    }
}
