package part1.lesson06.task02;


import java.io.Serializable;
import java.util.*;

/**
 * Задание 2. Создать генератор текстовых файлов, работающий по следующим правилам:
 *
 * DONE Предложение состоит из 1<=n1<=15 слов. В предложении после произвольных слов могут находиться запятые.
 * DONE Слово состоит из 1<=n2<=15 латинских букв
 * DONE Слова разделены одним пробелом
 * DONE Предложение начинается с заглавной буквы
 * DONE Предложение заканчивается (.|!|?)+" "
 * DONE Текст состоит из абзацев. в одном абзаце 1<=n3<=20 предложений. В конце абзаца стоит разрыв строки и перенос каретки.
 * Есть массив слов 1<=n4<=1000. Есть вероятность probability вхождения одного из слов этого массива в
 * следующее предложение (1/probability).
 * Необходимо написать метод getFiles(String path, int n, int size, String[] words, int probability),
 * который создаст n файлов размером size в каталоге path. words - массив слов, probability - вероятность.
 */
public class Abstract implements Serializable {
    private List<String> abstr;
    private String[] wordsArray;
    private Double probability;
    private int size;

    public Abstract(String[] wordsArray,Double probability) {
        this.abstr = new LinkedList<>();
        this.wordsArray = wordsArray;
        this.probability = probability;
    }

//    public Abstract(String[] wordsArray,Double probability,int size) {
//        this.abstr = new LinkedList<>();
//        this.wordsArray = wordsArray;
//        this.probability = probability;
//        this.size = size;
//    }

    public String genWord(){
        Random rnd=new Random();
        int count = 1+rnd.nextInt(14);
        return org.apache.commons.lang3.RandomStringUtils.randomAlphabetic(count).toLowerCase();
   }

   public String genFirstWord(){

        String str=genWord();
        str = str.substring(0,1).toUpperCase()+str.substring(1);
        return str;
   }

    public int getSize(){
        return this.toString().length();
    }

    public void setSize(int size){
        this.size = size;
    }


    public String genSentance(String word){
        char [] punktuation = {'.','!','?'};
        Random rnd = new Random();
        List <String>list = new ArrayList<>();

        //Генерируем массив слов + добавляем заветное слово
        list.add(genFirstWord());
        int wordsInSentence =1+rnd.nextInt(14);
        int wordPosition = 2+ rnd.nextInt(wordsInSentence);  //позиция слова для вставки не первое и не последнее
        for (int i=1;i<=wordsInSentence;i++){
            if(i==wordPosition){
                list.add(word);
            }
            else {
                list.add(genWord());
            }
        }

        //Определяем позиции запятых в предложении
        int comaPosition;
        //если предложение короткое, запятых обычно нет
        if (list.size()<3)
            comaPosition=-1;
        else
            comaPosition=1+rnd.nextInt(list.size()-1);


        //составляем слова в предложение и учитываем запятые
        String sentence=list.get(0);
        for(int i=1;i<list.size();i++){
            sentence=sentence+" "+ list.get(i);
            if(i==comaPosition){
                sentence= sentence+", ";
            }
        }

        //Расставляем знаки препинания
        int finalComa=rnd.nextInt(3);
        sentence=sentence+punktuation[finalComa] + " ";

        return sentence;
       //System.out.println(sentence);
    }
    public String genSentance(){
        return genSentance(null);
    }

    public void genAbstract(){
        Random rnd = new Random();
        int sentenceNumber = 1+rnd.nextInt(19);
        String str="";

        for(int i=1;i<sentenceNumber;i++){
            Double count=i%probability;
            if(count == 0.0){
                int wordNumber = rnd.nextInt(wordsArray.length);
                str = str+genSentance(wordsArray[wordNumber]);
            }
            else {
                str = str + genSentance();
            }
        }
        abstr.add(str);
    }

//    public void printAbstract(){
//        abstr.forEach(System.out::println);
 //   }

    @Override
    public String toString() {
        String returnStr="";
        for(String str:abstr)
            returnStr=returnStr+str.toString();
        return returnStr;
    }
}

