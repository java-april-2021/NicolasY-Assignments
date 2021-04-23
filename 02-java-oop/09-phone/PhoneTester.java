public class PhoneTester{
    public static void main(String[] args){
        Galaxy s11 = new Galaxy("S11", 99, "Verizon", "Ring Ding Ding!");
        iPhone iPhone12 = new iPhone("12", 100, "AT&T", "ZING!");

        s11.displayInfo();
        System.out.println(s11.ring());
        System.out.println(s11.unlock());

        iPhone12.displayInfo();
        System.out.println(iPhone12.ring());
        System.out.println(iPhone12.unlock());
    }
}