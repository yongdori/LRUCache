import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class canConvert {
    public static boolean canConvert(String str1, String str2) {
        char ch1, ch2, ch_get;
        boolean bool1, bool2;
        if(str1 == null && str2 == null)
            return true;
        if(str1 == null || str2 == null || (str1.length() != str2.length()))
            return false;
        //same
        if(str1.equals(str2) || str1.length()==1)
            return true;
        //s2 has all 26 chars
        Set<Character> set = new HashSet<>();
        for(char c : str2.toCharArray())
            set.add(c);
        if(set.size() == 26)
            return false;
        int i=0;
        Map<Character, Character> map = new HashMap<>();
        while(i<str1.length()) {
            if(map.containsKey(str1.charAt(i)) && map.get(str1.charAt(i)) != str2.charAt(i)) {
                ch1 = str1.charAt(i);
                bool1 = map.containsKey(str1.charAt(i));
                ch_get = map.get(str1.charAt(i));
                ch2 = str2.charAt(i);

                return false;
            }
            map.put(str1.charAt(i), str2.charAt(i));
            i++;
        }
        return true;
    }
}
