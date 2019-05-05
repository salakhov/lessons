package part1.lesson05.task01;

/**
 * Класс домашнее животное. Наследуется от класса Comparable для обеспечение записи в TreeSet для сортировки
 * Пoля id - идентификатор
 *      name - Кличка
 *      master - хозяин
 *      weight - вес.
 *
 */

public class Pet implements Comparable {
    private int id;
    private String name;
    private Master master;
    private int weight;

    public Pet(int id, String name, Master master,int weight) {
        this.id = id;
        this.name = name;
        this.master = master;
        this.weight = weight;
    }

    public int getId() {
        return id;
    }
    public Master getMaster() {
        return master;
    }
    public String getName() {
        return name;
    }
    public void setMaster(Master master) {
        this.master = master;
    }
    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", master=" + master +
                ", weight=" + weight +
                '}';
    }

    /**
     * Сначала сортируются по Хозяину (метод сравнения хохяев переопределен в классе Master)
     * Затем сортируем по алфавиту имени и весу.*
     * @param o
     * @return
     */
    @Override
    public int compareTo(Object o) {
        Pet pet = (Pet)o;
        int result = 0;
        int resultMaster = this.getMaster().compareTo(pet.getMaster());
        int resultWeight = this.getWeight() - pet.getWeight(); //0 - равный, <0 this меньше,
        int resultName = this.getName().compareTo(pet.getName()); //0 - равный, <0 this меньше,

        if(resultMaster==0) {
            if (resultName == 0) {
                result = resultWeight;
            }
            else
                result = resultName;
        }
        else{
            result=resultMaster;
        }
        return result;
    }
}

