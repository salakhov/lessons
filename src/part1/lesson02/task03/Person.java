package part1.lesson02.task03;

/**
 * Класс Person характеризуется полями
 * age (возраст, целое число 0-100),
 * sex (пол – строка, принимающая значение MAN или WOMAN)
 * name (имя - строка).
 */

class Person {
    private Integer age;
    private String sex;
    private String name;

    public Integer getAge() {
        return age;
    }
    public String getSex() {
        return sex;
    }

    public String getName() {
        return name;
    }

    public Person(Integer age, String sex, String name) {
        this.age = age;
        this.sex = sex;
        this.name = name;
    }

    //@Override
    //public int compareTo(Object o) {
    //    return 0;
    //}
}
