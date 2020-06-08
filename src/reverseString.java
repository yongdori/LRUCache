public class reverseString {
    public static char[] reverseString(char[] s){
        int left=0;
        int right=s.length-1;
        while(left<right){
            char temp = s[left];
            s[left]=s[right];
            s[right]=temp;
            left++;
            right--;
        }
        return s;
    }

    static void test(){
        char[] string = {'H','E','L','L','O'};
        char[] result = reverseString(string);
        System.out.println("**********************reverseString*********************************************");
        for (char ch: result){ System.out.print(ch);}

    }
}
