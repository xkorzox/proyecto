package tasks;
import java.util.ArrayList;
import java.util.List;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.targets.TargetBuilder;
import net.serenitybdd.screenplay.ui.Select;
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


public class CompleteMathematicOperationBoxWithSelect implements Task{
    
    TargetBuilder<Target> SELECT_MATHEMATIC_OPERATION_BUILDER;
    String  XPath_SELECT_MATHEMATIC_OPERATION;
    Target SELECT_MATHEMATIC_OPERATION;
    String strValueGetMathOperationText;
    String strValueMapOpSelect;

    public CompleteMathematicOperationBoxWithSelect( String strValueGetMathOperationText,
    String strValueMapOpSelect, String XPath_SELECT_MATHEMATIC_OPERATION, 
    TargetBuilder<Target> SELECT_MATHEMATIC_OPERATION_BUILDER) {

        this.strValueGetMathOperationText= strValueGetMathOperationText;
        this.strValueMapOpSelect = strValueMapOpSelect;
        this.XPath_SELECT_MATHEMATIC_OPERATION = XPath_SELECT_MATHEMATIC_OPERATION;
        this.SELECT_MATHEMATIC_OPERATION_BUILDER = SELECT_MATHEMATIC_OPERATION_BUILDER;
       
   
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

        actor.attemptsTo( FormatXPath.withGeneral(
            XPath_SELECT_MATHEMATIC_OPERATION
            , SELECT_MATHEMATIC_OPERATION_BUILDER,
            strValueMapOpSelect));
        
            SELECT_MATHEMATIC_OPERATION =  FormatXPath.GENERAL_OPTION_TARGET;
        
        actor.attemptsTo(
            Select.option(intResult+"").from(SELECT_MATHEMATIC_OPERATION)
            );


    }

    public static CompleteMathematicOperationBoxWithSelect doTask(String strValueGetMathOperationText,
    String strValueMapOpSelect)
    {
        return Tasks.instrumented(CompleteMathematicOperationBoxWithSelect.class,
        strValueGetMathOperationText,strValueMapOpSelect,
        EvalarAutomationTestPage.XPath_SELECT_MATHEMATIC_OPERATION,
        EvalarAutomationTestPage.SELECT_MATHEMATIC_OPERATION_BUILDER);
    }
    
}
