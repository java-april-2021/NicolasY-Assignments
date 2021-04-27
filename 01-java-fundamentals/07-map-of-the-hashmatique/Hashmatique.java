import java.util.Hashmap;

public class Hashmatique {
    public static void Challenge() {
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("Happy", "Because I'm happy!");
        map.put("Im yours", "But I wont hesitate no more...");
        map.put("Peaches", "I get my peaches down in Georgia..");
        map.put("Where is the love?", "What's wrong with the world, mama...");

        String val = map.get("Where is the love?");
        String val = map.get("Im yours");
        String val = map.get("Peaches");

        for (String key: map.keySet()){
            System.out.println(String.format("Track: %s Lyrics: %s", key, map.get(key)));
        }
    }
}