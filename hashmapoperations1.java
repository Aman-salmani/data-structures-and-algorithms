import java.util.*;

public class hashmapoperations1 {
    public static void main(String[] args) {
        HashMap<String,Integer> map = new HashMap<>();
        map.put("Math",95);
        map.put("Science",98);
        map.put("English",90);
        System.out.println(map);
        int marks = map.get("English");
        System.out.println("Marks of English-" + marks);
      System.out.println("Is map comtain Math ? " + map.containsKey("Math"));
        map.put("Science",92);
        map.remove("English");
          System.out.println("After romoving English- " + map);
        System.out.println("Size of the Map-"+ map.size());
        map.clear();
        System.out.println("Map is Empty ? "+ map.isEmpty());
    }
}