// Задан целочисленный список ArrayList. Найти минимальное, максимальное и среднее арифметичское этого списка
package hw_3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Task3 {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        Random rnd = new Random();
        for (int i = 0; i < 10; i++) arr.add(rnd.nextInt(0,20));
        System.out.println(arr);
        System.out.println("Минимальное число: " + Collections.min(arr));
        System.out.println("Максимальное число: " + Collections.max(arr));
        int sum = 0;
        for (int el : arr) {
            sum += el;
        }
        System.out.println("Среднее арифметическое: " + sum / arr.size());
    }

}
