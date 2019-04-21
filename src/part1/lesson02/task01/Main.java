package part1.lesson02.task01;

/**
 * Задание 1. Написать программу ”Hello, World!”. В ходе выполнения программы она должна выбросить исключение
 * и завершиться с ошибкой.
 * Смоделировав ошибку «NullPointerException»
 * Смоделировав ошибку «ArrayIndexOutOfBoundsException»
 * Вызвав свой вариант ошибки через оператор throw
*/

public class Main {

    public static void main(String[] args) {
        try{
            NullPointerExceptionDemo();
            ArrayIndexOutOfBoundExceptionDemo();
            CustomErrorDemo();
        } catch (NullPointerException e){
            e.printStackTrace();
        } catch (ArrayIndexOutOfBoundsException e){
            e.printStackTrace();
        } catch (CustomException e) {
            e.printStackTrace();
        }
    }

    /**
     * Моделирование NullPointerException
     */
    static void NullPointerExceptionDemo(){
        Integer num = null;
        if (num==4) {
            System.out.println(num.toString());
        }
    }

    /**
     * Моделирование ArrayIndexOutOfBoundsException
     */
    static void ArrayIndexOutOfBoundExceptionDemo(){
        int a[] = {1,2,3,4,5,6,7};
        a[65] = 4;
    }

    /**
     * Моделирование собственного варианта исключения
     */
    static void CustomErrorDemo() throws CustomException{
        throw new CustomException("ошибка в методе CustomErrorDemo");
    }
}

