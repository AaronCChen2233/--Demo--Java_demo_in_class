import java.sql.Date;
import java.text.SimpleDateFormat;


public class Debug {
    public static void log(String message){
        System.out.println("[" + getDateTimeString() + "] "+ message);
    }
    public static void logInfo(String message){
        System.out.println("[" + getDateTimeString() + "]" + " - " + (char) 27 + "[34m" + "[Info]" + (char) 27 + "[0m" + " - " + message);
    }
    public static void logWarning(String message){
        System.out.println("[" + getDateTimeString() + "]" + " - " + (char) 27 + "[33m" + "[Warning]" + (char) 27 + "[0m" + " - " + message);
    }
    public static void logException(String message){
        System.out.println("[" + getDateTimeString() + "]" + " - " + (char) 27 + "[47m" + "[Exception]" + (char) 27 + "[0m" + " - " + message);
    }
    public static String getDateTimeString(){
        SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd 'At' HH:mm:ss z");
        Date date = new Date(System.currentTimeMillis());
        return dateFormatter.format(date);
    }
}
