import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class MovingAverage {
    int size, head=0, windowSum=0, count=0;

    /*Queue/Deque specific */
    //Deque queue = new ArrayDeque<Integer>();
    int[] queue;

    /*growing queue solution specific*/
    //List queue = new ArrayList<Integer>();

    public MovingAverage(int size){



            this.size=size;
            /*circular queue specific */
            queue = new int[size];


    }

    public double next(int val){
        ++count;

        /* Deque specific*/
        //queue.add(val);
        //int tail=count>size?(int)queue.poll():0;
        //windowSum=windowSum-tail+val;

        /*Circular queue specific*/
        int tail=(head+1)%size;
        windowSum=windowSum-queue[tail]+val;
        //Move on to the next head
        head=(head+1)%size;
        queue[head]=val;



        /* growing queue solution specific code
        int windowSum=0;
        for(int i=Math.max(0, queue.size()-size);i<queue.size();i++)
            windowSum+=(int)queue.get(i);
        return windowSum*1.0/Math.min(queue.size(), size);
        */

         return windowSum*1.0/Math.min(size, count);

    }

    static void test(){
        MovingAverage m = new MovingAverage(3);
        System.out.println("*********************MovingAverage************************************");
        System.out.println(m.next(1));
        System.out.println(m.next(10));
        System.out.println(m.next(3));
        System.out.println(m.next(5));

    }
}
