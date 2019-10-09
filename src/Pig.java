public class Pig extends Animal {
    public void makeSound(){
        System.out.println("Pig says: oink oink");
    }

    @Override
    public void animalSound() {
        System.out.println("Pig says: oink oink oink oink");
    }
}
