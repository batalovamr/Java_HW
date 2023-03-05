
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
/** В файле содержится строка с исходными данными в такой форме:
{"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}
Требуется на её основе построить и вывести на экран новую строку, в форме SQL запроса:
SELECT * FROM students WHERE name = "Ivanov" AND country = "Russia" AND city = "Moscow";
Для разбора строки используйте String.split. Сформируйте новую строку, используя StringBuilder. Значения null не включаются в запрос. */

public class Task1 {
    public static void main(String[] args) {
        String str = readFile("test.txt");
        System.out.println(str);
        createNewString(str);      
    }

    private static String readFile(String fileName) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));  
            String str;
            while((str = br.readLine()) != null) return str.toString();
            br.close();    
        }catch (IOException ex) {
            System.err.println("Ошибка: " + ex);
        }
        return fileName;
    }

    private static void createNewString(String text) {
        StringBuilder result = new StringBuilder();
        result.append("SELECT * FROM students WHERE ");
        String str = text.substring(1, text.length() - 1);
        String[] arr = str.split(", ");
        boolean isFirst = true;
        for (String el : arr) {
            String[] keyValue = el.split(":");
            String key = keyValue[0];
            key = key.substring(1, key.length() - 1);
            String value = keyValue[1];
            if (value.equals("\"null\"")) continue;
            if (!isFirst) result.append("AND ");
            result.append(String.format("%s = %s ", key, value));
            isFirst = false;
        }
        System.out.println(result);
    }

}
