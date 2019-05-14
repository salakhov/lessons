package part1.lesson06.task02;


import java.io.Serializable;
import java.util.*;

/**
 * Класс абзац, сериализуемый
 * abstr - Текст абзаца
 * wordsArray - масси строк для подмешивания в предложение
 * probability - вероятность нахождения слова в тексте
 * size - размер
 */
public class Abstract implements Serializable {
    private String abstr;
    private final String[] wordsArray;
    private final Double probability;

    public Abstract(String[] wordsArray, Double probability) {
        this.wordsArray = wordsArray;
        this.probability = probability;
    }

    /**
     * Функция генерирует слово с заданными параметрами
     * Слово состоит из 1<=n2<=15 латинских букв
     *
     * @return - слово маленькими буквами
     */

    private String genWord() {
        Random rnd = new Random();
        int count = 1 + rnd.nextInt(14);
        return org.apache.commons.lang3.RandomStringUtils.randomAlphabetic(count).toLowerCase();
    }

    /**
     * Генерирует слово для начала предложения в котором первое слово начинается с заглавной буквы
     *
     * @return - слово с зглавной буквы
     */
    private String genFirstWord() {

        String str = genWord();
        str = str.substring(0, 1).toUpperCase() + str.substring(1);
        return str;
    }

    /**
     * Функция возвращает размер абзаца
     *
     * @return целое число размер абзаца
     */
    public int getSize() {
        return this.toString().length();
    }

    /**
     * Функция генерирует предложение и подмешивает туда слово из массива слов
     *
     * @param word слово для подмешивания
     * @return - предложение с заглавной буквы с запятыми, слова разделены одним пробелом*
     * Предложение заканчивается (.|!|?)+" "
     */
    private String genSentence(String word) {
        char[] punktuation = {'.', '!', '?'};
        Random rnd = new Random();
        List<String> list = new ArrayList<>();

        //Генерируем массив слов + добавляем заветное слово
        list.add(genFirstWord());
        int wordsInSentence = 1 + rnd.nextInt(14);
        int wordPosition = 2 + rnd.nextInt(wordsInSentence);  //позиция слова для вставки не первое и не последнее
        for (int i = 1; i <= wordsInSentence; i++) {
            if (i == wordPosition) {
                list.add(word); // вставляем произвольно сгенерированное слово
            } else {
                list.add(genWord());
            }
        }
        //Определяем позиции запятых в предложении
        int comaPosition;
        //если предложение короткое, запятых обычно нет
        if (list.size() < 3)
            comaPosition = -1;
        else
            comaPosition = 1 + rnd.nextInt(list.size() - 1);
        //составляем слова в предложение и учитываем запятые
        String sentence = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            sentence = sentence + " " + list.get(i);
            if (i == comaPosition) {
                sentence = sentence + ", ";
            }
        }
        //Расставляем знаки препинания
        int finalComa = rnd.nextInt(3);
        sentence = sentence + punktuation[finalComa] + " ";

        return sentence;
    }

    private String genSentence() {
        return genSentence(null);
    }

    /**
     * Функция генерирования абзаца с учетом вероятности нахождения слова измассива слов
     */
    public void genAbstract() {
        Random rnd = new Random();
        int sentenceNumber = 1 + rnd.nextInt(19);
        this.abstr = "";

        for (int i = 1; i < sentenceNumber; i++) {
            Double count = i % probability;
            if (count == 0.0) {
                int wordNumber = rnd.nextInt(wordsArray.length);
                this.abstr = this.abstr + genSentence(wordsArray[wordNumber]);
            } else {
                this.abstr = this.abstr + genSentence();
            }
        }
    }

    @Override
    public String toString() {
        return this.abstr;
    }

    /**
     * Функция обрезки абзаца до необходимого значения
     *
     * @param size - размер абзаца
     */
    public void cutAbstractSize(int size) {
        String str = this.abstr.substring(0, size - 1);
        str += ".";
        this.abstr = str;
    }
}

