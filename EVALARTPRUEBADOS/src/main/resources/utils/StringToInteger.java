package utils;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;


public class StringToInteger implements Interaction{

    public static Integer intResult;
    private Integer intInit;
    private Integer intFinal;
    private String strText;
  

    public StringToInteger(Integer intInit, Integer intFinal, 
    String strText){
        this.intInit = intInit;
        this.intFinal = intFinal;
        this.strText = strText;
    }

    


    @Override
    public <T extends Actor> void performAs(T actor) {
        
        intResult= Integer.parseInt(strText
        .substring(intInit, intFinal));
    }


    
    public static StringToInteger with(Integer intInit, Integer intFinal, 
    String strTexts)
    {
        return Tasks.instrumented(StringToInteger.class, intInit, intFinal,
        strTexts);
    }

    
    
  
}
