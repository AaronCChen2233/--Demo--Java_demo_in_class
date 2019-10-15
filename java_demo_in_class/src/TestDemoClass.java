public class TestDemoClass extends FirstClass {
    int x;
    int modeYear;
    String modeName;

    // First method here
    public void fullThrottle() {
        System.out.println("This car is going as fast as it can.");
    }

    public TestDemoClass() {
        x = 10;
    }

    /***
     *
     * @param _modeYear This is Year
     * @param _modeName This is Name
     */
    public TestDemoClass(int _modeYear, String _modeName) {
        modeName = _modeName;
        modeYear = _modeYear;
    }

    //Second method here
    public void speed(int maxSpeed) {
        System.out.println("The max speed is: " + maxSpeed);
    }

    final int INTEREST = 3;
    String dad = "Steve";
    String mom = "Jane";
    String son = "David";
    int dadage = 40;
    int momage = 35;
    int sonage = 18;

    public static void staticSayWeather() {
        System.out.println("this is static showing Today we don't have rain");
    }

    public void sayWeather() {
        privateSayWeather();
    }

    private void privateSayWeather() {
        System.out.println("this is private showing Today we don't have rain");
    }

    public static void Family() {

    }

    /***
     * @param dadname Dad's name
     * @param momname Mom's name
     * @param sonname Son's name
     */
    public void changename(String dadname, String momname, String sonname) {
        dad = dadname;
        mom = momname;
        son = sonname;
    }

}
