import java.util.LinkedList;
import java.util.List;

// Реализуйте очередь с помощью LinkedList со следующими методами:
// enqueue() - помещает элемент в конец очереди, dequeue() - возвращает первый элемент из очереди и удаляет его, 
// first() - возвращает первый элемент из очереди, не удаляя.

public class Task2 {
    private static LinkedList<Integer> list = new LinkedList<>();
    public static void main(String[] args) {
        enqueue(2);
        enqueue(3);
        enqueue(10);
        enqueue(-8);
        System.out.println(list);
        System.out.println(dequeue());
        System.out.println(list);
        System.out.println(first());
        
    }
    private static void enqueue(int num) {
        list.addLast(num);
    }
    private static int dequeue() {
        return list.removeFirst();
    }
    private static int first() {
        return list.getFirst();
    }
}
