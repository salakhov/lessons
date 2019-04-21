package part1.lesson02.task01;

/**
 *  Класса предназначен для фомирования собственного исключения с формированием текста ошибки
 */

public class CustomException extends Exception {
    private String detail;

    public CustomException(String msg) {
        this.detail = msg;
    }

    @Override
    public String toString() {
        return "Пример своего варианта ошибки{" + "detail='" + detail + '\'' +'}';
    }
}
