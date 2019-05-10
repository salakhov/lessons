package part1.lesson06.task01;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * Класс выполняющий операции с файлом.
 * Класс содержит ArrayList для чтения файла по строкам
 * TreeSet для хранениея и записи слов в отсортированном виде
 */

public class FileReaderWriter {
    private static Set<String> wordsSet = new TreeSet<>();
    private static List<String> stringList = new ArrayList<>();

    /**
     * Чтение файла по строкам. Каждую сроку проверяется на наличие нескольких слов. Разделитель " "
     * Кадое слово добавляется в Set
     * @param filename
     */
    public void ReadFile(String filename) {
        try{
            stringList = Files.readAllLines(Paths.get(filename));
            //Цикл по строкам в файле
            for(String strLine:stringList){

                if(strLine.contains(" ")) {
                    String[] str;
                    str = strLine.split(" ");
                    for (String word : str) {
                        wordsSet.add(word);
                    }
                }
                else {
                   wordsSet.add(strLine);
                }
            }
            stringList.forEach(System.out::println);
            System.out.println("---");
            wordsSet.forEach(System.out::println);
        }catch(IOException err){
            err.printStackTrace();
        }
    }

    /**
     * Записываем Set в файл
     * @param filename
     */

    public void WriteFile(String filename){

        try{
            Files.write(Paths.get(filename),wordsSet);
        }catch(IOException err){
            err.printStackTrace();
        }


    }
}
