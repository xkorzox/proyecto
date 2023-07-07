package utils;

import java.util.ArrayList;

import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.targets.TargetBuilder;
import ui.EvalarAutomationTestPage;

public class FormatXPath implements Interaction{

    String strValue;
    String [] lisStrValues;
    TargetBuilder<Target> GENERAL_OPTION_BUILDER;
    public static Target GENERAL_OPTION_TARGET; 
  

    public FormatXPath(String strValue, TargetBuilder<Target> GENERAL_OPTION_BUILDER, String ... lisStrValues){
        this.strValue = strValue;
        this.lisStrValues =lisStrValues;
        this.GENERAL_OPTION_BUILDER = GENERAL_OPTION_BUILDER;
    }

    


    @Override
    public <T extends Actor> void performAs(T actor) {
        GENERAL_OPTION_TARGET= GENERAL_OPTION_BUILDER
        .locatedBy(String.format(strValue, lisStrValues));
        
    }


    
    public static FormatXPath withResult(ArrayList<String> arrayListValues)
    {
        return Tasks.instrumented(FormatXPath.class, 
        EvalarAutomationTestPage.XPath_RADIO_BUTTON_RESULT, arrayListValues, 
         EvalarAutomationTestPage.RADIO_BUTTON_RESULT_BUILDER);
    }

    public static FormatXPath withMultiple(ArrayList<String> arrayListValues)
    {
        return Tasks.instrumented(FormatXPath.class, 
        EvalarAutomationTestPage.XPath_CHECK_BOX_RESULT, arrayListValues, 
         EvalarAutomationTestPage.CHECK_BOX_RESULT_BUILDER);
    }

    public static FormatXPath withGeneral(String strValue, TargetBuilder<Target> GENERAL_OPTION_BUILDER, String ... lisStrValues)
    {
        return Tasks.instrumented(FormatXPath.class, 
        strValue, GENERAL_OPTION_BUILDER, lisStrValues);
    }

    
    
  
}
