class VideoGameTester{
    public static void main(String [] args){
        Samurai Sam = new Samurai();
        Samurai Sean = new Samurai();
        Ninja Nick = new Ninja();
        Wizard Wendy = new Wizard();
        Sam.deathBlow(Sean);
        Sean.meditate();
    }
}