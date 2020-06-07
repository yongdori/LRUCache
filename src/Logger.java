import java.util.HashMap;
import java.util.Map;

public class Logger {

        static Map<String, Integer> logMap = new HashMap<>();


    public static boolean shouldPrintLog(String message, int timestamp){
        if(!logMap.containsKey(message)){ logMap.put(message, timestamp); return true;}
        else{
            int oldTimestamp = logMap.get(message);
            if (timestamp-oldTimestamp >=10){
                logMap.put(message, timestamp);
                return true;
            } else return false;
        }
    }
    static void test(){
        String message = "abc";
        int timestamp = 0;
        System.out.println(shouldPrintLog(message, timestamp));

        message = "abd";
        timestamp=100;
        System.out.println(shouldPrintLog(message, timestamp));
        message = "abc";
        timestamp=100;
        System.out.println(shouldPrintLog(message, timestamp));
        message = "abd";
        timestamp=101;
        System.out.println(shouldPrintLog(message, timestamp));
        message = "abd";
        timestamp=110;
        System.out.println(shouldPrintLog(message, timestamp));
    }
}
