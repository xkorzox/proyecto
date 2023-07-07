package tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import questions.GetMathematicOperationText;
import questions.GetRepetitionsText;
import ui.EvalarAutomationTestPage;
import net.serenitybdd.screenplay.targets.Target;
import utils.StringToInteger;
public class RepeatAutomationNTimes implements Task {
    Target ENVIAR_BUTTON;
    public static Integer intRepetitions;
    public RepeatAutomationNTimes(Target ENVIAR_BUTTON) {
        
        intRepetitions=0;
        this.ENVIAR_BUTTON = ENVIAR_BUTTON;
   
       
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
      
        actor.asksFor(
            GetRepetitionsText.make());
        String strRepetitions = GetRepetitionsText.strRepetitionsQuantityText;
      
        actor.attemptsTo(StringToInteger
        .with(strRepetitions.length()-2, 
        strRepetitions.length(), strRepetitions));
        
       
        intRepetitions =StringToInteger.intResult;
        System.out.println("Cantidad Repeticiones: "+ intRepetitions);
            
        for (int i = 1; i<= 1; i++) {
            System.out.println("---------- Iteración: "+ i+" ------------");
            if(i==1)
            {
                
                actor.attemptsTo(
                    RunFirstExecution.doTask(),
                    RunSecondExecution.doTask());
                
            }
        }

        
    }

    public static RepeatAutomationNTimes doTask()
    {
        return Tasks.instrumented(RepeatAutomationNTimes.class,
        EvalarAutomationTestPage.ENVIAR_BUTTON);
    }
    
}
