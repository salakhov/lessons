package part1.lesson06.task02;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;

/**
 * Класс генератор файлов.
 * Необходимо написать метод getFiles(String path, int n, int size, String[] words, int probability),
 * который создаст n файлов размером size в каталоге path. words - массив слов, probability - вероятность.
 */

public class FileGenerator {

    void getFiles(String path, int n, int size, String[] words, Double probability) {
        for (int i = 0; i < n; i++) {
            String filename = path + i + ".txt";
            try (FileOutputStream out = new FileOutputStream(filename);
                 BufferedOutputStream bos = new BufferedOutputStream(out)) {
                Text text = new Text(size);
                text.genText(words, probability);
                byte[] buff = text.toString().getBytes();
                bos.write(buff, 0, size);
                text.printText();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}