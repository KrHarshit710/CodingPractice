package Array;

public class ValidParenthesis {

    private static int minimumAddToMakeValidParanthesis(String paranthesis) {
        int n = paranthesis.length();
        int openBracket = 0;
        int closedBracket = 0;

        for(int i=0;i<n;i++){
            if(paranthesis.charAt(i) == '('){
                openBracket++;
            } else {
                if(openBracket > 0)
                    openBracket--;
                else
                    closedBracket++;
            }
        }
        return openBracket + closedBracket;
    }
    public static void main(String[] args) {
        String str = "()))((";
        System.out.println(minimumAddToMakeValidParanthesis(str));

        str = "())";
        System.out.println(minimumAddToMakeValidParanthesis(str));

        str = ")))";
        System.out.println(minimumAddToMakeValidParanthesis(str));
    }
}
