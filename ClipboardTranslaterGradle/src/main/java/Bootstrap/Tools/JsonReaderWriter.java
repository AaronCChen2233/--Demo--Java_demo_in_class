package Bootstrap.Tools;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;

public class JsonReaderWriter {
    /***
     * @param path
     * @return
     */
    public static ArrayList<String> reader(String path, String objName) {
        ArrayList<String> arrayList = new ArrayList<String>();

        JSONParser parser = new JSONParser();
        try {

            Reader reader = new FileReader(path);
            JSONObject jsonObject = (JSONObject) parser.parse(reader);

            // loop array
            JSONArray msg = (JSONArray) jsonObject.get(objName);
            arrayList = (ArrayList<String>) msg.iterator();
        }
        catch (ParseException e) {
            e.printStackTrace();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        return arrayList;
    }

    /***
     * @param path
     * @param pushData
     * @return
     */
//    public static boolean pushWriter(String path, String pushData) {
//
//    }

    /***
     * @param path
     * @param Data
     * @return
     */
//    public static boolean writer(String path, String Data) {
//
//    }
}
