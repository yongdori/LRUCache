public class IsConfusing {
    static int[] reverse= {0, 1, -1, -1, -1, -1, 9, -1, 8, 6};
    static int[] numbers= {0,1,6,8,9};
    static int confusing_count = 0;

    public static int IsConfusing(int max_num){
        int return_value=0;
        confusing_count = 0;
        dfs(1, max_num);
        dfs(6, max_num);
        dfs(8, max_num);
        dfs(9, max_num);
        return confusing_count;
    }

    static void dfs(int cur, int max_num){
        //int return_val = 0;
        if (cur > max_num) return ;
        if (cur != rotate(cur)) {
            confusing_count++;
            //return_val++;
        }
        if (cur*10 <= max_num) {
            for (int i=0;i<5;i++) {
                dfs(cur * 10+numbers[i], max_num);
                //dfs(cur * 10 + 1, max_num);
                //dfs(cur * 10 + 6, max_num);
                //dfs(cur * 10 + 8, max_num);
                //dfs(cur * 10 + 9, max_num);
            }
        }

        return;
    }

    static int rotate(int num){
        int n;
        int r;
        int rotated = 0;
        n = num;
        while(n!=0){
            r = reverse[n%10];
            if (r==-1){
                rotated = -1;
                break;
            } else {
                rotated = rotated*10 +r;
                n = n / 10;
            }
        }
        return rotated;
    }
}
