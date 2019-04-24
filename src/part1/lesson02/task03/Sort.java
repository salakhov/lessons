package part1.lesson02.task03;

import java.util.ArrayList;

/**
 * Единый Интерфейс для классов сортировки
 */
interface Sort {
    void SortManFirst(Person[] persons);
    void SortAgeMax(Person[] persons);
    void SortAlfabetName(Person[] persons);
}
