public class RotationCheck {

    public static void test(){
        int[] A= {1,2,1,2,3};
        int[] B= {2,1,3,1,1};
        rotation_check(A, B);
    }
    public static int rotation_check(int[] A, int[] B){
        if (A.length != B.length) return -1;
        int rotate_count = rotate(A, B);
        return rotate_count;
    }

    private static int rotate(int[] A, int[] B){
        int n = A.length;
        int rotate_a_a0=0;
        int rotate_b_a0=0;
        int rotate_a_b0=0;
        int rotate_b_b0=0;
        boolean no_solution_a0=false;
        boolean no_solution_b0=false;

        int x=A[0];
        for (int i=0; i<n; i++){
            if ((x!=A[i])&&(x!=B[i])){
                no_solution_a0=true;
                break;
            }
            else if (x!=A[i]) rotate_a_a0++;
            else if (x!=B[i]) rotate_b_a0++;
        }
        if (x!=B[0]){
            x=B[0];
            for (int i=0; i<n; i++){
                if ((x!=A[i])&&(x!=B[i])){
                    no_solution_b0=true;
                    break;
                }
                else if (x!=A[i]) rotate_a_b0++;
                else if (x!=B[i]) rotate_b_b0++;
            }
        }

        if(no_solution_a0 && no_solution_b0) return -1;
        else if (no_solution_a0) return Math.min(rotate_a_b0, rotate_b_b0);
        else if (no_solution_b0) return Math.min(rotate_a_a0, rotate_b_a0);
        else return Math.min(Math.min(rotate_a_a0, rotate_b_a0), Math.min(rotate_a_b0, rotate_b_b0));
    }
}
