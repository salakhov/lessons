package part1.lesson02.task03;

import java.util.Comparator;

class PersonNameComarator implements Comparator<Person> {

    @Override
    public int compare(Person o1, Person o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
