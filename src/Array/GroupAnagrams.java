package Array;

import java.util.*;

public class GroupAnagrams {

    private static String sortedString(String str){
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        return Arrays.toString(chars);
    }
    private static void groupAnagrams(String[] strings){
        HashMap<String, TreeSet<String>> groupedAnagrams = new HashMap<>();

        for(String str : strings){
            String sortedString = sortedString(str);
            TreeSet<String> groupedAnagram =  groupedAnagrams.getOrDefault(sortedString, new TreeSet<>());
            groupedAnagram.add(str);
            groupedAnagrams.put(sortedString, groupedAnagram);
        }

        for(TreeSet<String> groupedAnagram : groupedAnagrams.values()){
            System.out.println(groupedAnagram);
        }
    }

    public static void main(String[] args) {
        String[] strings = new String[]{"eat","tea","tan","ate","nat","bat"}; // Output : Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
        //Arrays.sort(strings);
        groupAnagrams(strings);
    }
}
