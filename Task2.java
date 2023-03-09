// Пусть дан произвольный список целых чисел. Удалить из него чётные числа.
package hw_3;

import java.util.ArrayList;
import java.util.Random;

public class Task2 {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        Random rnd = new Random();
        for (int i = 0; i < 10; i++) arr.add(rnd.nextInt(0,20));
        System.out.println(arr);
        arr.removeIf(i -> (i % 2 == 0));
        System.out.println(arr);
    }
}
