package part1.lesson06.task02;

import java.io.FileOutputStream;
import java.io.PrintStream;
import java.io.Serializable;

/**
 * Задание 2. Создать генератор текстовых файлов, работающий по следующим правилам:
 *
 * Предложение состоит из 1<=n1<=15 слов. В предложении после произвольных слов могут находиться запятые.
 * Слово состоит из 1<=n2<=15 латинских букв
 * Слова разделены одним пробелом
 * Предложение начинается с заглавной буквы
 * Предложение заканчивается (.|!|?)+" "
 * Текст состоит из абзацев. в одном абзаце 1<=n3<=20 предложений. В конце абзаца стоит разрыв строки и перенос каретки.
 * Есть массив слов 1<=n4<=1000. Есть вероятность probability вхождения одного из слов этого массива в
 * следующее предложение (1/probability).
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

        }


    }
}
