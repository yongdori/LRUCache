import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class MinWindow {
    public static String minWindow_old(String S, String T){
        int start=0;
        int match=0;
        int retStart=0;
        int retEnd=Integer.MAX_VALUE;
        int ret_len=0;
        String ret_str;

        while(start<S.length()) {
            int subStart = start;
            int subEnd = Integer.MAX_VALUE;

            for (int i = 0; i < T.length(); i++) {
                match = charScan(S, T.charAt(i), start);
                if (match == -1) {
                    if(retEnd==Integer.MAX_VALUE) return null;
                    else return S.substring(retStart, retEnd);
                }
                if (i == 0) subStart = match;
                if (i == T.length() - 1) {
                    subEnd = match+1;
                    if ((subEnd - subStart) < (retEnd - retStart)) {
                        retStart = subStart;
                        retEnd = subEnd;
                    }
                }
                start = match + 1;
            }
        }
        if(retEnd==Integer.MAX_VALUE) return null;
        else return S.substring(retStart, retEnd);
    }

    public static String minWindow_old2(String S, String T){
        int end_point=S.length()-1;
        int match=0;
        int retStart=0;
        int retEnd=Integer.MAX_VALUE;
        int ret_len=0;
        String ret_str;

        while(end_point>=0) {
            int subEnd = end_point;
            int subStart = Integer.MIN_VALUE;

            for (int i = T.length()-1; i >=0 ; i--) {
                match = charScan(S, T.charAt(i), end_point);
                if (match == -1) {
                    if(retStart==Integer.MIN_VALUE) return null;
                    else return S.substring(retStart, retEnd);
                }
                if (i == T.length()-1) subEnd = match+1;
                if (i == 0) {
                    subStart = match;
                    if ((subEnd - subStart) < (retEnd - retStart)) {
                        retStart = subStart;
                        retEnd = subEnd;
                    } else if ((subEnd-subStart)==(retEnd-retStart) && (subStart<retStart)){
                        retStart=subStart;
                        retEnd=subEnd;
                    }
                }
                end_point = match - 1;
            }
        }
        if(retStart==Integer.MIN_VALUE) return null;
        else return S.substring(retEnd, retStart);
    }
    public static String minWindow(String S, String T){
        Map<Integer, Integer> window = new TreeMap<>(Comparator.reverseOrder());
        int start=0;
        int match=0;
        int retStart=0;
        int retEnd=Integer.MAX_VALUE;
        int ret_len=0;
        String ret_str;
        window.put(0,-1);
        int subStart = 0;
        int subEnd = Integer.MAX_VALUE;

        for (int i=0;i<S.length();i++){
            Integer[] window_keys = window.keySet().toArray(new Integer[0]);

                for (int x :window_keys){
                    if (S.charAt(i)==T.charAt(x)) {
                        if (x==0 && T.length()!=1) {
                            window.put(1, i);
                            window.put(0,-1);
                        } else if (x==T.length()-1) {
                            if (T.length()==1) subStart=i;
                            else subStart = window.get(x);
                            subEnd = i+1;
                            window.remove(x);
                            if ((subEnd - subStart) < (retEnd - retStart)) {
                                retStart = subStart;
                                retEnd = subEnd;
                            }
                        } else {
                            window.put(x+1, window.get(x));
                            window.remove(x);
                        }
                    }
                }
        }
        if(retEnd==Integer.MAX_VALUE) return null;
        else return S.substring(retStart, retEnd);
    }

    private static int charScan(String S, char ch, int pointer){
        if (pointer<=0) return -1;
        while (pointer>=0 && ch!=S.charAt(pointer)){
            pointer--;
        }
        if(pointer<=0) return -1;
        else return pointer;
    }

    public static void test(){
        String S = "ccccccacccccccad";
        String T = "a";
        String ret_str;
        ret_str = minWindow(S,T);
        System.out.println(ret_str);
    }
}
