package utils;

import java.util.ArrayList;
import java.util.List;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

public class StringWithLetterRepetedNTimes implements Task{

    public static String strOfRepetedLetter;
    private Integer intNTimes;
    private String strLetter;

    
    public StringWithLetterRepetedNTimes(Integer intNTimes, String strXText)
    {
        this.intNTimes = intNTimes;
        strLetter = strXText;
        strOfRepetedLetter = "";

    
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        
        strOfRepetedLetter = strLetter.repeat(intNTimes);
      
        
  
    }

    public static StringWithLetterRepetedNTimes doTask(Integer intNTimes, String strXText)
    {
        return Tasks.instrumented(StringWithLetterRepetedNTimes.class,
        intNTimes, strXText);
    }
    
}
