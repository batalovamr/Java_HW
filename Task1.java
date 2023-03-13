// Пусть дан LinkedList с несколькими элементами. Реализуйте метод, который вернет “перевернутый” список.

import java.util.LinkedList;
public class Task1 {
    public static void main(String[] args) {
        LinkedList<Integer> myList = new LinkedList<>();
        myList.add(1);
        myList.add(2);
        myList.add(3);
        myList.add(4);
        myList.add(5);
        System.out.println(myList.toString());
        for (int i = 0; i < myList.size() / 2; i ++){
            int temp = myList.get(i);
            myList.set(i, myList.get(myList.size() - i - 1));
            myList.set(myList.size() - i - 1, temp);
        }
        System.out.println(myList.toString());
    }
}
