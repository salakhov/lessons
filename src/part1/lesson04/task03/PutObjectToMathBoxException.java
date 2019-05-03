package part1.lesson04.task03;

public class PutObjectToMathBoxException extends Exception{

    private String msg;

    public PutObjectToMathBoxException(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "PutObjectToMAthBoxException{" + "msg='" + msg + '\'' +'}';
    }
}
