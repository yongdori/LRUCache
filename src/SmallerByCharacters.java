import java.util.ArrayList;
import java.util.List;

public class SmallerByCharacters {
    public static int[] numSmallerByFrequency(String[] queries, String[] words){
        int[] freq_queries = new int[queries.length];
        int[] freq_words = new int[words.length];
        int[] return_result = new int[queries.length];
        int[] freq_store = new int[10];
        List<Integer> freq_queries_list = new ArrayList<>();

        for (int i=0;i<words.length;i++){
            freq_words[i] = freq(words[i]);
            if (freq_words[i]>10) return null;
            freq_store[freq_words[i]-1] +=1;
        }
        for (int i=0;i<queries.length;i++){
            return_result[i]=0;

            freq_queries[i] = freq(queries[i]);
            for (int j=freq_queries[i]; j<10; j++){
                return_result[i]+=freq_store[j];
            }

        }
        return return_result;

    }

    public static int freq(String S){
        if (S==null) return 0;
        int count=1;
        char smallest=S.charAt(0);
        for (int i=1;i<S.length();i++){
            if(S.charAt(i)<smallest){
                smallest=S.charAt(i);
                count=1;
            } else if (S.charAt(i)==smallest){
                count++;
            }
        }
        return count;
    }

    public static void test(){
        String[] queries = {"cbd", "bbb", "cc"};
        String[] words = {"zaaaz", "a", "aa", "aaa", "aaaa"};
        int[] result;
        result = numSmallerByFrequency(queries, words);
        for (int i=0;i<result.length;i++){
            System.out.println(result[i]);
        }

    }
}
