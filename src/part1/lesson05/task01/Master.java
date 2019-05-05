package part1.lesson05.task01;

/**
 * хозяин (объект класс Master с полями – имя, возраст, пол).
 */

public final class Master implements Comparable {
    private String name;
    private Integer age;
    private String sex;

    public Master(String name, Integer age, String sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Masrer{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                '}';
    }

    public String getName() { return name;}
    public Integer getAge() { return age;}
    public String getSex()  { return sex;}

    /**
     * Переопределяем метод Compare для того что бы обеспечить сорттировку домашних животных
     * по полю хозяин. Сначала сортировка по алфавиту Имени, потом по возрасту
     * @param o - объект класса Master
     * @return
     */
    @Override
    public int compareTo(Object o) {
        Master master=(Master) o;
        int result;
        result = this.getName().compareTo(master.getName());
        if (result==0){
            result = this.getAge()-master.getAge();
        }
        return result;
    }
}
