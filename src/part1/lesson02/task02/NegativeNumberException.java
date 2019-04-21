package part1.lesson02.task02;

/**
 *  Класса предназначен для фомирования собственного исключения с формированием
 *  подробного текста ошибки
 */

public class NegativeNumberException extends Exception {
    private String msg;

    public NegativeNumberException(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "NegativeNumberException{" + "msg='" + msg + '\'' +'}';
    }


}
