package part1.lesson06.task02;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;

/**
 * Класс генератор файлов.
 * Необходимо написать метод getFiles(String path, int n, int size, String[] words, int probability),
 * который создаст n файлов размером size в каталоге path. words - массив слов, probability - вероятность.
 */

public class FileGenerator {

    void getFiles(String path, int n, int size, String[] words, Double probability) {

        for(Integer i = 0; i<n;i++){
            String filename = path+i.toString()+".txt";
            try(PrintStream dos = new PrintStream(new FileOutputStream(filename))){
                Text text = new Text(size);
                text.genText(words,probability);
                dos.println(text.toString());
                text.printText();
            }
            catch (Exception ex){
                ex.printStackTrace();
            }
//            try(ByteArrayOutputStream bos = new ByteArrayOutputStream(new FileOutputStream(filename))){
//                Text text = new Text(size);
//                text.genText(words,probability);
//                byte[] buff = text.toString().getBytes();
//                bos.write(buff,0,size);
//                text.printText();
//            }
//            catch (Exception ex){
//                ex.printStackTrace();
//            }

        }
    }
}