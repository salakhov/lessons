package part1.lesson05.task01;

import java.util.*;

/**
 * Картотека домашних животных. 2 коллекции. TreeSet для сортировки, HashMap для хранения и поиска
 */


public class PetIndex {
    private Set<Pet> set;
    private Map<String, Pet> map;

    public PetIndex() {
        map=new HashMap<>();
        set = new TreeSet<>();
    }

    /**
     * Добавляется животное и в map для поиска и в set для сортировки
     * @param pet добавляемое животное
     * @throws PetInCollectionException - выбрасывается в случае наличия животного в map
     */
    public void addPet(Pet pet) throws PetInCollectionException{
        if(map.containsKey(pet.getName())){
            throw new PetInCollectionException("Кот "+pet.getName()+" уже в коллекции");
        }
        set.add(pet);
        map.put(pet.getName(),pet);
    }

    /**
     * Поиск животного по имени
     * @param petName - имя животного
     * @return - Класс животное
     */
    public Pet findPet(String petName){
        Pet pet=null;
        if(map.containsKey(petName))
            pet = map.get(petName);
        return pet;
    }

    /**
     * Изменение хозяина животного по его идентификатору
     */
    public void modifyPetMasterById(int petId,Master master){
        Iterator <Pet> it = set.iterator();
        Pet petNew;
        Pet petOld;

        while(it.hasNext()) {
            petOld=it.next();
            if (petOld.getId()==petId) {
                petNew=new Pet(petOld.getId(),petOld.getName(),master,petOld.getWeight());
                map.replace(petOld.getName(),petNew);
                set.add(petNew);
                set.remove(petOld);
                break;
            }
        }
    }

    /**
     * Меняем имя животного. При изменениии имени происходит изменение ключа, поэтому из карты производим
     * удаление и добавлениеэлемента целиком
     * @param petId
     * @param name
     */
    public void modifyPetNameById(int petId,String name){
        Iterator <Pet> it = set.iterator();
        Pet petNew;
        Pet petOld;
        while(it.hasNext()) {
            petOld=it.next();
            if (petOld.getId()==petId) {
                petNew=new Pet(petOld.getId(),name,petOld.getMaster(),petOld.getWeight());
                map.remove(petOld.getName(),petOld);
                map.put(petNew.getName(),petNew);
                set.add(petNew);
                set.remove(petOld);
                break;
            }
        }
    }

    /**
     * Вспомогательная функция печати коллекии из map
     */
    public void printUnsorted(){
        for (Map.Entry entry :map.entrySet()){
            System.out.println(entry.getKey()+","+entry.getValue());
        }
    }

    /**
     * Печать отсортированной картотеки
     */
    public void printSorted(){
        for(Pet pet:set)
            System.out.println(pet.toString());
    }


}
