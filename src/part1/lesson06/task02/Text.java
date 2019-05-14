package part1.lesson06.task02;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

/**
 * Класс текст, состоит из абзацев. Текст в свойствах имеет размер, равный размеру файлов
 */

public class Text implements Serializable {
    private List<Abstract> text = new LinkedList<>();
    private int textsize;

    public Text(int textsize) {
        this.textsize = textsize;
    }

    /**
     * Функция генерирования текста.
     * @param wordsArray - массив слов, которые помешиваются в предложения
     * @param probability - вероятность нахождения слова
     */
    public void genText(String [] wordsArray, Double probability){
        int currentTextSize = 0;
        while(currentTextSize<=this.textsize){
            Abstract abstr = new Abstract(wordsArray,probability);
            abstr.genAbstract();
            int abstractSize = abstr.getSize();
            int perspectiveTextSize = currentTextSize+abstractSize;
            if (perspectiveTextSize>textsize){
                abstr.cutAbstractSize(textsize-currentTextSize);
            }
            currentTextSize+=abstractSize;
            text.add(abstr);
        }
    }

    public void printText(){
        for(Abstract str:text)
            System.out.println(str.toString());

    }

    @Override
    public String toString() {
        String returnStr="";
        for(Abstract abstr:text)
            returnStr=returnStr+abstr.toString()+"\n\r";
        return returnStr;
    }
}
