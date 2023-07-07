package utils;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;


public class ProcessDateText implements Task {

    public static String strProccecedDateText;
    private String strDateText;
    
    
 

    public ProcessDateText(String strDateText)
    {
        this.strDateText = strDateText;

    
    }
    

    @Override
    public <T extends Actor> void performAs(T actor) {
       
        String strTextToReplace="Indiquelfchaquorspt:";
        String strProccecedDateTextCopy = strDateText;
       for (int i = 0; i < strTextToReplace.length(); i++) {
        strProccecedDateTextCopy = strProccecedDateTextCopy.replace(strTextToReplace.charAt(i)+"", "");
       }
      
       
       strProccecedDateTextCopy = strProccecedDateTextCopy.replace("/", "-");
      
       
       strProccecedDateText = strProccecedDateTextCopy;
      
       
      
        
  
    }
    public static ProcessDateText doTask(String strWriteNTimesXText)
    {
        return Tasks.instrumented(ProcessDateText.class,
        strWriteNTimesXText);
    }
    
}
