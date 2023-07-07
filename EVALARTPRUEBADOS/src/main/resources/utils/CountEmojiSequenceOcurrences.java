package utils;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;


public class  CountEmojiSequenceOcurrences implements Task  {

    private String strEmojiSequenceToFind;
    private String strEmojiSeacrhText;
    
    public static Integer intEmojiSequenceOcurrences;

    public CountEmojiSequenceOcurrences (String strEmojiSequenceToFind, 
    String strEmojiSeacrhText)
    {
        this.strEmojiSequenceToFind = strEmojiSequenceToFind;
        this.strEmojiSeacrhText = strEmojiSeacrhText;
        intEmojiSequenceOcurrences =0;
    
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        
        String strIntermedia = strEmojiSeacrhText;
           
        int i=0;
        while(strIntermedia.length()>0 && i<strIntermedia.length())
        {
            
            if(strIntermedia.contains(strEmojiSequenceToFind))
            {
               
                intEmojiSequenceOcurrences++;
                Integer initIndex = strIntermedia.indexOf(strEmojiSequenceToFind)+
                strEmojiSequenceToFind.length();
                strIntermedia= strIntermedia.substring(initIndex);
            }
            i++;
        }
       
        
            
    }
    

    public static CountEmojiSequenceOcurrences doTask(String strEmojiSequenceToFind, 
    String strEmojiSeacrhText)
    {
        return Tasks.instrumented(CountEmojiSequenceOcurrences.class,
        strEmojiSequenceToFind, strEmojiSeacrhText);
    }
    
}
