import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;
/**В файле содержится строка с данными:
[{"фамилия":"Иванов","оценка":"5","предмет":"Математика"}, {"фамилия":"Петрова","оценка":"4","предмет":"Информатика"}, {"фамилия":"Краснов","оценка":"5","предмет":"Физика"}]
Напишите метод, который разберёт её на составные части и, используя StringBuilder создаст массив строк такого вида:
Студент Иванов получил 5 по предмету Математика.
Студент Петрова получил 4 по предмету Информатика.
Студент Краснов получил 5 по предмету Физика. */

public class Task3 {
    public static void main(String[] args) {
        String str = readFile("test3.txt");
        System.out.println(str);
        String text = str.substring(1, str.length() - 1);
        String[] students = text.split(", ");
        for (String student : students) {
            student = student.substring(1, student.length() - 1);
            String[] keyValues = student.split(",");
            String name = "", grade = "", subject = "";
            for (String keyValue : keyValues) {
                String[] keyValueParts = keyValue.split(":");
                String key = keyValueParts[0].substring(1, keyValues[0].length() - 1);
                String value = keyValueParts[1].substring(1, keyValues[1].length() - 1);
                if (key.equals("фамилия")) name = value;
                else if (key.equals("оценка")) grade = value;
                else if (key.equals("предмет")) subject = value;
            }
            System.out.printf("Cтудент %s получил %s по предмету %s.\n", name, grade, subject);
        }
        // createNewString(str);      
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
    
}