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

// замечания от 23.04.2019
//1. DONE реализовать интерфейс в классе Person унаследовать его от Comparable
//2. DONE переименовать интерфейс iSort в соответствии c JavaCodeConversion
//3. DONE В функциях применять примитив (не ArrayList а List) (заменено на Persons [])
//4. DONE Отсортировать сначала мужчины, потом по старшенству, потом по возрасту, а не один массив несколько раз сортировать
//5. DONE выбрасывать исключение в методе generate
//6. DONE использовать массив а не коллекцию. Возможно массив сортировать методами arrays - sort.

import java.util.Random;

public class Main {
    private static Person[] personArray;

        public static void main(String[] args) {
            // отключаем trim сортировку, на java 1.8.0.131 глючит сортировка Collections.sort
            System.setProperty("java.util.Arrays.useLegacyMergeSort", "true");
            Sort bubbleSort = new BubbleSort();
            Sort quickSort = new QuickSort();
            try {
                generatePersonArray();
            }
            catch  (CustomException err){
                err.printStackTrace();
            }

            System.out.println("[DEBUG] ************ Исходный массив**********");
            printPersons();

            System.out.println("[DEBUG] ************ Сортировка методом merge. **********");
            quickSort.Sort(personArray);
            printPersons();

            System.out.println("[DEBUG] ************ Сортировка методом пузырька.**********");
            bubbleSort.Sort(personArray);
            printPersons();
        }

    /**
     * Функция заполнения массива списка с объектами Persons
     * Имена формируются из справочника путем компановки имении фамилии случайным образом
     * Пол формируется случайным выбором из справочника полов
     * возраст генерируется случайным образом
     */
    private static void generatePersonArray() throws CustomException {
        personArray = new Person[10000];

        Random rnd = new Random();
        String[] firstnames = {"Mikhail", "Vasiliy", "Dmitry", "Igor", "Lena", "Anya","Ktya","Julia"};
        String[] lastnames = {"Salakhov", "Ivanov", "Petrov", "Dreama", "Peprbyf","Bashirov","Vasechkin"};
        String[] sexs = {"MAN", "WOMAN"};

        for (int i = 0; i < personArray.length; i++) {
            String name = firstnames[rnd.nextInt(firstnames.length-1)] + " " + lastnames[rnd.nextInt(firstnames.length-1)];
            String sex = sexs[rnd.nextInt(sexs.length)];
            Integer age = rnd.nextInt(5);
            Person person = new Person(age, sex, name);
            personArray[i] =person;
        }
        for (int i = 0; i < personArray.length; i++) {
            if (personArray[i].getName().compareTo(personArray[i].getName())==0)
                throw new CustomException("Найдено совпадение имени и фамилии");
        }
    }

    /**
     * Функция печати списка объектов person
     */
    private static void printPersons(){
        for (Person person:personArray) {
            System.out.println("[DEBUG] name " + person.getName() +
                    " sex: " + person.getSex() +
                    " age: " + person.getAge());
        }
    }
}
