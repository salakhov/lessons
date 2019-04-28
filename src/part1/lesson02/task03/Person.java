package part1.lesson02.task03;

/**
 * Класс Person характеризуется полями
 * age (возраст, целое число 0-100),
 * sex (пол – строка, принимающая значение MAN или WOMAN)
 * name (имя - строка).
 */

class Person implements Comparable <Person> {
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

    /**
     * переопределяем метод. Определяем алгорит для сортировки
     * Сначала проверяем различен ли пол у двух объектов.
     * Затем смотрим на возраст. потом на имя и фамилию
     * @param
     * @return - возврящаемой значение 1 объекты меньше, 0  объекты равны 1 - объекты больше
     */
    @Override
    public int compareTo(Person o) {
        Person person = o;
        int result = 0;
        int resultSex = this.getSex().compareTo(person.getSex()); //0 - равныб <0 strinng <; >0 string >
        int resultAge = this.getAge() - person.getAge(); //0 - равный, <0 this меньше,
        int resultName = this.getName().compareTo(person.getName()); //0 - равный, <0 this меньше,

        if(resultSex==0) {
            if (resultAge == 0) {
                return resultName;
            } else {
                return resultAge>0?-1:1;
            }
        }
        else{
            if(this.getSex().compareTo("MAN")!=0)
                return 1;
            else
                return 0;
        }
    }
}
