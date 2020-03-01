import java.util.ArrayList;
import java.util.List;

public class DFS_CriticalConnection {


        static List<List<Integer>> graph = new ArrayList<List<Integer>>();

        public static void insertGraph(Integer n1, Integer n2){
            if (n1 != n2) {
                graph.get(n1).add(n2);
                graph.get(n2).add(n1);
            }
        }

        public static List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {

            //init graph
            for (int i = 0; i < n; i++) {
                graph.add(new ArrayList<>());
            }

            //buiding graph
            for (int i = 0; i < connections.size(); i++ ){
                List<Integer>cur = connections.get(i);
                if (cur.get(0) != cur.get(1)) {
                    insertGraph(cur.get(0), cur.get(1));
                }
            }

            List<List<Integer>> result =  new ArrayList<List<Integer>>();

            int [] degree = new int[n];

            for(int i = 0 ; i < n; i++){
                degree[i] = -1;
            }

            dfs(0, -1, 0, degree, result);


            return result;

        }

        public static int dfs(int curN, int father, int degree, int [] degreeL, List<List<Integer>> result) {

            degreeL[curN] = degree + 1;

            for (Integer item: graph.get(curN)) {
                if (item.intValue() == father) {
                    continue;
                } else if (degreeL[item.intValue()] == -1) {
                    int childID = dfs(item, curN, degree + 1, degreeL, result);
                    degreeL[curN] = Math.min(degreeL[curN], childID);
                } else {
                    degreeL[curN] = Math.min(degreeL[curN], degreeL[item]);
                }

            }

            if (degreeL[curN] == degree + 1 && curN != 0) {
                List<Integer> edge = new ArrayList<Integer>();
                edge.add(father);
                edge.add(curN);
                result.add(edge);
            }

            return degreeL[curN];
        }

}
