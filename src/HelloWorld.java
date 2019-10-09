import java.util.Scanner;

public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("    J     A     V     V    A");
        System.out.println("    J    A A     V   V    A A");
        System.out.println("J   J   AAAAA     V V    AAAAA");
        System.out.println(" J J   A     A     V    A     A");

        System.out.println();

//        System.out.println("n" + "\t" + "n^2" + "\t" + "n^3");
//        for (int i = 1; i <= 4; i++) {
//            System.out.println(i + "\t" + i * i + "\t" + i * i * i);
//        }

        System.out.println("a\ta^2\ta^3\t");
        for (int i = 1; i <= 4; i++) {
            System.out.printf("%d\t%d\t%d\t\n",i,i*i,i*i*i);
        }

        System.out.println();

        System.out.println("9.5 * 4.5 - 2.5 * 3");
        System.out.println("——————————————————— = " + (9.5 * 4.5 - 2.5 * 3) / (45.5 - 3.5));
        System.out.println("    45.5 - 3.5     ");

        System.out.println();

        System.out.println("1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 = " + 1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9);

        System.out.println();

        double principal;
        double rate;
        double years;

        Scanner input = new Scanner(System.in);

        System.out.print("Tell me principal:");
        principal = input.nextDouble();
        System.out.print("Tell me rate:");
        rate = input.nextDouble();
        System.out.print("Tell me how many years:");
        years = input.nextDouble();

        /*Convert to percent*/
        rate /= 100;
        rate /=12;
        /*Convert to month*/
        years *= 12;
        System.out.println("Your Mortgage monthly payment is: " + MortgageCalculator.calculatMortgage(principal, rate, years));
        input.close();
//      Condition
//        Scanner input = new Scanner(System.in);
//        System.out.println("Tell three number");
//        double number1 = input.nextDouble();
//        double number2 = input.nextDouble();
//        double number3 = input.nextDouble();
//        System.out.println("The average of three number is " + (number1 + number2 + number3) / 3);
//        input.close();

//        Pig pig = new Pig();
//        Dog dog = new Dog();
//        pig.animalSound();
//        dog.animalSound();
//        dog.sleepSound();

//        dog.makeSound();
//        pig.makeSound();
//        TestDemoClass t = new TestDemoClass(2019, "UserName");
//        System.out.println(t.firstClassName);

//        Scanner scanner = new Scanner(System.in);
//        int year;
//        String UserName;
//        System.out.print("Tell me your name:");
//
//        UserName = scanner.nextLine();
//
//        System.out.print("Tell me year:");
//        year = scanner.nextInt();
//        scanner.close();
//        TestDemoClass t = new TestDemoClass(year, UserName);
//        System.out.println(t.modeName);
//        System.out.println(t.modeYear);
//        t.speed(200);
//        t.fullThrottle();
//
//        f.sayWeather();
//        TestDemoClass.staticSayWeather();
//        f.INTEREST = 5;
//        System.out.println(f.INTEREST);
//        System.out.println("Dad's name is " + f.dad);
//        f.changename();
//        System.out.println(FirstClass.x);
//        FirstClass baby = new FirstClass();
//        System.out.println(baby.x);
//        for (int i = 1; i <= 49; i++) {
//            System.out.println(i + " to Binary is " + LongToBinaryString(i));
//        }

//        ArrayList<String> foods = new ArrayList<String>();
//        foods.add("Pizza");
//        foods.add("Ice Scream");
//        foods.add("Cookie");
//
//        foods.addAll(new ArrayList<String>(Arrays.asList("test","w")));
//        System.out.println(foods.size());
//        System.out.println(Addition(5,6));
//        try{
//            checkAge(2);
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//        try {
//            int[] intarray = {2, 5, 2};
//            System.out.println(intarray[2]);
//        } catch (Exception e) {
//            System.out.println("There is something wrong");
//        }finally {
//            System.out.println("Whatever happens, it should show this line");
//        }
//        int[][] intarray = {{1, 2, 3}, {5, 6, 7}, {10, 8, 9, 2}};
//        for (int i = 0; i < intarray.length; i++) {
//            for (int j = 0; j < intarray[i].length; j++) {
//                System.out.println(intarray[i][j]);
//            }
//        }
//        System.out.println(intarray[2][1]);
//        int i = 0;
//        String[] foods = {"Steaks", "Spagetti", "Cake", "Salad", "Pizza"};
//        System.out.println(foods[0]);
//        foods[0]="Ice cream";
//        System.out.println(foods[0]);
//        for (String foodname : foods) {
//            if(foodname =="Ice cream"){
//                continue;
//            }
//            System.out.println(foodname);
//        }

//        do{
//            System.out.println(i);
//            i++;
//        }while (i < 5);
//        int x = 14;
//        String message;
//        message = (x > 18) ? "Good Night" : "Good Afternoon";
//        System.out.println(message);

//        int x = 4;
//        int y = 1;
//        if (x > y) {
//            System.out.println("x is greater than y");
//        } else {
//            System.out.println("y is greater than x");
//        }
//        System.out.println(Math.abs(-87.9));
//        for (int i =0;i<5;i++)
//        System.out.println((int)(Math.random()*100 + 31));
//        int x = 4;
//        int y = 5;
//        int z = 200;
//        System.out.println(Math.max(Math.max(x, y), z));
//        LengthOfString.ShowIndex("Please locate the first locat string","the");
//        LengthOfString.ShowStringLength("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
//        LengthOfString.ShowLowerCase("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
//        System.out.println("Hello World");
//        sout("Hello World");
    }


    //    static void checkAge(int age) {
//        if (age < 19) {
//            throw new ArithmeticException("Access Denied-Sorry you are too young!");
//        } else {
//            System.out.println("You are ok to dring. Enjoy~");
//        }
//    }

    public static String LongToBinaryString(long n) {

        if (n == 0)
            return "0";

        String value = "";
        long left = 0;
        while (n >= 1) {
            left = n % 2;
            value = Long.toString(left) + value;
            n = (n - left) / 2;
        }

        return value;
    }

    static int Addition(int x, int y) {
        return x + y;
    }
}
