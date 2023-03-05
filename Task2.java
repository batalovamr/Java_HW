// Реализуйте алгоритм сортировки пузырьком числового массива, результат после каждой итерации запишите в лог-файл.

import java.lang.System.Logger;
import java.util.Arrays;
import java.util.logging.*;

public class Task2 {
    private static Logger logger = Logger.getLogger(Task2.class.getName());
    public static void main(String[] args) {
        int[] arr = {1, 6, 3, 9, 20, 56, 2};
        System.out.println(Arrays.toString(arr));
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void bubbleSort(int[] array) {
        for (int i = array.length; i >= 0; i--) {
            for (int j = 0; j < i && j + 1 < i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    logger.log(Level.INFO, String.format("%d <-> %d, %s", array[j], array[j + 1], Arrays.toString(array)));
                }
            }
        }
    }
}

