class ProjectTest {
    public static void main(String[] args) {
        Project ProjectOne = new Project();
        Project ProjectTwo = new Project();
        ProjectOne.setName("Java");
        ProjectTwo.setName("Python");
        ProjectOne.setDescription("Hard coding language!");
        ProjectTwo.setDescription("Beginner friendly coding language!");
        ProjectOne.getName();
        ProjectOne.getDescription();
        ProjectTwo.getName();
        ProjectTwo.getDescription();
        ProjectOne.elevatorPitch();
    }
}