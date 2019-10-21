public class Fish extends Animal {
    @Override
    public void sleep() {
        System.out.println("They sleep in water.");
    }

    @Override
    public void eat() {
        System.out.println("hey eat plankton.");
    }

    public String color;
    public static String staticColor;

    Fish(String color){
        this.color = color;
        Fish.staticColor = color;
    }

    void Swim(){
        System.out.println("");
    }

    Fish(){

    }
}
