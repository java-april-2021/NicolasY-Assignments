public class Bat extends Mammal {

    public Bat(){
        super(300);
    }

    public void fly(){
        System.out.println("Woosh! I'm flying");
        energyLevel -= 50;
    }

    public void eatHumans(){
        System.out.println("Human meat is tasty");
        energyLevel += 25;
    }

    public void attackTown(){
        System.out.println("The town is on fire");
        energyLevel -= 100;
    }
}