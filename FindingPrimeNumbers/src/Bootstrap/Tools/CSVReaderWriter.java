package Bootstrap.Tools;

import java.io.*;
import java.util.ArrayList;

public class CSVReaderWriter {
    /***
     * @param scvPath
     * @return
     */
    public static ArrayList<String> reader(String scvPath) {
        ArrayList<String> lines = null;

        try {
            InputStreamReader isr = new InputStreamReader(new FileInputStream(scvPath));
            BufferedReader reader = new BufferedReader(isr);
            String line = null;
            lines = new ArrayList<String>();

            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return lines;
    }

    /***
     * @param scvPath
     * @param pushData
     * @return
     */
    public static boolean pushWriter(String scvPath, String pushData) {
        try {
            /*Read*/
            InputStreamReader isr = new InputStreamReader(new FileInputStream(scvPath));
            BufferedReader reader = new BufferedReader(isr);

            /*keep in lines*/
            ArrayList<String> lines = new ArrayList<String>();
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }

            /*write*/
            BufferedWriter bw = new BufferedWriter(new FileWriter(scvPath));
            for(String ostr :lines){
                bw.write(ostr);
                bw.newLine();
            }

            /*push*/
            bw.write(pushData);
            bw.close();
            return true;
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return false;
        }
    }

    /***
     * @param scvPath
     * @param Data
     * @return
     */
    public static boolean writer(String scvPath, String Data) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(scvPath));
            bw.write(Data);
            bw.close();
            return true;
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return false;
        }
    }
}
