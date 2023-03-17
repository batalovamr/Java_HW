import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Task2 {
    public static void main(String[] args) {
        ArrayList<String> arr = new ArrayList<>();
        arr.add("Ива");
        arr.add("Петр");
        arr.add("Михаи");
        arr.add("Иван");
        arr.add("Ольга");
        arr.add("Петр");
        arr.add("Иван");
        arr.add("Мария");
        arr.add("Михаил");
        System.out.println(arr);   
        Map<String, Integer>duplicates = new HashMap<>();    
        for (int i = 0; i < arr.size(); i++) {
            int count = 1;
            String e1 = arr.get(i);
            if (e1 == null) continue; // игнорируем null
            // сравниваем каждый элемент со всеми остальными
            for (int j = i; j < arr.size(); j++) {
                if (i == j) continue; // не проверяем элемент с собой же
                String e2 = arr.get(j);
                if (e1.equals(e2)) {
                    // дубликат найден, сохраним его
                    count += 1;
                    duplicates.put(e2, count);                  
                }               
            }           
        }
        System.out.println(duplicates.toString());
    }
}
