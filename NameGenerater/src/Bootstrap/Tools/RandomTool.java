package Bootstrap.Tools;

import java.util.Random;

public class RandomTool {
    public static int GetRandomInt(int max){
        Random r = new Random();
        int randomInt = r.nextInt(max) + 1;
        return randomInt;
    }
}
