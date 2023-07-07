package utils;


import java.util.ArrayList;
import java.util.List;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;


public class ProcessMathematicOperationText implements Task {

   
    private String strOperationText;
    public static List<Long> listOperands;
    public static List<String> lisOperators;
    
 

    public ProcessMathematicOperationText(String strOperationText)
    {
        this.strOperationText = strOperationText;
        listOperands = new ArrayList<>();
        lisOperators = new ArrayList<>();
    
    }
    

    @Override
    public <T extends Actor> void performAs(T actor) {
        strOperationText =strOperationText
        .replace("?","");

        strOperationText =strOperationText
        .replace("=","");

        strOperationText =strOperationText
        .replace(" ","");
        
        //Permite separar digitos y operaciones en strings diferentes sin importar el tamaño del digito...Si hay digitos consecutivos se toman como un unico número
        String [] vecOperationText = strOperationText
        .split("(?<=\\d)(?=\\D)|(?<=\\D)(?=\\d)");
        
        for (int i = 0; i < vecOperationText.length ; i++) {
            String strItem = vecOperationText[i];
           
            try {

                listOperands.add(Long.parseLong(strItem));
                
            } catch (Exception e) {
                lisOperators.add(strItem);
                
            }
            
        }        
  
    }
    public static ProcessMathematicOperationText doTask(String strOperationText)
    {
        return Tasks.instrumented(ProcessMathematicOperationText.class, strOperationText);
    }
    
}
