package utils;


import java.util.ArrayList;
import java.util.List;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;


public class ProcessWriteNTimesXText implements Task {

    public static Integer intNTimes;
    public static String strXText;
    private String strWriteNTimesXText;
    
    
 

    public ProcessWriteNTimesXText(String strWriteNTimesXText)
    {
        this.strWriteNTimesXText = strWriteNTimesXText;

    
    }
    

    @Override
    public <T extends Actor> void performAs(T actor) {
       String strTextToReplace="Escribavecsltr";
       
       for (int i = 0; i < strTextToReplace.length(); i++) {
        strWriteNTimesXText = strWriteNTimesXText.replace(strTextToReplace.charAt(i)+"", "");
       }
       strWriteNTimesXText = strWriteNTimesXText.replace(" ", "");
       Integer intIndexComilla = strWriteNTimesXText.indexOf("'");
       Integer intIndexFinal = strWriteNTimesXText.length();
       String strAuxiliarText = strWriteNTimesXText.substring(intIndexComilla+1,intIndexFinal-1);
       strXText = strAuxiliarText;
       
       strAuxiliarText = strWriteNTimesXText.substring(0,intIndexComilla);
       intNTimes=Integer.parseInt(strAuxiliarText);
       
      
        
  
    }
    public static ProcessWriteNTimesXText doTask(String strWriteNTimesXText)
    {
        return Tasks.instrumented(ProcessWriteNTimesXText.class,
        strWriteNTimesXText);
    }
    
}
