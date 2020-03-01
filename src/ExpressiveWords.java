import java.util.ArrayList;
import java.util.List;

public class ExpressiveWords {
    public static int expressiveWords(String s_compare, String[] words){
        int return_value=0;
        RLE R_compare = new RLE(s_compare);
        search:
        for (int i=0; i<words.length; i++){
            System.out.println(words[i]);
            //if (checkExpressive(words[i], s_compare)==true){
            //    return_value++;
            //};
            RLE Word = new RLE(words[i]);
            if(!Word.ch.equals(R_compare.ch)) continue;
            for (int j=0; j<Word.counts.size(); j++) {
                    int c1 = Word.counts.get(j);
                    int c2 = R_compare.counts.get(j);
                    if(c2<3 && c2!=c1 || c2<c1) continue search;
            }
            return_value++;
        }
        return return_value;
    }

    private boolean checkExpressive2(String s_compare, String Word_i){

        RLE R_compare = new RLE(s_compare);
        RLE Word = new RLE(Word_i);
        for (int j=0; j<Word.ch.size(); j++) {
            if (Word.ch.get(j) != R_compare.ch.get(j)) return false;
            else {
                int c1 = Word.counts.get(j);
                int c2 = R_compare.counts.get(j);
                if(c2<3 && c2!=c1 || c2<c1) return false ;

            }
        }
        return true;
    }

    private static class RLE{
        List<Character> ch;
        List<Integer> counts;

        public RLE(String S) {
            int pointer = 0;
            int prev = 0;
            counts = new ArrayList<>();
            ch = new ArrayList<>();
            for (int i = 0; i<S.length();i++) {
                prev = i;
                ch.add(S.charAt(i));
                while (i < S.length() - 1 && S.charAt(i) == S.charAt(i + 1)) {
                    i++;
                }
                counts.add(i - prev + 1);
                pointer++;
            }
        }
    }

    private static boolean checkExpressive(String s, String s_compare){
        int j=0;
        int expressive_count=0;
        if ((s_compare.length() - s.length())<2) return false;
        for (int i=0; i<s.length();i++ ){
            if (s.charAt(i) == s_compare.charAt(j)){
                j++;
                if(j>=s_compare.length()) return false;
            }
            else if (s_compare.charAt(j)==s_compare.charAt(j-1)){
                if(j>=2 && s_compare.charAt(j)==s_compare.charAt(j-2)){
                    expressive_count=2;
                }
                else expressive_count=1;

                j++;

                if (s_compare.charAt(j)==s_compare.charAt(j-1)) {
                        j++;
                        expressive_count=2;
                        while (s_compare.charAt(j)==s_compare.charAt(j-1)) {
                            j++;
                        }
                        i--;

                }
                else if (expressive_count ==1) return false;
                else i--;

            }
            else return false;
        }
        if (j<s_compare.length()){
            if (s_compare.charAt(j)==s_compare.charAt(j-1)){
                if(j>=2 && s_compare.charAt(j)==s_compare.charAt(j-2)){
                    expressive_count=2;
                }
                else expressive_count=1;

                j++;
                if((j<s_compare.length())){
                    if (s_compare.charAt(j)==s_compare.charAt(j-1)) {
                        j++;
                        expressive_count=2;
                        while (j < s_compare.length()) {
                            if (s_compare.charAt(j) == s_compare.charAt(j - 1)) j++;
                            else return false;
                        }
                    }
                    else if (expressive_count==1) return false;
                }
            }
            else return false;
        }
        if (expressive_count==2) return true;
        else return false;
    }

    public static int test(){
        //String[] words = {"vpezztkugbbffyywwbcddksppddpzzhbbmy","vvpeezztkkugbbffywwbccdkkspddpzzhbmmyy","vvpeezzttkkuuggbbffyywbbccdkspdppzhhbmy","vvppeezztkkuggbbfywbcdkspdpzhhbmyy","vvppeezzttkkuugbffyywwbbccddkkspddpzzhbmyy","vppezztkuuggbffywwbcdksspdppzhhbmyy","vvppeezzttkuuggbffywbccddkksspddppzzhhbmmy","vvppezzttkuggbffywbbccdkspddppzzhhbmy","vvpezzttkuugbbfywwbccdkssppdpzhbbmmy","vvpeezzttkuugbbffyywbccdksppddppzhhbmyy","vpeezzttkkuggbbffywbccddksppddpzhhbbmy","vvpezttkuuggbffywwbbccddkspdppzhhbmmyy","vppeezzttkkuugbffywbccddksppddpzhhbmmyy","vvpezttkkuugbbfywbccdkspddppzzhbbmmy","vppezzttkkuugbbffywwbcddkssppddpzhhbmmy","vppezzttkugbfywbbcdksppddppzzhhbmyy","vppeeztkuggbbffywbbccdkkspddppzzhbbmmy","vvpeeztkuuggbbfywbcdkksspddppzhhbbmmyy","vpezttkkuuggbbffyywwbbcdksspddppzhhbmy","vpeezzttkkuuggbffywwbccdkksspddppzzhbmyy","vpezttkkuugbffyywbccdksspddppzhbbmmyy","vvppezztkugbbffyywbbccdkksppdppzhbmyy","vvpeezttkuggbbfyywwbbcddkksppdpzzhbbmyy","vvpeztkuuggbffyywbbccdkksspddppzzhbbmy","vppeezzttkugbbffyywbccddksppdppzzhbmmyy","vppeezttkkuugbbfywwbccddkksspdpzhhbmmy","vpeezzttkugbbffywbbccdkksspddppzhbbmyy","vpeezttkkuugbbfywbbccddksppddppzzhhbmmy","vpeezztkuuggbbffywwbbccddksspddpzzhhbbmmyy","vppeezttkkuggbbffyywwbccdksspdpzzhbmy","vpezzttkkuugbbfyywbbcdksspdppzzhbbmyy","vvppezttkkuggbbfyywbbccdkksspddpzhbbmyy","vvpezzttkuggbbffyywbbcdkksppdpzzhbmmyy","vvpeztkugbfywwbccddkkspddpzhhbbmyy","vvppezttkuugbbfyywwbcddkksspdppzhhbbmy","vvpeeztkkuuggbbfywwbcdkspddpzzhhbmmy","vvpeezttkugbffywbbccdkkssppddppzhhbbmyy","vpeztkuuggbbfyywwbcddksppddpzhbbmy","vppeztkuggbbfyywbcdksspdppzzhhbmy","vppeezttkkugbbffyywbccddkksppdpzhhbmy","vvppeeztkugbfyywbcdkksppdppzhbmyy","vpezttkuugbbffywbcdksppddpzzhhbbmmy","vppezzttkuugbfyywbcddkksspdpzhbbmmy","vppezzttkkuggbffywbbcdksspdpzzhhbbmmyy","vpezzttkuggbfyywbbccdksspdpzhhbbmmy","vvppezttkkugbffyywbcdkssppdpzzhbmy","vvpeezttkkuuggbbfyywbbccdkspdppzhhbmy","vpeezttkkuugbfywbccddkksppddpzzhhbmmy","vvppezttkuuggbbffywbbccdkksppdpzzhhbbmmy","vvppeeztkuggbbffyywbccdksspddppzzhbmmyy","vvppeezztkuggbfywwbccddkkspddpzhbbmy","vpezttkuuggbfyywwbcdkkspdpzhhbbmmyy","vppezzttkuggbffywbbcdkkssppddppzhhbmyy","vppeztkuuggbffyywbccdkkspdppzzhhbmmyy","vppeezztkuuggbfywbccddkksspddppzhhbbmyy","vvppeztkuugbfywwbccdkkspddppzzhhbmmy","vvpezztkuugbbffyywwbbccddksppdpzhbbmmyy","vvpezzttkkuuggbffyywwbbcdkspdpzhbmmyy","vvppeztkkuuggbbfyywbbccdksppdppzzhbmmyy","vvppezztkuggbffyywwbcddkkssppdpzhbmmyy","vvpezzttkkuggbbffywwbcddkksspdpzzhhbbmmy","vpezztkkuuggbfyywwbccddkssppdppzhhbbmmy","vvppezztkuugbffywwbccdkkspdppzhhbmmy","vpeztkugbfyywwbcdkksspdppzzhbmmy","vvpeezzttkkugbbfywwbcdkkspdpzzhhbmmy","vpezzttkuuggbbfywbccdkspddppzzhhbbmmy","vppeztkkuugbffyywwbbcddksspddppzhbbmyy","vpeztkkuggbffyywbbccddkssppdppzhbmyy","vvppeezztkuggbffyywwbcddkksppdppzhbmyy","vpeezztkugbfyywbbccdkkspdppzhbmmyy","vvppeezttkugbfywwbcddkkssppdppzhbmmyy","vpeeztkuggbffywwbbccddksspdppzzhhbmmy","vvppeeztkuugbfywbcddkssppddppzzhhbbmyy","vpezzttkuggbbffyywwbbccdkssppddppzhbbmy","vpezttkugbfywbbcddkksspddppzhbbmy","vpeezzttkkuggbbffyywwbccddkspddppzhbmyy","vppeezzttkugbffywbccdkkspddpzhhbbmyy","vpezzttkuggbbfyywbbccdkksspddpzzhhbmmy","vvppezttkugbfywwbbcdkksspddpzzhhbbmyy","vppezztkkuggbffyywbcddkkssppddpzzhhbbmmy","vppeztkkuggbfywwbccdkksppdppzhhbmmy","vvpeezzttkugbffyywwbbcddkssppddpzzhbmmy","vvpezztkkuuggbfyywbccdkksspddpzhhbbmyy","vpezttkuuggbffywbbccdksppdpzhbmmyy","vvpezzttkuggbbfywbccddksspdpzzhhbmmy","vvpeezzttkkugbbfywwbcdkksppddpzhbmy","vppeezttkkuugbbfyywwbcddkkspdpzhhbbmmyy","vvppeeztkkuugbbfyywwbbcddkksspdppzhbbmyy","vvpeezzttkkuugbfywwbbcddkspdpzzhbbmyy"};
        //String s = "vvvppppeeezzzzztttttkkkkkkugggggbbffffffywwwwwwbbbccccddddddkkkkksssppppddpzzzzzhhhhbbbbbmmmy";
        String[] words = {"hello", "hi", "helo"};
        String s = "heeeeeeellooooooo";
        return expressiveWords(s, words);
    }
}
