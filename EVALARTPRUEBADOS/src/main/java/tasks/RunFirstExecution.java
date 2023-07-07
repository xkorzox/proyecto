package tasks;

import ui.EvalarAutomationTestPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;

public class RunFirstExecution implements Task{

    Target ENVIAR_BUTTON;

    public RunFirstExecution(Target ENVIAR_BUTTON) {
        
   
        this.ENVIAR_BUTTON = ENVIAR_BUTTON;
   
       
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        
        System.out.println("Into a run first execution");
            
            String strValueGetEmojiSequenceText="1";
            String strValueGetEmojiSearchTex ="2";
            String strValueGetTextMultiple ="3";
            String strValueGetCheckBoxes ="1";
            String strValueGetMathOperationTextWithSelect="1";
            String strValueMapOpSelect ="1";
            String strValueGetMathOperationTextWithButtons="2";
            String strValueContainerRadioButtons="2";
            

            actor.attemptsTo(
                CompleteEmojiSequenceBox.doTask(
                    strValueGetEmojiSearchTex, 
                    strValueGetEmojiSequenceText),
                //CompleteWriteNTimesXBox.doTask(),
                CompleteMultipleOfXBox.doTask(
                    strValueGetTextMultiple,
                    strValueGetCheckBoxes),

                CompleteMathematicOperationBoxWithSelect.doTask(
                        strValueGetMathOperationTextWithSelect,
                        strValueMapOpSelect),
                CompleteMathematicOperationBoxWithButtons.doTask(
                    strValueGetMathOperationTextWithButtons,
                   strValueContainerRadioButtons),
                
                    Click.on(ENVIAR_BUTTON));
        
        }
    public static RunFirstExecution doTask()
    {
        return Tasks.instrumented(RunFirstExecution.class,
        EvalarAutomationTestPage.ENVIAR_BUTTON);
    }
}
