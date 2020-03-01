import java.util.ArrayList;
import java.util.List;

public class fullJustify {
    static public List<String> fullJustify(String[] words, int maxWidth){

        int i=0, j=0;
        int width = 0;
        int numWordsLine = 0;
        StringBuilder sb = new StringBuilder();
        List<String> result = new ArrayList<>();
        int spaces ;
        int eqSpaces ;
        int addSpaces ;
        boolean lastLine = false;

        while(j<words.length) {
            i = j;
            numWordsLine=0;
            width = words[i].length();
            while ((i<words.length-1) && (width+1+words[i+1].length()) <= maxWidth) {
                /*numWordsLine++;
                i++;
                if (i>words.length-1) {
                    lastLine = true;
                    i=words.length-1;
                    break;
                }*/
                width = width + words[++i].length() + 1;
            }
            numWordsLine = i - j;
            /*if (width>maxWidth){
                //i--;
                width = width - words[i].length()-1;
            }
            if (i>words.length-1) {
                lastLine = true;
                i=words.length-1;
                break;
            }*/

            if(i<words.length-1) {
                spaces = maxWidth - width;
                eqSpaces = spaces / (numWordsLine-1);
                addSpaces = spaces % (numWordsLine-1);
            } else {
                spaces = 1;
                eqSpaces=1;
                addSpaces=0;
            }

            sb.setLength(0);
            for (int k = j; k < i; k++) {
                sb.append(words[k]);
                for (int t = 0; t < eqSpaces; t++) {
                    sb.append(" ");
                }
                if (addSpaces > 0) {
                    sb.append(" ");
                    addSpaces--;
                }
            }
            sb.append(words[i]);
            result.add(sb.toString());
            j=i+1;
        }
        return result;
    }

    //private String print(String[] words, StringBuilder sb, int i, int j, int space, int rem, int maxWidth){

    //}
    static void test(){
        String[] test_string = {"This", "is", "an", "example", "of", "text", "justification."};
        fullJustify(test_string, 16);
        fullJustify2(test_string, 16);

    }
//LeetCode submitted solution
    static public List<String> fullJustify2(String[] words, int maxWidth) {
        int i=0;//First Word in the line
        int j=0;//Last word in the line
        int n=words.length;
        int width =0;
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int numWordsGaps = 0;
        int wholeSpaces = 0;
        int eqSpaces = 0;
        int extSpaces = 0;
        boolean lastLine = false;


        while(i<n){
            j=i;
            width = words[j].length();
            while(j<n-1 && width+1+words[j+1].length()<=maxWidth){
                width+=words[++j].length()+1;
            }
            numWordsGaps = j-i;
            if (j>=n-1) lastLine=true;
            if (lastLine){
                eqSpaces=1;
                extSpaces=0;
            } else if (numWordsGaps>0){
                wholeSpaces = maxWidth - width;
                eqSpaces = wholeSpaces/numWordsGaps+1;
                extSpaces = wholeSpaces%numWordsGaps;
            } else if (numWordsGaps==0){
                wholeSpaces = maxWidth-width;
                eqSpaces = wholeSpaces;
                extSpaces = 0;
            }

            sb.setLength(0);
            for(int k=i;k<j;k++){
                sb.append(words[k]);
                for (int t=0; t<eqSpaces; t++) sb.append(" ");
                if (extSpaces>0){
                    sb.append(" ");
                    extSpaces--;
                }
            }
            sb.append(words[j]);
            width = sb.length();
            for (int t=width;t<maxWidth;t++) sb.append(" ");

            result.add(sb.toString());


            i=j+1;
        }
        return result;

    }
}
