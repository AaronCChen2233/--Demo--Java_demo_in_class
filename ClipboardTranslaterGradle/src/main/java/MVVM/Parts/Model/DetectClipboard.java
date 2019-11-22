package MVVM.Parts.Model;

import java.awt.*;
import java.awt.datatransfer.*;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.Pattern;

public class DetectClipboard implements ClipboardOwner, IMVVM_Model {
    private Clipboard clipboard;
    private Transferable content;

    public DetectClipboard() {
        clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
    }

    /**
     * get Clipboard
     * @return if return is null mean doesn't have string
     */
    public String tryGetClipboardString() {
        content = clipboard.getContents(this);

        try {
            if (content.isDataFlavorSupported(DataFlavor.stringFlavor)) {
                String clipboardString = (String) content.getTransferData(DataFlavor.stringFlavor);
                return clipboardString;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

//    public boolean isDataChange() {
//        if (content.isDataFlavorSupported(DataFlavor.stringFlavor)) {
//            try {
//                return !transferData.equals(content.getTransferData(DataFlavor.stringFlavor));
//            } catch (UnsupportedFlavorException e) {
//                e.printStackTrace();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//        return false;
//    }

    public void lostOwnership(Clipboard clipboard, Transferable contents) {
        //System.out.println("lostOwnership...");
    }

    public static abstract class DetectClipboardThread extends Thread implements Runnable {
        public void run() {
            Timer timer = new Timer();

            // check every 1 seconds
            timer.schedule(new DateTask() {
                @Override
                public void clipboardStringChange(String newString) {
                    /*If newString have space don't search because now only support single vocabulary*/
                    newString = newString.trim();
                    newString = newString.toLowerCase();
                    if(Pattern.matches("([a-z])\\w+", newString)){
                        detectClipboardStringChange(newString);
                    }
                }
            }, 1000, 1000);
        }
        public abstract void detectClipboardStringChange(String newString);
    }

    static abstract class DateTask extends TimerTask {
        DetectClipboard dc = new DetectClipboard();
        String beforeString = "";

        @Override
        public void run() {
            String newString = dc.tryGetClipboardString();
            /*if newString is null mean Clipboard doesn't have string*/
            if (newString != null) {
                /*String change*/
                if (!beforeString.equals(newString)) {
                    clipboardStringChange(newString);
                    beforeString = newString;
                }
            }
        }

        public abstract void clipboardStringChange(String newString);
    }
}
