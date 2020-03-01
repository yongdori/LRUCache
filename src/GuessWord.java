import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class GuessWord {
    static int MAX_LEN=6;

    public static void findSecretWord(String[] wordlist, Master master){
        if(wordlist==null) return;

        List<String> potentialGuess = new LinkedList<>();
        for(int i=0; i<wordlist.length;i++){
            potentialGuess.add(wordlist[i]);
        }

        do{
            int idx = (int)(Math.random()*(potentialGuess.size()));
            String guessWord = potentialGuess.remove(idx);
            int matchCount = master.guess(guessWord);
            if(matchCount==MAX_LEN) return;

            Iterator<String> iter = potentialGuess.listIterator();
            while(iter.hasNext()){
                String curr = iter.next();
                if(compare(guessWord,curr)!=matchCount) iter.remove();
            }
        } while(!potentialGuess.isEmpty());
    }
    private static int compare(String w1, String w2){
        char[] ch1 = w1.toCharArray();
        char[] ch2 = w2.toCharArray();
        int count=0;
        for (int i=0; i<ch1.length;i++){
            if (ch1[i]==ch2[i]) count++;
        }
        return count;
    }

    private static class Master{
        private int guess(String guessWord){
            String secretWord = "aabbcc";
            return compare(secretWord, guessWord);

        }

    }

    public static void test(){
        String[] guessWord = new String[6];
        Master master = new Master();
        guessWord[0] = "aaabbc";
        guessWord[1] = "abcabc";
        guessWord[2] = "aabbca";
        guessWord[3] = "aaabba";
        guessWord[4] = "abcbca";
        guessWord[5] = "aabbcc";
        findSecretWord(guessWord, master);

    }
}
