public class Wizard extends Human {
    
    public Wizard(){
        this.health = 50;
        this.intelligence = 8;
    }

    public void heal(Human target){
        System.out.println("You have healed: " + Human);
        target.health += this.intelligence;
    }

    public void fireball(Human target){
        System.out.println("You threw your fireball!");
        target.health -= (this.intelligence * 3);
    }
}