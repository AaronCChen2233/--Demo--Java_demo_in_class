package Bootstrap.Tools;

import java.util.Date;

/***
 * @author Aaron Chen
 * Let logs are coloful
 */
public class Alog {
    final static private Date date = new java.util.Date();

    final static public void log(String message) {
        System.out.println(message);
    }

    final static public void logWithDate(String message) {
        System.out.println("[" + date + "]" + message);
    }

    final static public void logStartup(String message){
        System.out.println((char) 27 + "[44m" + "[Startup]" + (char) 27 + "[0m" + " - " + message);
    }

    final static public void logStartupWithDate(String message){
        System.out.println("[" + date + "]" + " - " + (char) 27 + "[44m" + "[Startup]" + (char) 27 + "[0m" + " - " + message);
    }

    final static public void logInfo(String message){
        System.out.println((char) 27 + "[34m" + "[Info]" + (char) 27 + "[0m" + " - " + message);
    }

    final static public void logInfoWithDate(String message){
        System.out.println("[" + date + "]" + " - " + (char) 27 + "[34m" + "[Info]" + (char) 27 + "[0m" + " - " + message);
    }

    final static public void logWarning(String message){
        System.out.println((char) 27 + "[33m" + "[Warning]" + (char) 27 + "[0m" + " - " + message);
    }

    final static public void logWarningWithDate(String message){
        System.out.println("[" + date + "]" + " - " + (char) 27 + "[33m" + "[Warning]" + (char) 27 + "[0m" + " - " + message);
    }

    final static public void logError(String message){
        System.out.println((char) 27 + "[31m" + "[Error]" + (char) 27 + "[0m" + " - " + message);
    }

    final static public void logErrorWithDate(String message){
        System.out.println("[" + date + "]" + " - " + (char) 27 + "[31m" + "[Error]" + (char) 27 + "[0m" + " - " + message);
    }

    final static public void logException(String message){
        System.out.println("[" + date + "]" + " - " + (char) 27 + "[47m" + "[Exception]" + (char) 27 + "[0m" + " - " + message);
    }

    final static public void logExceptionWithDate(String message){
        System.out.println("[" + date + "]" + " - " + (char) 27 + "[47m" + "[Exception]" + (char) 27 + "[0m" + " - " + message);
    }

    final static public void logShutdown(String message){
        System.out.println((char) 27 + "[41m" + "[Shutdown]" + (char) 27 + "[0m" + " - " + message);
    }

    final static public void logShutdownWithDate(String message){
        System.out.println("[" + date + "]" + " - " + (char) 27 + "[41m" + "[Shutdown]" + (char) 27 + "[0m" + " - " + message);
    }

    final static public void logUnknown(String message){
        System.out.println((char) 27 + "[0;97m" + "[Unknown]" + (char) 27 + "[0m" + " - " + message);
    }

    final static public void logUnknownWithDate(String message){
        System.out.println("[" + date + "]" + " - " + (char) 27 + "[0;97m" + "[Unknown]" + (char) 27 + "[0m" + " - " + message);
    }
}
