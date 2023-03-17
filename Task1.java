import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Task1 {
    public static void main(String[] args) {
        Map<Integer, String> phoneBook = new HashMap<>();
        phoneBook.put(123, "Иванов Иван Иванович");
        phoneBook.put(456, "Петров Петр Петрович");
        phoneBook.put(789, "Иванов Иван Иванович");
        System.out.println(phoneBook);

        searchByNumber(123, phoneBook);
        searchByName("Иванов Иван Иванович", phoneBook);
        printAllContacts(phoneBook);
        System.out.println(phoneBook);
        addNewContact(phoneBook, 345, "Сидоров Иван Петрович");
        System.out.println(phoneBook);
        deleteContact(phoneBook, 123);
        System.out.println(phoneBook);
    }

    static void searchByNumber(int num, Map<Integer, String> phoneBook) {
        if (phoneBook.containsKey(num)) System.out.printf("Номер %d имеет абонент %s\n", num, phoneBook.get(num));
        else System.out.print("Такого номера нет");
    }

    static void searchByName(String name, Map<Integer, String> phoneBook) {
        ArrayList<Integer> key = new ArrayList<>();
        for (Integer k : phoneBook.keySet()) {
            if (phoneBook.get(k).equals(name) )  {
                key.add(k);
            }
        }
        System.out.println("Cписок номеров абонента " + name + key.toString());
    } 

    static void printAllContacts(Map<Integer, String> phoneBook){
        System.out.println("ALL CONTACTS " + phoneBook);
    }

    static void addNewContact(Map<Integer, String> phoneBook, Integer num, String name){      
        if (phoneBook.containsKey((num))) phoneBook.remove(num);
        phoneBook.put(num, name);
    }

    static void deleteContact (Map<Integer, String> phoneBook, Integer num) {
        phoneBook.remove(num);
    }

}
