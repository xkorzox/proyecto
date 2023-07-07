package interactions;
import java.util.List;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.targets.TargetBuilder;
import ui.EvalarAutomationTestPage;
import utils.FormatXPath;
public class MultyClickDifferentButtons implements Interaction{

 

  
    List<Integer> listGeneral;
    String  XPath_GENERAL_OPTION;
    TargetBuilder<Target> GENERAL_OPTION_BUILDER;
    Target GENERAL_TARGET;
    String strValueContainer;
    
    public MultyClickDifferentButtons(String strValueContainer,List<Integer> listGeneral
    ,String  XPath_GENERAL_OPTION,
    TargetBuilder<Target> GENERAL_OPTION_BUILDER){
        this.strValueContainer = strValueContainer;
        this.listGeneral = listGeneral;
        this.XPath_GENERAL_OPTION = XPath_GENERAL_OPTION;
        this.GENERAL_OPTION_BUILDER= GENERAL_OPTION_BUILDER;
       
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        String [] listStrValues = new String[2];
        listStrValues[0] = strValueContainer;
        for (int i = 0; i < listGeneral.size(); i++) {
            listStrValues[1] = listGeneral.get(i)+"";

            actor.attemptsTo(
                FormatXPath.withGeneral(XPath_GENERAL_OPTION,GENERAL_OPTION_BUILDER, 
                listStrValues)
                );
            GENERAL_TARGET= FormatXPath.GENERAL_OPTION_TARGET;
            actor.attemptsTo(
                Click.on(GENERAL_TARGET)
                );
        }
       
       
        
        
        
    }

    public static MultyClickDifferentButtons doTask(String strValueContainer,List<Integer> listGeneral)
    {
        return Tasks.instrumented(MultyClickDifferentButtons.class, 
        strValueContainer,listGeneral, 
        EvalarAutomationTestPage.XPath_CHECK_BOX_RESULT,
        EvalarAutomationTestPage.CHECK_BOX_RESULT_BUILDER);
    }


 
}
