package part1.lesson05.task01;

/**
 * Разработать программу – картотеку домашних животных. У каждого животного есть уникальный идентификационный номер,
 * кличка, хозяин (объект класс Person с полями – имя, возраст, пол), вес.
 *
 * Реализовать:
 *
 * метод добавления животного в общий список (учесть, что добавление дубликатов должно приводить к исключительной ситуации)
 * поиск животного по его кличке (поиск должен быть эффективным)
 * изменение данных животного по его идентификатору
 * вывод на экран списка животных в отсортированном порядке. Поля для сортировки –  хозяин, кличка животного, вес.
 */

public class Main {


    public static void main(String[] args) {
        Master master1=new Master("Хelen",10,"MAN");
        Master master2 =new Master("Huan",30,"MAN");
        Master master3 =new Master("Alina",20,"WOMAN");
        Master master4 =new Master("Alina",30,"WOMAN");

        Pet pet1=new Pet(1,"barsik",master1,10);
        Pet pet2=new Pet(2,"mursic",master3,20);
        Pet pet3=new Pet(3,"marusya",master2,30);
        Pet pet4=new Pet(4,"vsevolod nikolaevich",master2,20);
        Pet pet5=new Pet(5,"kizka",master4,24);

        System.out.println("*** Добавление животного в общий список");
        PetIndex index = new PetIndex();
        try {
            index.addPet(pet1);
            index.addPet(pet2);
            index.addPet(pet3);
            index.addPet(pet4);
            index.addPet(pet5);
        }
        catch (PetInCollectionException e){
            e.printStackTrace();
        }

        index.printUnsorted();
        System.out.println("-----");
        System.out.println("*** Поиск животного по кличке");
        Pet findPet = index.findPet("marusya");
        if(findPet!=null) {
            System.out.println("Кот " + findPet.getName() + " найден "+ findPet.toString());
        }
        System.out.println("-----");
        System.out.println("Изменение хозяина у животного с идентификатором 3");
        index.modifyPetMasterById(3,master1);
        index.printUnsorted();
        System.out.println("-----");
        System.out.println("Изменение имени у животного с идентификатором 3");
        index.modifyPetNameById(3,"hrusha");
        index.printUnsorted();
        System.out.println("-----");
        System.out.println("Вывод на экран животных в отсортированном порядке");
        index.printSorted();
        System.out.println("-----");
    }
}
