package hw_1;

import java.util.Scanner;

public class task3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int number_1, number_2, answer;
        char oper;
        System.out.print("Введите оперцию(+,-,*,/):");
        oper = scan.next().charAt(0);
        System.out.print("Введите первое число:");
        number_1 = scan.nextInt();
        System.out.print("Введите второе число:");
        number_2 = scan.nextInt();
        scan.close();
        boolean correct = true;
        switch (oper) {
            case '+':
                answer = number_1 + number_2;
                break;
            case '-':
                answer = number_1 - number_2;
                break;
            case '*':
                answer = number_1 * number_2;
                break;
            case '/':
                answer = number_1 / number_2;
                break;
            default:
                answer = 0;
                correct = false;
        }
 
        System.out.println(correct ? "Результат: " + answer : "Неверная операция!");
    }
}
