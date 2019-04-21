package part1.lesson02.task03;

/**
 * Задание 3. Дан массив объектов Person. Класс Person характеризуется полями age (возраст, целое число 0-100),
 * sex (пол – объект класса Sex со строковыми константами внутри MAN, WOMAN), name (имя - строка).
 * Создать два класса, методы которых будут реализовывать сортировку объектов.
 * Предусмотреть единый интерфейс для классов сортировки.
 *
 * Реализовать два различных метода сортировки этого массива по правилам:
 * первые идут мужчины
 * выше в списке тот, кто более старший
 * имена сортируются по алфавиту
 * Программа должна вывести на экран отсортированный список и время работы каждого алгоритма сортировки.
 * Предусмотреть генерацию исходного массива (10000 элементов и более).
 * Если имена людей и возраст совпадают, выбрасывать в программе пользовательское исключение.
 */

import java.util.ArrayList;
import java.util.Random;

public class Main {
    private static ArrayList<Person> personArray;

        public static void main(String[] args) {
            // отключаем trim сортировку, на java 1.8.0.131 глючит сортировка Collections.sort
            System.setProperty("java.util.Arrays.useLegacyMergeSort", "true");
            iSort bubbleSort = new BubbleSort();
            iSort quickSort = new QuickSort();

            generatePersonArray();
            System.out.println("[DEBUG] ************ Исходный массив**********");
            printPersons();

            //System.out.println("[DEBUG] ************ Сортировка методом пузырька. По возрасту**********");
            bubbleSort.SortAgeMax(personArray);
            //printPersons();
            //System.out.println("[DEBUG] ************ Сортировка методом пузырька. По арфавиту**********");
            bubbleSort.SortAlfabetName(personArray);
            //printPersons();
            //System.out.println("[DEBUG] ************ Сортировка методом пузырька. Мужчины первые**********");
            bubbleSort.SortManFirst(personArray);
            //printPersons();

            //System.out.println("[DEBUG] ************ Сортировка методом merge. По возрасту**********");
            quickSort.SortAgeMax(personArray);
            //printPersons();
            //System.out.println("[DEBUG] ************ Сортировка методом merge. По алфавиту**********");
            quickSort.SortAlfabetName(personArray);
            //printPersons();
            //System.out.println("[DEBUG] ************ Сортировка методом merge. Мужчины первые**********");
            quickSort.SortManFirst(personArray);
            //printPersons();
    }

    /**
     * Функция заполнения массива списка с объектами Persons
     * Имена формируются из справочника путем компановки имении фамилии случайным образом
     * Пол формируется случайным выбором из справочника полов
     * возраст генерируется случайным образом
     */
    static void generatePersonArray() {
        personArray = new ArrayList<Person>();

        Random rnd = new Random();
        String[] firstnames = {"Mikhail", "Vasiliy", "Dmitry", "Igor", "Lena", "Anya","Ktya","Julia"};
        String[] lastnames = {"Salakhov", "Ivanov", "Petrov", "Dreama", "Peprbyf","Bashirov","Vasechkin"};
        String[] sexs = {"MAN", "WOMAN"};

        for (int i = 0; i < 10000; i++) {
            String name = firstnames[rnd.nextInt(firstnames.length-1)] + " " + lastnames[rnd.nextInt(firstnames.length-1)];
            String sex = sexs[rnd.nextInt(sexs.length)];
            Integer age = rnd.nextInt(100);
            Person person = new Person(age, sex, name);
            personArray.add(person);
        }
    }

    /**
     * Функция печати списка объектов person
     */
    static void printPersons(){
        for (Person person:personArray) {
            System.out.println("[DEBUG] name " + person.getName() +
                    " sex: " + person.getSex() +
                    " age: " + person.getAge());
        }
    }
}
