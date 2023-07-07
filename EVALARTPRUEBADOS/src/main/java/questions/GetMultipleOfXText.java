package questions;
import java.util.ArrayList;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.targets.TargetBuilder;
import ui.EvalarAutomationTestPage;
import utils.FormatXPath;
public class GetMultipleOfXText implements Question <String> {
    
    public static String  strMultipleOfXText;
    String  XPath_MULTIPLE_OF_X_TEXT;
    String [] lisStrValues;
    TargetBuilder<Target> GENERAL_OPTION_BUILDER;
    Target MULTIPLE_OF_X_TEXT;
    

    public GetMultipleOfXText(String  XPath_MULTIPLE_OF_X_TEXT,
    TargetBuilder<Target> GENERAL_OPTION_BUILDER, String ... lisStrValues) {
     
      this.XPath_MULTIPLE_OF_X_TEXT= XPath_MULTIPLE_OF_X_TEXT;
      this.lisStrValues = lisStrValues;
      this.GENERAL_OPTION_BUILDER = GENERAL_OPTION_BUILDER;
	  }

    @Override
    public String answeredBy(Actor actor) {
      
      actor.attemptsTo(
        FormatXPath.withGeneral(XPath_MULTIPLE_OF_X_TEXT,
       GENERAL_OPTION_BUILDER, lisStrValues)
        );
       
        MULTIPLE_OF_X_TEXT= FormatXPath.GENERAL_OPTION_TARGET;
        
      strMultipleOfXText =MULTIPLE_OF_X_TEXT
      .resolveFor(actor).getText();
      
     
        return "";
    }


    public static GetMultipleOfXText make(String ... lisStrValues) {
		return new GetMultipleOfXText( EvalarAutomationTestPage.XPath_MULTIPLE_OF_X_TEXT,
    EvalarAutomationTestPage.MULTIPLE_OF_X_TEXT_BUILDER, lisStrValues);
	}
}
