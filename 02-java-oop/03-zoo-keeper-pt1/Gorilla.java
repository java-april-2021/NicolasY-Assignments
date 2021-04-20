public class Gorilla extends Mammal {
    public Gorilla(){
        super(energyLevel);
    }
    
    public void throwSomething(){
        System.out.println("Threw something over there");
        energyLevel -= 5;
    }

    public void eatBananas(){
        System.out.println("Ate a banana");
        energyLevel += 10;
    }

    public void climb(){
        System.out.println("Climing something");
        energyLevel -= 10;
    }

}