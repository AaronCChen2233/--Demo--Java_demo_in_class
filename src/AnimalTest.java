public class AnimalTest {
    public static void main(String[] args) {
        Animal animal = new Animal();
        Fish fish = new Fish();
        Dog dog = new Dog();
        Cat cat = new Cat();

        animal.sleep();
        animal.eat();
        fish.sleep();
        fish.eat();
        dog.sleep();
        dog.eat();
        cat.sleep();
        cat.eat();
    }
}
