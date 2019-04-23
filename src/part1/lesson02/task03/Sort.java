package part1.lesson02.task03;

import java.util.ArrayList;

/**
 * Единый Интерфейс для классов сортировки
 */
interface Sort {
    void SortManFirst(ArrayList<Person> persons);
    void SortAgeMax(ArrayList<Person> persons);
    void SortAlfabetName(ArrayList<Person> persons);
}
