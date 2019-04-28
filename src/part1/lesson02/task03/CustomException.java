package part1.lesson02.task03;

/**
 * Класс реализации пользовательского исключения
 */


public class CustomException extends Exception {

        private String msg;

        public CustomException(String msg) {
            this.msg = msg;
        }

        @Override
        public String toString() {
            return "NegativeNumberException{" + "msg='" + msg + '\'' +'}';
        }
}
