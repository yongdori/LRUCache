public class subtractProductSum {
    public static int subtractProductSum(int n){
        int sum=0;
        int prod=1;
        while(n!=0){
            sum+=n%10;
            prod*=n%10;
            n/=10;
        }
        return prod-sum;
    }

    public static void test(){
        int result = subtractProductSum(111);
        System.out.println("************subtractProductSum******************");
        System.out.println(result);
    }
}
