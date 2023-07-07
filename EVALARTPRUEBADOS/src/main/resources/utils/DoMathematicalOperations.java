package utils;
import java.util.ArrayList;
import java.util.List;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import questions.GetMathematicOperationText;
import utils.FormatXPath;
import utils.ListStringToListInteger;
import utils.ProcessMathematicOperationText;

public class DoMathematicalOperations implements Task{

    List<Long> listOperands;
    List<String> lisOperators;
    public static Long intResult;

    public DoMathematicalOperations( List<Long> listOperands, List<String> lisOperators) {
        this.listOperands = listOperands;
        this.lisOperators = lisOperators;
        intResult= 0L;
    
   
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        List<Long> listOperandsCopy = listOperands;
        List<String> lisOperatorsCopy = lisOperators;

        int i =0;
        Long intInterResult=0L;
        while( i < lisOperatorsCopy.size()){
            
            if(lisOperatorsCopy.get(i).equals("*"))
            {
                intInterResult = listOperandsCopy.get(i) *  listOperandsCopy.get(i+1);
                listOperandsCopy.set(i, intInterResult);
                listOperandsCopy.remove(i+1);
                lisOperatorsCopy.remove(i);
               
                
              
            }else
            if(lisOperatorsCopy.get(i).equals("/"))
            {
                
                intInterResult = listOperandsCopy.get(i) /  listOperandsCopy.get(i+1);
                listOperandsCopy.set(i, intInterResult);
                listOperandsCopy.remove(i+1);
                lisOperatorsCopy.remove(i);
                
            }else{
                i++;
            }
           
            

        }
        

       
        intResult += listOperandsCopy.get(0);
        listOperandsCopy.remove(0);
        i =0;
        while( i < lisOperatorsCopy.size()){
            
            if(lisOperatorsCopy.get(i).equals("+"))
            {
                intResult+= listOperandsCopy.get(i);
                listOperandsCopy.remove(i);
                lisOperatorsCopy.remove(i);
                
         
              
            }else
            if(lisOperatorsCopy.get(i).equals("-"))
            {
                intResult-= listOperandsCopy.get(i);
                listOperandsCopy.remove(i);
                lisOperatorsCopy.remove(i);
                
            }else{
                i++;
            }
           

        }
        
      
    
    
    }
  

  public static DoMathematicalOperations doTask( List<Long> listOperands, List<String> lisOperators)
  {
      return Tasks.instrumented(DoMathematicalOperations.class,
      listOperands,
      lisOperators);
  }


    
}
