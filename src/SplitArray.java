import java.util.HashMap;

public class SplitArray {
    public static boolean isPossible(int[] nums){
        Counter Counts = new Counter();
        Counter Trails = new Counter();
        for (int x: nums) Counts.add(x,1);
        for (int x: nums){
            if (Counts.get(x)==0) continue;
            else if (Trails.get(x)>0){
                Trails.add(x, -1);
                Trails.add(x+1, 1);
            }
            else if (Counts.get(x+1)>0 && Counts.get(x+2)>0){
                Counts.add(x+1, -1);
                Counts.add(x+2, -1);
                Trails.add(x+3, 1);
            }
            else return false;
        }
        return true;
    }

    public static class Counter extends HashMap<Integer, Integer>{
        @Override
        public Integer put(Integer key, Integer value) {
            return super.put(key, value);
        }
        public void add(int k, int v){
            put(k, get(k)+v);
        }

        public int get(int k){
            return containsKey(k)? super.get(k):0;
        }

    }

    public static void test(){
        int[] nums = {1,2,2,3,3,4,4, 5,6,7};
        System.out.println(isPossible(nums));
    }
    public boolean isPossible_old(int[] nums){
        int[] used = new int[nums.length];
        int used_last=0;
        int i=0;
        int cur_num=0;
        boolean first_dup=true;
        int seq_count=0;

        while (i<nums.length){
            i=used_last;
            seq_count=0;
            while (used[i]==1){
                i++;
                if(i==nums.length-1) return true;
            }
            used[i]=1;
            cur_num=nums[i];
            while (nums[i+1]==cur_num){
                i++;
                if(first_dup) {
                    used_last = i;
                    first_dup = false;
                }
                while(nums[i+1]==cur_num+1){
                    seq_count++;
                    cur_num=nums[++i];
                }
            }

        }
        return true;

    }
}
