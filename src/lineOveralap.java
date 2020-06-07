public class lineOveralap {
    static void test(){
        int[] ax={1,5};
        int[] bx={3,4};
        int[] ay={1,5};
        int[] by={3,4};
        boolean overlap;

        int ret = (Math.min(bx[0],bx[1]) -Math.max(ax[0],ax[1]) ) * (Math.max(bx[0],bx[1])-Math.min(ax[0],ax[1]));
        int ret2 = (Math.min(by[0],by[1]) -Math.max(ay[0],ay[1]) ) * (Math.max(by[0],by[1])-Math.min(ay[0],ay[1]));

        if (lineOverlap(ax,bx) && lineOverlap(ay, by)) overlap=true;
        else overlap=false;
    }

    static boolean lineOverlap(int[] a, int[] b){
        if ((Math.min(b[0],b[1]) -Math.max(a[0],a[1]) ) * (Math.max(b[0],b[1])-Math.min(a[0],a[1]))<0) return true;
        else return false;
    }
}
