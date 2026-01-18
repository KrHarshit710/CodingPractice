package String;

import java.util.HashSet;

public class FirstRepeatingChar {

    public static void main(String[] args) {

        String str = "feel the fizz";
        HashSet<Integer> seen = new HashSet<>();
        str.chars().filter(ch -> {
            if (seen.contains(ch))
                return true;
            else {
                seen.add(ch);
                return false;
            }
        }).forEach(ch -> System.out.println((char)ch));

    }
}
