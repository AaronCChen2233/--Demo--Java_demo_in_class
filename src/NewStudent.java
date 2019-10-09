public class NewStudent {
    int x = 20;
    public static void main(String[] args){
        NewStudent sally = new NewStudent();
        int y = sally.x;
        String z = "20";
        String a = z;
        z = "50";
        sally.x = 30;
        System.out.println(sally.x);
        System.out.println(y);
        System.out.println(z);
        System.out.println(a);
    }
}
