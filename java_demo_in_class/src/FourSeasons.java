import java.util.ArrayList;
import java.util.Arrays;

public class FourSeasons {
    public static void main(String[] args) {
        //use Array
        System.out.println("this is use Array");
        String [] seasonArray = {"Spring", "Summer", "Fall", "Winter"};
        System.out.println(Arrays.toString(seasonArray));
        seasonArray[2]="Autumn";
        System.out.println(Arrays.toString(seasonArray));

        //use ArrayList
        System.out.println("this is use ArrayList");
        ArrayList<String> fourSeasons = new ArrayList<String>(Arrays.asList("Spring", "Summer", "Fall", "Winter"));
        System.out.println(fourSeasons);
        fourSeasons.set(2, "Autumn");
        System.out.println(fourSeasons);

//        for(String s : seasonArray){
//            if(s == "Winter"){
//                System.out.print(s);
//            }else {
//                System.out.print(s + ", ");
//            }
//        }
    }
}
