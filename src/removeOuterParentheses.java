public class removeOuterParentheses {
    public static String removeOuterParentheses(String S) {
        int balance = 1;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < S.length(); i++){
            if(S.charAt(i)=='(') balance++;
            else balance--;

            if (balance==0){
                balance=1;
                i++;
            } else sb.append(S.charAt(i));

        }
        return sb.toString();
    }

    public static void test(){
        String S = removeOuterParentheses("((()))(())()");
        System.out.println("*****************removeOuterParentheses****************");
        System.out.println(S);
    }
}
