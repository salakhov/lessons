package part1.lesson02.task03;

import java.util.Comparator;

public class PersonManComparator implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        if (o1.getSex().compareTo("WOMAN")==0)
            return 1;
        else
            return -1;
    }
}
