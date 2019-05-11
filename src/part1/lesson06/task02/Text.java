package part1.lesson06.task02;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class Text implements Serializable {
    private List<Abstract> text = new LinkedList<>();

    public void genText(String [] wordsArray, Double probability){
        for(int i=0;i<20;i++) {
            Abstract abstr = new Abstract(wordsArray,probability);
            abstr.genAbstract();
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
