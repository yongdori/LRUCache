public class splitArray_LargestSum {
    public static int splitArray2(int[] nums, int m){
        int n=nums.length;
        int[][] f= new int[n+1][m+1];
        int[] sub = new int[n+1];
        for (int i=0;i<=n;i++){
            for (int j=0; j<=m; j++){
                f[i][j]=Integer.MAX_VALUE;
            }
        }
        for (int i=0;i<n;i++){
            sub[i+1]=sub[i]+nums[i];
        }
        f[0][0]=0;
        for (int i=1;i<=n;i++){
            for (int j=1;j<=m;j++){
                for (int k=0;k<i;k++){
                    f[i][j]=Math.min(f[i][j], Math.max(f[k][j-1], sub[i]-sub[k]));
                }
            }
        }
        return f[n][m];

    }
    public static int splitArray3(int[] nums, int m){
        int n=nums.length;
        int[][] f= new int[n-1][m-1];
        int[] sub = new int[n];
        int result=Integer.MAX_VALUE;
        for (int i=0;i<n-1;i++){
            for (int j=0; j<m-1; j++){
                f[i][j]=Integer.MAX_VALUE;
            }
        }
        sub[0] = nums[0];
        f[0][0]=sub[0];
        for (int i=1;i<n-1;i++){
            sub[i]=sub[i-1]+nums[i];
            f[i][0] = sub[i];
        }
        sub[n-1] = sub[n-2]+nums[n-1];
        for (int i=1;i<n-1;i++){
            for (int j=1;j<m-1;j++){
                for (int k=0;k<i;k++){
                    f[i][j]=Math.min(f[i][j], Math.max(f[k][j-1], sub[i]-sub[k]));
                }
            }
        }
        for (int k=0;k<n-1;k++){
            result = Math.min(result, Math.max(f[k][m-2], sub[n-1]-sub[k]));
        }
        return result;

    }
    public static int splitArray(int[] nums, int m) {
        long l = 0;
        long r = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            r += nums[i];
            //r=nums[i]>r?nums[i]:r;
            l = nums[i]>l?nums[i]:l;
            //l=0;
            /*if (l < nums[i]) {
                l = nums[i];
            }*/
        }
        long ans = r;
        while (l <= r ) {
            long mid = (l + r) >> 1;
            long sum = 0;
            int cnt = 1;
            for (int i = 0; i < n; i++) {
                if (sum + nums[i] > mid) {
                    cnt ++;
                    sum = nums[i];
                } else {
                    sum += nums[i];
                }
            }
            if (cnt <= m) {
                ans = Math.min(ans, mid);
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return (int)ans;
    }
    static void test(){
        int[] nums = {5,6,7,8,9,1,2,3,4};
        //int[] nums = {1,4,4};
        int m = 9;
        splitArray(nums, m);
    }
}
