public class ShortestWay {
    public int shortestWay(String source, String target){
        int count=0;
        int i=0;
        int j=0;
        int starti=0;
        while (i<target.length()){
            starti=i;
            while (j<source.length()){
                if(source.charAt(j)==target.charAt(i)){
                    i++;
                    j++;
                }
                else
                {
                    j++;
                }
            }
            if (starti==i) return -1;
            count++;
            j=0;
        }
        return count;
    }
}
