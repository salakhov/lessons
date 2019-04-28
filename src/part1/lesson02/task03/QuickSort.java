package part1.lesson02.task03;
import java.util.Arrays;

/**
 * Класс реализующий методы сортировки с использованием системных библиотек Java
 * Сортировка выполняется методом merge
 */

public class QuickSort implements Sort {
    public QuickSort() {
        this.algNameText = "Сортировка методом merge (встроенные средсва Java)";
    }

    private String algNameText;     //название алгоритма сортировки для журналирования
    private long startTime;         //время начала сортировки
    private long endTime;           //время оконания сортировки

    @Override
    public void Sort(Person[] persons) {
        startTime = System.currentTimeMillis();
        Arrays.sort(persons);
        endTime = System.currentTimeMillis();
        printSortTime("Сначала мужчины, потом возраст, потом по алфавиту");
    }

    private void printSortTime(String algText){
        long duration = endTime-startTime;
        System.out.println("[INFO] "+algNameText+" по принципу "+algText+" заняла "+duration+"ms");
    }
}
