import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import static java.lang.Integer.valueOf;

public class MinTransfer {
    static HashMap<Integer, Integer> parent = new HashMap();

    public static int minTransfer(int[][] transactions){
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] t: transactions){
            map.put(t[0], map.getOrDefault(t[0], 0)-t[2]);
            map.put(t[1], map.getOrDefault(t[1], 0)+t[2]);
            union(t[0], t[1]);
        }
        int ans=0;
        HashMap<Integer, LinkedList<Integer>> nm = new HashMap();
        for (int x:map.keySet()){
            if(map.get(x) !=0){
                int p = getParent(x);
                LinkedList<Integer> temp = nm.getOrDefault(p, new LinkedList());
                boolean removed = temp.remove(Integer.valueOf(-map.get(x)));
                if(!removed) temp.add(map.get(x));
                else ans++;
                nm.put(p, temp);
            }
        }
        for(LinkedList<Integer> l:nm.values()){
            Collections.sort(l);
            ans=ans+dfs(l);
        }
        return ans;
    }

    public static void union(int i, int j){
        int pi = getParent(i);
        int pj = getParent(j);
        if (pi==pj) return;
        if (pi<pj) parent.put(pj, pi);
        else parent.put(pi, pj);
    }

    public static int getParent(int i){
        int p = parent.getOrDefault(i,i);
        if(i==p) return p;
        return getParent(p);
    }

    public static int dfs(LinkedList<Integer> list){
        int start = -1;
        for (int i=0;i<list.size();i++){
            if(list.get(i)<0){ start =i;break;}
        }
        if(start==-1) return 0;
        int ans=Integer.MAX_VALUE;
        LinkedList<Integer> prev = new LinkedList(list);
        for (int j=list.size()-1;j>=0;j--){
            if (list.get(j) > 0) {
                //int orig=list.get(start);
                int sum = list.get(start)+list.get(j);
                list.set(start, sum>0?0:sum);
                list.set(j,sum>0?sum:0);
                //list.set(start, Math.min(0, orig+list.get(j)));
                //list.set(j, Math.max(orig+list.get(j),0));
                int dfs_ret = dfs(list);
                ans=Math.min(ans, 1+dfs_ret);
                list=prev;

            }
        }
        return ans;
    }

    public static void test(){
        int ans;
        //int[][] transactions = {{0,1,10},{1,0,1}, {1,2,5}, {2,0,5}, {4,5,5},{3,4,10},{6,3,20}};
        int[][] transactions = {{0,1,10},{2,0,5}};
        ans = minTransfer(transactions);
        System.out.println(ans);
    }



}
