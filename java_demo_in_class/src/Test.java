public class Test {
    public static void main(String[] args) {
        char t = 8;
        System.out.println(t);
        Fish f = new Fish("red");
        System.out.println(Fish.staticColor);
        System.out.println(f.color);
        System.out.println(f.getClass().getSimpleName());
    }
    public class Cat{
        Cat(){

        }
    }
}
