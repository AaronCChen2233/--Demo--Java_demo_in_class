package AaronChenTools;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class AaronStringTool {
    public static java.lang.String ShuffleString(String oString) {
        String out = "";
        List<String> shuffleList = Arrays.asList(oString.split(""));
        Collections.shuffle(shuffleList);
        for (String s : shuffleList) {
            out += s;
        }
        return out;
    }
}
