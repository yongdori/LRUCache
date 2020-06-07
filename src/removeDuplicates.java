public class removeDuplicates {
    public static String removeDuplicates(String S){
        StringBuilder sb = new StringBuilder();
        int sbLength=0;

        for(char character: S.toCharArray()){

            if (sbLength!=0 && character==sb.charAt(sbLength-1)){
                sbLength--;
                sb.deleteCharAt(sbLength);
            }
            else {
                sb.append(character);
                sbLength++;
            }

        }
        return sb.toString();

    }
    static void test(){
        String S = removeDuplicates("ababbabac");
        System.out.println("**********************removeDuplicates**********************");
        System.out.println(S);
    }
}
