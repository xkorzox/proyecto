package utils;


import java.util.ArrayList;
import java.util.List;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;


public class ProcessMultipleOfXText implements Task {

    public static Integer intNumber;
    private String strMultipleOfX;
    
    
 

    public ProcessMultipleOfXText(String strMultipleOfX)
    {
        this.strMultipleOfX = strMultipleOfX;

    
    }
    

    @Override
    public <T extends Actor> void performAs(T actor) {
    	
    	System.out.println(99+"oo");       String strTextToReplace="¿Cuáldetosnúmrstip?";
      
       for (int i = 0; i < strTextToReplace.length(); i++) {
        strMultipleOfX = strMultipleOfX.replace(strTextToReplace.charAt(i)+"", "");
        
    }
   
       strMultipleOfX = strMultipleOfX.replace(" ", "");
       
       intNumber = Integer.parseInt(strMultipleOfX);
      
      
        
  
    }
    public static ProcessMultipleOfXText doTask(String strMultipleOfX)
    {
        return Tasks.instrumented(ProcessMultipleOfXText.class,
        strMultipleOfX);
    }
    
}
