import java.util.ArrayList;
import java.util.Arrays;

public class FourSeasons {
    public static void main(String[] args) {
        ArrayList<String> fourSeasons = new ArrayList<String>(Arrays.asList("Spring","Summer","Fall","Winter"));
        System.out.println(fourSeasons);
        fourSeasons.set(2,"Autumn");
        System.out.println(fourSeasons);
    }
}
