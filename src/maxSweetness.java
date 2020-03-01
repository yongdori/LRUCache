public class maxSweetness {

    public static int maxSweetness(int[] nums, int K){
        int high=0, low=0, mid=0;
        low=nums[0];
        for (int x:nums){
            high+=x;
            low=Math.min(low, x);
        }
        while(low<high){
            mid=low+(high-low)/2;
            int count=0;
            int sum=0;
            for (int x:nums){
                sum+=x;
                if(sum>mid){sum=0;count++;}
            }
            if(count>K) low=mid+1;
            else high =mid;
        }
        return low;
    }
    static void test(){
        int[] nums = {5,6,7,8,9,1,2,3,4};
        //int[] nums = {1,4,4};
        int m = 8;
        maxSweetness(nums, m);

    }
}
