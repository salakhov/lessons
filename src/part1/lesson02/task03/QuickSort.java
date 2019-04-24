package part1.lesson02.task03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

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

    /**
     * Сортировка методом пузырька по принципу первыми идут мужчины
     * @param persons - список объектов person
     */
    @Override
    public void SortManFirst(Person[] persons){
        startTime = System.currentTimeMillis();
        Arrays.sort(persons, new Comparator<Person>() {
            public int compare(Person o1, Person o2) {
                if (o1.getSex().compareTo("WOMAN")==0)
                    return 1;
                else
                    return -1;
            }
        });
        endTime = System.currentTimeMillis();
        printSortTime("первые идут мужчины");
    }

    /**
     * Сортировка методом пузырька по убыванию возраста
     * @param persons - список объектов person
     */
    @Override
    public void SortAgeMax(Person[] persons){
        startTime = System.currentTimeMillis();
        Arrays.sort(persons, new Comparator<Person>() {
            public int compare(Person o1, Person o2) {
                return o2.getAge()-o1.getAge();
            }
        });
        endTime = System.currentTimeMillis();
        printSortTime("выше в списке тот, кто более старший");
    }

    /**
     * Сортировка методом пузырька по алфавиту
     * @param persons - список объектов person
     */
    @Override
    public void SortAlfabetName(Person[] persons){
        startTime = System.currentTimeMillis();
        Arrays.sort(persons, new Comparator<Person>() {
            public int compare(Person o1, Person o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        endTime = System.currentTimeMillis();
        printSortTime("имена сортируются по алфавиту");
    }

    private void printSortTime(String algText){
        long duration = endTime-startTime;
        System.out.println("[INFO] "+algNameText+" по принципу "+algText+" заняла "+duration+"ms");
    }
}
