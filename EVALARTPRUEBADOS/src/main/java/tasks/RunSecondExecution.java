package tasks;

import ui.EvalarAutomationTestPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;

public class RunSecondExecution implements Task{

    Target ENVIAR_BUTTON;

    public RunSecondExecution(Target ENVIAR_BUTTON) {
        
   
        this.ENVIAR_BUTTON = ENVIAR_BUTTON;
   
       
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        
        System.out.println("Into a run first execution");
            
            String strValueGetMathOperationTextWithButtons="1";
            String strValueContainerRadioButtons="1";
            String strValueGetMathOperationTextWithSelect="2";
            String strValueMapOpSelect ="1";
            String strValueWriteNTimesText="2";
            String strValueWriteNTimesTextArea ="1";
            String strValueDateText = "3";
            /*
            String strValueGetEmojiSequenceText="1";
            String strValueGetEmojiSearchTex ="2";
            String strValueGetTextMultiple ="3";
            String strValueGetCheckBoxes ="1";
      
             */
            

            actor.attemptsTo(
                /* 
                CompleteMathematicOperationBoxWithButtons.doTask(
                    strValueGetMathOperationTextWithButtons,
                   strValueContainerRadioButtons),
                   CompleteMathematicOperationBoxWithSelect.doTask(
                        strValueGetMathOperationTextWithSelect,
                        strValueMapOpSelect),
                
                        CompleteWriteNTimesXBox.doTask(
                            strValueWriteNTimesText,
                            strValueWriteNTimesTextArea)
               */
              CompleteDateBox.doTask(
                strValueDateText)
               
                
                    //Click.on(ENVIAR_BUTTON)
                    );
        
        }
    public static RunSecondExecution doTask()
    {
        return Tasks.instrumented(RunSecondExecution.class,
        EvalarAutomationTestPage.ENVIAR_BUTTON);
    }
}
