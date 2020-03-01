public class Anagram {
    public static boolean isAnagram(String s1, String s2){
        if(s1.length() != s2.length()) return false;
        int[] ch = new int[1<<8];
        s1 = s1.toLowerCase();
        s2 = s2.toLowerCase();

        for (char c:s1.toCharArray()){
            ch[c]++;
        }

        for (char c:s2.toCharArray()){
            ch[c]--;
        }

        for (int i: ch){
            if (i!=0) {
                return false;
            }
        }

        return true;

    }

}
