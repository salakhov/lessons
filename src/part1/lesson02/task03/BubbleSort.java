package part1.lesson02.task03;

import java.util.ArrayList;

/**
 * Класс сортировки методом пузырька. Класс реализует собственные алгоритмы сортировки
 */


class BubbleSort implements Sort {

    private Person [] persons;
    private long startTime;
    private long endTime;
    private String algNameText;

    public BubbleSort() {
        this.algNameText = "Сортировка методом пузырька";
    }

    /**
     * Сортировка методом пузырька по принципу первыми идут мужчины
     * @param persons - список объектов person
     */
    @Override
    public void SortManFirst(Person [] persons){
        this.persons = persons;
        startTime = System.currentTimeMillis();
        for (int out = this.persons.length - 1; out >= 1; out--){
            for (int in = 0; in < out; in++){
                int result = this.persons[in].getSex().compareTo("MAN");
                if(result != 0)
                    toSwap(in, in+1);
            }
        }
        endTime = System.currentTimeMillis();
        printSortTime("первые идут мужчины");
    }

    /**
     * Сортировка методом пузырька по убыванию возраста
     * @param persons - список объектов person
     */
    @Override
    public void SortAgeMax(Person [] persons){
        this.persons = persons;
        startTime = System.currentTimeMillis();
        for (int out = this.persons.length - 1; out >= 1; out--){
            for (int in = 0; in < out; in++){
                if(this.persons[in].getAge() < this.persons[in+1].getAge())
                    toSwap(in, in+1);
            }
        }
        endTime = System.currentTimeMillis();
        printSortTime("выше в списке тот, кто более старший");
    }

    /**
     * Сортировка методом пузырька по алфавиту
     * @param persons - список объектов person
     */
    @Override
    public void SortAlfabetName(Person [] persons) {
        this.persons = persons;
        startTime = System.currentTimeMillis();
        for (int out = this.persons.length - 1; out >= 1; out--){
            for (int in = 0; in < out; in++){
                int result = this.persons[in].getName().compareTo(this.persons[in+1].getName());
                if(result > 0)
                    toSwap(in, in+1);
            }
        }
        endTime = System.currentTimeMillis();
        printSortTime("имена сортируются по алфавиту");
    }

    /**
     * Функция перестановки элементов в списке с заданными индексами
     * @param first,second  - индексы элементов в массиве которые надо поменять
     */
    private void toSwap(int first, int second){
        Person dummy = persons[first];
        persons[first] = persons[second];
        persons[second] = dummy;
    }

    /**
     * печать времени выполнения алгоритма сортировки
     * @param algText - принцип сортировки
     */
    private void printSortTime(String algText){
        long duration = endTime-startTime;
        System.out.println("[INFO] "+algNameText+" по принципу "+algText+" заняла "+duration+"ms");
    }
}
