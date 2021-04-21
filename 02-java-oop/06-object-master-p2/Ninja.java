public class Ninja extends Human {
    private static int defaultStealth = 10;
    
    public Ninja(){
        this.stealth = Ninja.defaultHealth;
    }

    public void steal(Human target){
        target.health -= this.stealth;
        this.health += this.stealth;
    }

    public void runAway(){
        this.health -= 10;
    }
}