package part1.lesson05.task01;

/**
 * Исключение выбрасывается в случае наличия животного с тем же именем в картотеке
 */

public class PetInCollectionException extends Exception{
    private String msg;

    public PetInCollectionException(String message) {
        this.msg = message;
    }

    @Override
    public String toString() {
        return "PetInCollectionException{" +
                "msg='" + msg + '\'' +
                '}';
    }
}
