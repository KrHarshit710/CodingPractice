package DP;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

// https://workat.tech/problem-solving/practice/word-break
public class WordBreak {
    private static Set<String> words;
    private static HashMap<String,Boolean> dp;
    private static boolean wordBreakUtil(String str){
        int n = str.length();
        if(words.contains(str))
            return true;
        if(n == 0)
            return false;
        if(dp.containsKey(str))
            return dp.get(str);

        boolean isPossible = false;

        String leftSubString;
        String rightSubString;
        for(int i=1;i<n;i++){
            leftSubString = str.substring(0,i);
            rightSubString = str.substring(i,n);

            if(words.contains(leftSubString)){
                isPossible = (isPossible || wordBreakUtil(rightSubString));
            }
        }
        dp.put(str, isPossible);
        return isPossible;
    }
    private static boolean wordBreak (String s, String[] w) {
        words = new HashSet<>();
        dp = new HashMap<>();
        Collections.addAll(words, w);

        return wordBreakUtil(s);
    }
    public static void main(String[] args) {

    }
}
