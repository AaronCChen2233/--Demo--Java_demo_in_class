public class Dog extends Animal {
    public void makeSound(){
        System.out.println("Dog says: 旺旺");
    }

    @Override
    public void animalSound() {
        System.out.println("Dog says: 旺旺旺旺旺旺");
    }
}
