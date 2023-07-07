package utils;


import java.util.ArrayList;
import java.util.List;

import com.vdurmont.emoji.EmojiParser;
import com.vdurmont.emoji.EmojiParser.FitzpatrickAction;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;


public class ProcessEmojiSequenceText implements Task {

    public static String strEmojiSequenceToFind;
    private String strEmojiSequenceText;
    
    
 

    public ProcessEmojiSequenceText(String strEmojiSequenceText)
    {
        this.strEmojiSequenceText = strEmojiSequenceText;

    
    }
    

    @Override
    public <T extends Actor> void performAs(T actor) {
       String strTextToReplace="Indiquehaylsgutcao: ";
      
       for (int i = 0; i < strTextToReplace.length(); i++) {
        strEmojiSequenceText = strEmojiSequenceText.replace(strTextToReplace.charAt(i)+"", "");
        
        } 
        strEmojiSequenceText = EmojiParser.parseToAliases(strEmojiSequenceText, FitzpatrickAction.REMOVE);
        //remove all &zwj spaces 
        //strEmojiSequenceText = strEmojiSequenceText.replaceAll("[\\p{Cf}]", "");

       strEmojiSequenceToFind= strEmojiSequenceText;
       
       
  
    }
    public static ProcessEmojiSequenceText doTask(String strMultipleOfX)
    {
        return Tasks.instrumented(ProcessEmojiSequenceText.class,
        strMultipleOfX);
    }
    
}
