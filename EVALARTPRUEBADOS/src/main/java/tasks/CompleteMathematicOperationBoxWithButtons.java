package tasks;
import java.util.ArrayList;
import java.util.List;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.targets.TargetBuilder;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import questions.GetMathematicOperationText;
import ui.EvalarAutomationTestPage;
import utils.DoMathematicalOperations;
import utils.FormatXPath;
import utils.ListStringToListInteger;
import utils.ProcessMathematicOperationText;


public class CompleteMathematicOperationBoxWithButtons implements Task{
    
    TargetBuilder<Target> RADIO_BUTTON_RESULT_BUILDER;
    String XPath_RADIO_BUTTON_RESULT;
    String [] listStrValues;
    Target RADIO_BUTTON_RESULT;
    String strValueGetMathOperationText;
    String strValueContainerRadioButtons;

    public CompleteMathematicOperationBoxWithButtons( String strValueGetMathOperationText,
    String strValueContainerRadioButtons, String XPath_RADIO_BUTTON_RESULT, 
    TargetBuilder<Target> RADIO_BUTTON_RESULT_BUILDER) {

        this.strValueGetMathOperationText= strValueGetMathOperationText;
        this.strValueContainerRadioButtons = strValueContainerRadioButtons;
        this.XPath_RADIO_BUTTON_RESULT = XPath_RADIO_BUTTON_RESULT;
        this.RADIO_BUTTON_RESULT_BUILDER = RADIO_BUTTON_RESULT_BUILDER;
        listStrValues = new String[2];
   
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        
        actor.asksFor(
            GetMathematicOperationText.make(
                strValueGetMathOperationText));
        String strMathematicOperation = GetMathematicOperationText.strMathematicOperationText;
        System.out.println( "TEXTO OPERACION MATEMATICA "+strMathematicOperation);
         
        actor.attemptsTo(ProcessMathematicOperationText
        .doTask(strMathematicOperation));
        List<Long> listOperands = ProcessMathematicOperationText.listOperands;
        List<String> lisOperators = ProcessMathematicOperationText.lisOperators;
        System.out.println("Operands"+listOperands.toString());
        System.out.println( "Operators"+lisOperators.toString());

        actor.attemptsTo(
            DoMathematicalOperations.doTask(listOperands, lisOperators));
        
        
        Long intResult= DoMathematicalOperations.intResult;
        System.out.println( "Resultado Operación "+intResult);

        listStrValues[0] = strValueContainerRadioButtons;
        listStrValues[1]= intResult+""; 
        actor.attemptsTo( FormatXPath.withGeneral(XPath_RADIO_BUTTON_RESULT
            , RADIO_BUTTON_RESULT_BUILDER,
            listStrValues));
        
        RADIO_BUTTON_RESULT =  FormatXPath.GENERAL_OPTION_TARGET;
        
        actor.attemptsTo(
            Click.on(RADIO_BUTTON_RESULT)
            );


    }

    public static CompleteMathematicOperationBoxWithButtons doTask(String strValueGetMathOperationText,
    String strValueContainerRadioButtons)
    {
        return Tasks.instrumented(CompleteMathematicOperationBoxWithButtons.class,
        strValueGetMathOperationText,strValueContainerRadioButtons,
        EvalarAutomationTestPage.XPath_RADIO_BUTTON_RESULT,
        EvalarAutomationTestPage.RADIO_BUTTON_RESULT_BUILDER);
    }
    
}
